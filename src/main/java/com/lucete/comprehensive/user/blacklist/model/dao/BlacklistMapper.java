package com.lucete.comprehensive.user.blacklist.model.dao;

import com.lucete.comprehensive.user.blacklist.model.dto.BlacklistDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlacklistMapper {
    List<BlacklistDTO> getAllBlacklistedMembers();
}
