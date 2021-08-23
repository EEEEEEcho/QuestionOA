package com.echo.service;

import com.echo.pojo.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionService {
    public List<Question> getQuestionByInfo(String questionInfoName);

    public void deleteQuestionById(Integer questionId);

    public Question getQuestionById(Integer questionId);

    public void updateQuestionById(Question question);

    public void addQuestion(Question question);
}
