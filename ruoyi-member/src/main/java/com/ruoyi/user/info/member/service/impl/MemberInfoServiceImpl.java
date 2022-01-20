package com.ruoyi.user.info.member.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.user.info.member.mapper.MemberInfoMapper;
import com.ruoyi.user.info.member.domain.MemberInfo;
import com.ruoyi.user.info.member.service.IMemberInfoService;

/**
 * 会员信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-20
 */
@Service
public class MemberInfoServiceImpl implements IMemberInfoService 
{
    @Autowired
    private MemberInfoMapper memberInfoMapper;

    /**
     * 查询会员信息
     * 
     * @param memberId 会员信息主键
     * @return 会员信息
     */
    @Override
    public MemberInfo selectMemberInfoByMemberId(String memberId)
    {
        return memberInfoMapper.selectMemberInfoByMemberId(memberId);
    }

    /**
     * 查询会员信息列表
     * 
     * @param memberInfo 会员信息
     * @return 会员信息
     */
    @Override
    public List<MemberInfo> selectMemberInfoList(MemberInfo memberInfo)
    {
        return memberInfoMapper.selectMemberInfoList(memberInfo);
    }

    /**
     * 新增会员信息
     * 
     * @param memberInfo 会员信息
     * @return 结果
     */
    @Override
    public int insertMemberInfo(MemberInfo memberInfo)
    {
        memberInfo.setMemberId(UUID.getUUId());
        memberInfo.setCreateTime(DateUtils.getNowDate());
        return memberInfoMapper.insertMemberInfo(memberInfo);
    }

    /**
     * 修改会员信息
     * 
     * @param memberInfo 会员信息
     * @return 结果
     */
    @Override
    public int updateMemberInfo(MemberInfo memberInfo)
    {
        memberInfo.setUpdateTime(DateUtils.getNowDate());
        return memberInfoMapper.updateMemberInfo(memberInfo);
    }

    /**
     * 批量删除会员信息
     * 
     * @param memberIds 需要删除的会员信息主键
     * @return 结果
     */
    @Override
    public int deleteMemberInfoByMemberIds(String[] memberIds)
    {
        return memberInfoMapper.deleteMemberInfoByMemberIds(memberIds);
    }

    /**
     * 删除会员信息信息
     * 
     * @param memberId 会员信息主键
     * @return 结果
     */
    @Override
    public int deleteMemberInfoByMemberId(String memberId)
    {
        return memberInfoMapper.deleteMemberInfoByMemberId(memberId);
    }
}
