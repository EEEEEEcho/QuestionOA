package com.echo.controller;

import com.echo.pojo.WorkType;
import com.echo.service.QuestionInfoService;
import com.echo.service.WorkTypeService;
import com.echo.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/worktype")
public class WorkTypeController {

    @Autowired
    private WorkTypeService workTypeService;
    @Autowired
    private IDUtil idUtil;
    @Autowired
    private QuestionInfoService questionInfoService;


    @GetMapping("/getAllWorkType")
    public String getAllWorkType(Model model){
        List<WorkType> workTypes = workTypeService.findAllWorkType();
        model.addAttribute("workTypeList",workTypes);
        return "worktype/worktype-list";
    }


    @GetMapping("/addWorkType")
    public String addWorkType(){
        return "worktype/worktype-add";
    }


    @PostMapping("/doAdd")
    public String doAdd(WorkType workType){
        workType.setId(idUtil.getId());
        workTypeService.addWorkType(workType);
        return "redirect:/worktype/getAllWorkType";
    }


    @GetMapping("/updateWorkType/{id}")
    public String updateWorkType(@PathVariable("id")Long id,Model model){
        WorkType workType = workTypeService.findWorkTypeById(id);
        String oldName = workType.getName();
        model.addAttribute("oldWorkType",oldName);
        model.addAttribute("workType",workType);
        return "worktype/worktype-update";
    }

    @PostMapping("/doUpdate")
    public String doUpdate(WorkType workType,String oldWorkType){
        workTypeService.updateWorkType(workType,oldWorkType);
        return "redirect:/worktype/getAllWorkType";
    }

    @GetMapping("/deleteWorkType/{workTypeId}/{workTypeName}")
    public String deleteWorkType(@PathVariable("workTypeId") Long workTypeId,@PathVariable("workTypeName")String workTypeName){
        workTypeService.deleteWorkType(workTypeId,workTypeName);
        return "redirect:/worktype/getAllWorkType";
    }

    @GetMapping("/management/{workTypeName}")
    public String management(@PathVariable("workTypeName")String workTypeName,Model model){
        List<String> questionInfoList =  workTypeService.management(workTypeName);
        model.addAttribute("workTypeName",workTypeName);
        model.addAttribute("questionInfoList",questionInfoList);
        return "worktype/worktype-management";
    }

    @GetMapping("/deleteQuestionInfo/{workTypeName}/{questionInfo}")
    public String deleteQuestionInfo(@PathVariable("workTypeName") String workTypeName,
                                           @PathVariable("questionInfo") String questionInfo,
                                           RedirectAttributes redirectAttributes){
        workTypeService.deleteByWorkTypeAndName(workTypeName, questionInfo);
        redirectAttributes.addAttribute("workTypeName",workTypeName);
        return "redirect:/worktype/management/{workTypeName}";
    }

    @GetMapping("/addQuestionInfo/{workTypeName}")
    public String addQuestionInfo(@PathVariable("workTypeName") String workTypeName,Model model){
        List<String> list = questionInfoService.getQuestionInfoWorkTypeNotHave(workTypeName);
        model.addAttribute("workTypeName",workTypeName);
        model.addAttribute("questionInfoList",list);
        return "worktype/worktype-questioninfo-add";
    }

    @PostMapping("/doAddQuestionInfo")
    public String doAddQuestionInfo(String workTypeName,String[] questionInfos,RedirectAttributes redirectAttributes){
        workTypeService.addQuestionInfos(workTypeName,questionInfos);
        redirectAttributes.addAttribute("workTypeName",workTypeName);
        return "redirect:/worktype/management/{workTypeName}";
    }
}
