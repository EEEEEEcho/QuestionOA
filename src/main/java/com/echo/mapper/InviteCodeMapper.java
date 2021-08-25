package com.echo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InviteCodeMapper {
    public Integer getInviteCodeById(String id);

    public void updateInviteCodeById(@Param("id") String id, @Param("inviteCode") Integer inviteCode);
}
