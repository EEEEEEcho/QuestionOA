package com.echo.mapper;

import com.echo.pojo.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper {
    public void deleteQuestionByInfo(@Param("questionInfoName") String questionInfoName);

    public List<Question> getQuestionByInfo(@Param("questionInfoName") String questionInfoName);

    public void deleteQuestionById(@Param("questionId") Integer questionId);

    public Question getQuestionById(@Param("questionId") Integer questionId);

    public void updateQuestionById(Question question);

    public void addQuestion(Question question);

    public List<String> getAllQuestionInfo();
}
