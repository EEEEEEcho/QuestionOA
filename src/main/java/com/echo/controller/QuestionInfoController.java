package com.echo.controller;

import com.echo.pojo.WorkType;
import com.echo.service.QuestionInfoService;
import com.echo.service.WorkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/questioninfo")
public class QuestionInfoController {

    @Autowired
    private QuestionInfoService questionInfoService;
    @Autowired
    private WorkTypeService workTypeService;

    @GetMapping("/getAllQuestionInfo")
    public String getAllQuestionInfo(Model model){
        List<String> questionInfoList = questionInfoService.getAllQuestionInfo();
        model.addAttribute("questionInfoList",questionInfoList);
        return "/questioninfo/questioninfo-list";
    }

    @GetMapping("/deleteQuestionInfo/{questionInfoName}")
    public String deleteQuestionInfo(@PathVariable("questionInfoName") String questionInfoName){
        questionInfoService.deleteQuestionInfoByName(questionInfoName);
        return "redirect:/questioninfo/getAllQuestionInfo";
    }

    @GetMapping("/addQuestionInfo")
    public String addQuestionInfo(Model model){
        List<WorkType> workTypeList = workTypeService.findAllWorkType();
        model.addAttribute("workTypeList",workTypeList);
        return "/questioninfo/questioninfo-add";
    }
    @PostMapping("/doAddQuestionInfo")
    public String doAddQuestionInfo(@RequestParam("questionFile")MultipartFile file,@RequestParam("workType")String workType){
        if (!file.isEmpty()){
            String fileName = file.getOriginalFilename();
            assert fileName != null;
            int lastIndex = fileName.lastIndexOf('.');
            String suffix = fileName.substring(lastIndex);
            if (suffix.equals(".docx") || suffix.equals(".doc")){
                try {
                    questionInfoService.addQuestionsToInfo(file,suffix,workType);
                    return "redirect:/questioninfo/getAllQuestionInfo";
                } catch (Exception e) {
                    e.printStackTrace();
                    return "redirect:/fail";
                }
            }
            return "redirect:/fail";
        }
        return "redirect:/fail";
    }
}
