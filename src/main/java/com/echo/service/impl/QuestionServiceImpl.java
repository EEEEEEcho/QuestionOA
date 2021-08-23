package com.echo.service.impl;

import com.echo.mapper.QuestionMapper;
import com.echo.pojo.Question;
import com.echo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<Question> getQuestionByInfo(String questionInfoName) {
        return questionMapper.getQuestionByInfo(questionInfoName);
    }

    @Override
    public void deleteQuestionById(Integer questionId) {
        questionMapper.deleteQuestionById(questionId);
    }

    @Override
    public Question getQuestionById(Integer questionId) {
        return questionMapper.getQuestionById(questionId);
    }

    @Override
    public void updateQuestionById(Question question) {
        questionMapper.updateQuestionById(question);
    }

    @Override
    public void addQuestion(Question question) {
        questionMapper.addQuestion(question);
    }
}
