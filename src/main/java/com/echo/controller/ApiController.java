package com.echo.controller;

import com.echo.service.WorkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private WorkTypeService workTypeService;

    @GetMapping("/judgeWorkTypeName")
    public int judgeWorkTypeName(@RequestParam("name") String name){
        return workTypeService.judgeName(name);
    }

    @GetMapping("/judgeWorkTypeType")
    public int judgeWorkTypeType(@RequestParam("type") String type){
        return workTypeService.judgeType(type);
    }
}
