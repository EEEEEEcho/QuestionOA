package com.echo.mapper;

import com.echo.pojo.WorkType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorkTypeMapper {
    public List<WorkType> findAllWorkType();

    public void updateWorkType(WorkType workType);

    public void deleteWorkType(@Param("id") Long id);

    public int judgeName(@Param("name") String name);

    public int judgeType(@Param("type") String type);

    public void addWorkType(WorkType workType);

    public WorkType findWorkTypeById(@Param("id") Long id);
}
