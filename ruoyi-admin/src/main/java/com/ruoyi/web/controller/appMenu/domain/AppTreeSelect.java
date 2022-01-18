package com.ruoyi.web.controller.appMenu.domain;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ruoyi.common.core.domain.entity.SysDept;


/**
 * Treeselect树结构实体类
 *
 * @author ruoyi
 */
public class AppTreeSelect implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 节点ID */
    private Long id;

    /** 节点名称 */
    private String label;

    /** 子节点 */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<com.ruoyi.web.controller.appMenu.domain.AppTreeSelect> children;

    public AppTreeSelect()
    {

    }

    public AppTreeSelect(SysDept dept)
    {
        this.id = dept.getDeptId();
        this.label = dept.getDeptName();
        this.children = dept.getChildren().stream().map(com.ruoyi.web.controller.appMenu.domain.AppTreeSelect::new).collect(Collectors.toList());
    }

    public AppTreeSelect(AppMenu menu)
    {
        this.id = menu.getMenuId();
        this.label = menu.getMenuName();
        this.children = menu.getChildren().stream().map(com.ruoyi.web.controller.appMenu.domain.AppTreeSelect::new).collect(Collectors.toList());
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public List<com.ruoyi.web.controller.appMenu.domain.AppTreeSelect> getChildren()
    {
        return children;
    }

    public void setChildren(List<com.ruoyi.web.controller.appMenu.domain.AppTreeSelect> children)
    {
        this.children = children;
    }
}
