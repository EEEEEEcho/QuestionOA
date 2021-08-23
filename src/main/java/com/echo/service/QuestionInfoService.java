package com.echo.service;

import com.echo.pojo.QuestionInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface QuestionInfoService {

    public void deleteQuestionInfoByName(String name);

//    public List<String > getQuestionInfoByWorkType(String workType);
//
//    public void deleteByWorkTypeAndName(String workType,String name);

    public List<String> getQuestionInfoWorkTypeNotHave(String workType);

//    public void addQuestionInfo(QuestionInfo questionInfo);

    public List<String> getAllQuestionInfo();

    public void addQuestionsToInfo(MultipartFile file,String fileType,String workType) throws Exception;
}
