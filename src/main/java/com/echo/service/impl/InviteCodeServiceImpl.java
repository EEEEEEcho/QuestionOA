package com.echo.service.impl;

import com.echo.mapper.InviteCodeMapper;
import com.echo.service.InviteCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InviteCodeServiceImpl implements InviteCodeService {
    @Autowired
    private InviteCodeMapper inviteCodeMapper;

    @Override
    public Integer getInviteCodeById() {
        return inviteCodeMapper.getInviteCodeById("1430164023092969472");
    }

    @Override
    public void setInviteCode(Integer inviteCode) {
        inviteCodeMapper.updateInviteCodeById("1430164023092969472",inviteCode);
    }
}
