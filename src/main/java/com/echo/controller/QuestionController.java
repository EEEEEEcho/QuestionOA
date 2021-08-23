package com.echo.controller;

import com.echo.pojo.Question;
import com.echo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @GetMapping("/getQuestionByInfo/{questionInfo}")
    public String getQuestionByInfo(@PathVariable("questionInfo") String questionInfo, Model model){
        List<Question> questionList = questionService.getQuestionByInfo(questionInfo);
        model.addAttribute("questionList",questionList);
        model.addAttribute("questionInfo",questionInfo);
        return "/question/question-list";
    }

    @GetMapping("/deleteQuestion/{questionId}/{questionInfo}")
    public String deleteQuestion(@PathVariable("questionId")Integer questionId,
                                 @PathVariable("questionInfo") String questionInfo,
                                 RedirectAttributes redirectAttributes){
        questionService.deleteQuestionById(questionId);
        redirectAttributes.addAttribute("questionInfo",questionInfo);
        return "redirect:/question/getQuestionByInfo/{questionInfo}";
    }

    @GetMapping("/updateQuestion/{questionId}")
    public String updateQuestion(@PathVariable("questionId")Integer questionId,Model model){
        Question question = questionService.getQuestionById(questionId);
        model.addAttribute("question",question);
        return "/question/question-update";
    }

    @PostMapping("/doUpdateQuestion")
    public String doUpdateQuestion(Question question,RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("questionInfo",question.getQuestionInfo());
        //System.out.println(question.getQuestionInfo());
        questionService.updateQuestionById(question);
        return "redirect:/question/getQuestionByInfo/{questionInfo}";
    }
    @GetMapping("/addQuestion/{questionInfo}")
    public String addQuestion(@PathVariable("questionInfo") String questionInfo,Model model){
        model.addAttribute("questionInfo",questionInfo);
        return "/question/question-add";
    }

    @PostMapping("/doAddQuestion")
    public String doAddQuestion(Question question,RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("questionInfo",question.getQuestionInfo());
        questionService.addQuestion(question);
        return "redirect:/question/getQuestionByInfo/{questionInfo}";
    }
}
