package com.echo.service.impl;

import com.echo.mapper.QuestionInfoMapper;
import com.echo.mapper.UserMapper;
import com.echo.mapper.WorkTypeMapper;
import com.echo.pojo.QuestionInfo;
import com.echo.pojo.WorkType;
import com.echo.service.WorkTypeService;
import com.echo.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkTypeServiceImpl implements WorkTypeService {
    @Autowired
    private WorkTypeMapper workTypeMapper;
    @Autowired
    private QuestionInfoMapper questionInfoMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IDUtil idUtil;


    @Override
    public List<WorkType> findAllWorkType() {
        return workTypeMapper.findAllWorkType();
    }

    @Override
    public void updateWorkType(WorkType workType,String oldWorkType) {
        String newWorkType = workType.getName();
        //先更新工种表中的数据
        workTypeMapper.updateWorkType(workType);
        //将该工种的用户的工种字段进行更新
        userMapper.resetWorkType(newWorkType,oldWorkType);
        //将questionInfo表中的相应工种字段进行更新
        questionInfoMapper.resetWorkType(newWorkType,oldWorkType);
    }

    @Override
    public void deleteWorkType(Long id,String name) {
        //删掉工种，要将工种表中的工种删掉
        workTypeMapper.deleteWorkType(id);
        //将工种和题库关联表中所有的该工种题目删除
        questionInfoMapper.deleteQuestionInfoByWorkType(name);
        //重置以该工种为工种的用户的工种选项
        userMapper.resetWorkType("未选择",name);
    }

    @Override
    public int judgeName(String name) {
        return workTypeMapper.judgeName(name);
    }

    @Override
    public int judgeType(String type) {
        return workTypeMapper.judgeType(type);
    }

    @Override
    public void addWorkType(WorkType workType) {
        workTypeMapper.addWorkType(workType);
    }

    @Override
    public List<String> management(String workTypeName) {
        return questionInfoMapper.getQuestionInfoByWorkType(workTypeName);
    }

    @Override
    public void deleteByWorkTypeAndName(String workType, String name) {
        questionInfoMapper.deleteByWorkTypeAndName(workType,name);
    }

    @Override
    public void addQuestionInfos(String workTypeName, String[] questionInfos) {
        for (String question : questionInfos){
            QuestionInfo questionInfo = new QuestionInfo();
            questionInfo.setId(idUtil.getId());
            questionInfo.setName(question);
            questionInfo.setWorkType(workTypeName);
            questionInfoMapper.addQuestionInfo(questionInfo);
        }
    }

    @Override
    public WorkType findWorkTypeById(Long id) {
        return workTypeMapper.findWorkTypeById(id);
    }

}
