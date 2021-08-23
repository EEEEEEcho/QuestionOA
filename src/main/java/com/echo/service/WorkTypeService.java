package com.echo.service;

import com.echo.pojo.WorkType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkTypeService {
    public List<WorkType> findAllWorkType();

    public void updateWorkType(WorkType workType,String oldWorkType);

    public void deleteWorkType(Long id,String name);

    public int judgeName(String name);

    public int judgeType(String type);

    public void addWorkType(WorkType workType);

    public List<String> management(String workTypeName);

    public void deleteByWorkTypeAndName(String workType,String name);

    public void addQuestionInfos(String workTypeName,String[] questionInfos);

    public WorkType findWorkTypeById(Long id);
}
