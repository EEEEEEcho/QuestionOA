package com.echo.controller;

import com.echo.pojo.UserInfo;
import com.echo.pojo.WorkType;
import com.echo.service.UserService;
import com.echo.service.WorkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private WorkTypeService workTypeService;

    @GetMapping("/getAll")
    public String getAllUsers(Model model){
        List<UserInfo> userList = userService.getAllUsers();
        model.addAttribute("userList",userList);
        return "/user/user-list";
    }

    @GetMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable("userId")Long userId){
        userService.deleteUser(userId);
        return "redirect:/user/getAll";
    }

    @GetMapping("/updateUser/{userId}")
    public String updateUser(@PathVariable("userId")Long userId,Model model){
        UserInfo user = userService.findUpdateInfoById(userId);
        List<WorkType> workTypeList = workTypeService.findAllWorkType();
        model.addAttribute("user",user);
        model.addAttribute("workTypeList",workTypeList);
        return "/user/user-update";
    }

    @RequestMapping(value = "/doUpdate",method = RequestMethod.POST)
    public String doUpdate(UserInfo userInfo){
        //System.out.println(userInfo);
        userService.updateUser(userInfo);
        return "redirect:/user/getAll";
    }
}
