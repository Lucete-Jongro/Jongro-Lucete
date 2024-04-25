package com.lucete.comprehensive.user.blacklist.model.service;

import com.lucete.comprehensive.user.blacklist.model.dao.BlacklistMapper;
import com.lucete.comprehensive.user.blacklist.model.dto.BlacklistDTO;
import com.lucete.comprehensive.user.member.model.dao.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class BlacklistService {
    @Autowired
    private BlacklistMapper blacklistMapper;
    public List<BlacklistDTO> getAllBlacklistedMembers(){
        List<BlacklistDTO> blacklistDTOS =blacklistMapper.getAllBlacklistedMembers();
        return blacklistDTOS;
    }

    public void newBlacklistMember(String memId , String blacklistReason, Date blacklistStartDate,Date blacklistSEndDate){
        blacklistMapper.newBlacklistMember(memId,blacklistReason,blacklistStartDate,blacklistSEndDate);

    }

}
