package com.echo.mapper;

import com.echo.pojo.QuestionInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionInfoMapper {
    public void deleteQuestionInfoByWorkType(@Param("workType") String workType);

    public void deleteQuestionInfoByName(@Param("name") String name);

    public void deleteByWorkTypeAndName(@Param("workType")String workType,@Param("name")String name);

    public List<String> getQuestionInfoByWorkType(@Param("workType")String workType);

    public List<String> getQuestionInfoWorkTypeNotHave(@Param("workType")String workType);

    public void addQuestionInfo(QuestionInfo questionInfo);

    public void resetWorkType(@Param("newWorkType") String newWorkType,@Param("oldWorkType") String oldWorkType);

    public QuestionInfo getQuestionInfoByWorkTypeAndName(@Param("questionInfoName") String questionInfoName,@Param("workType") String workType);
}
