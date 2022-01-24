package com.ruoyi.system.image.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.image.domain.ImageUrl;
import com.ruoyi.system.image.service.IImageUrlService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 图片路径Controller
 * 
 * @author ruoyi
 * @date 2022-01-24
 */
@RestController
@RequestMapping("/system/image")
public class ImageUrlController extends BaseController
{
    @Autowired
    private IImageUrlService imageUrlService;

    /**
     * 查询图片路径列表
     */
    @PreAuthorize("@ss.hasPermi('system:image:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImageUrl imageUrl)
    {
        startPage();
        List<ImageUrl> list = imageUrlService.selectImageUrlList(imageUrl);
        return getDataTable(list);
    }

    /**
     * 导出图片路径列表
     */
    @PreAuthorize("@ss.hasPermi('system:image:export')")
    @Log(title = "图片路径", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImageUrl imageUrl)
    {
        List<ImageUrl> list = imageUrlService.selectImageUrlList(imageUrl);
        ExcelUtil<ImageUrl> util = new ExcelUtil<ImageUrl>(ImageUrl.class);
        util.exportExcel(response, list, "图片路径数据");
    }

    /**
     * 获取图片路径详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:image:query')")
    @GetMapping(value = "/{imagePathId}")
    public AjaxResult getInfo(@PathVariable("imagePathId") String imagePathId)
    {
        return AjaxResult.success(imageUrlService.selectImageUrlByImagePathId(imagePathId));
    }

    /**
     * 新增图片路径
     */
    @PreAuthorize("@ss.hasPermi('system:image:add')")
    @Log(title = "图片路径", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ImageUrl imageUrl)
    {
        return toAjax(imageUrlService.insertImageUrl(imageUrl));
    }

    /**
     * 修改图片路径
     */
    @PreAuthorize("@ss.hasPermi('system:image:edit')")
    @Log(title = "图片路径", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ImageUrl imageUrl)
    {
        return toAjax(imageUrlService.updateImageUrl(imageUrl));
    }

    /**
     * 删除图片路径
     */
    @PreAuthorize("@ss.hasPermi('system:image:remove')")
    @Log(title = "图片路径", businessType = BusinessType.DELETE)
	@DeleteMapping("/{imagePathIds}")
    public AjaxResult remove(@PathVariable String[] imagePathIds)
    {
        return toAjax(imageUrlService.deleteImageUrlByImagePathIds(imagePathIds));
    }
}
