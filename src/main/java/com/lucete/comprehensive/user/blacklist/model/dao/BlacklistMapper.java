package com.lucete.comprehensive.user.blacklist.model.dao;

import com.lucete.comprehensive.user.blacklist.model.dto.BlacklistDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface BlacklistMapper {
    List<BlacklistDTO> getAllBlacklistedMembers();

    void newBlacklistMember(@Param("memId") String memId,
                            @Param("blacklistReason") String blacklistReason,
                            @Param("blacklistStartDate") Date blacklistStartDate,
                            @Param("blacklistEndDate") Date blacklistEndDate);
}
