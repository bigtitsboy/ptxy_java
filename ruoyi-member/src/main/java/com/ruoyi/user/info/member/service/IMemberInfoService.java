package com.ruoyi.user.info.member.service;

import java.util.List;
import com.ruoyi.user.info.member.domain.MemberInfo;

/**
 * 会员信息Service接口
 * 
 * @author ruoyi
 * @date 2022-01-20
 */
public interface IMemberInfoService 
{
    /**
     * 查询会员信息
     * 
     * @param memberId 会员信息主键
     * @return 会员信息
     */
    public MemberInfo selectMemberInfoByMemberId(String memberId);

    /**
     * 查询会员信息列表
     * 
     * @param memberInfo 会员信息
     * @return 会员信息集合
     */
    public List<MemberInfo> selectMemberInfoList(MemberInfo memberInfo);

    /**
     * 新增会员信息
     * 
     * @param memberInfo 会员信息
     * @return 结果
     */
    public int insertMemberInfo(MemberInfo memberInfo);

    /**
     * 修改会员信息
     * 
     * @param memberInfo 会员信息
     * @return 结果
     */
    public int updateMemberInfo(MemberInfo memberInfo);

    /**
     * 批量删除会员信息
     * 
     * @param memberIds 需要删除的会员信息主键集合
     * @return 结果
     */
    public int deleteMemberInfoByMemberIds(String[] memberIds);

    /**
     * 删除会员信息信息
     * 
     * @param memberId 会员信息主键
     * @return 结果
     */
    public int deleteMemberInfoByMemberId(String memberId);
}
