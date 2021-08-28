package com.echo.controller;

import com.echo.service.InviteCodeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inviteCode")
public class InviteCodeController {
    @Autowired
    private InviteCodeService inviteCodeService;

    @GetMapping("/getInviteCode")
    public String getInviteCode(Model model){
        Integer inviteCode = inviteCodeService.getInviteCodeById();
        model.addAttribute("inviteCode",inviteCode);
        return "invitecode/invitecode-list";
    }

    @GetMapping("/updateInviteCode/{inviteCode}")
    public String updateInviteCode(@PathVariable("inviteCode") Integer inviteCode, Model model){
//        System.out.println(inviteCode);
        model.addAttribute("inviteCode",inviteCode);
        return "invitecode/invitecode-update";
    }

    @PostMapping("/doUpdate")
    public String doUpdate(@RequestParam("inviteCode")Integer inviteCode){
        //System.out.println(inviteCode.getClass().getSimpleName());
        inviteCodeService.setInviteCode(inviteCode);
        return "redirect:/inviteCode/getInviteCode";
    }
}
