package com.echo.service.impl;

import com.alibaba.fastjson.JSON;
import com.echo.mapper.QuestionInfoMapper;
import com.echo.mapper.QuestionMapper;
import com.echo.pojo.Question;
import com.echo.pojo.QuestionInfo;
import com.echo.service.QuestionInfoService;
import com.echo.util.IDUtil;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class QuestionInfoServiceImpl implements QuestionInfoService {
    @Autowired
    private QuestionInfoMapper questionInfoMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private IDUtil idUtil;

    //删除题库表中，所有与该工种关联的记录
//    @Override
//    public void deleteQuestionInfoByWorkType(String workType) {
//        questionInfoMapper.deleteQuestionInfoByWorkType(workType);
//    }

    @Override
    public void deleteQuestionInfoByName(String name) {
        //删除题库与工种的关联表
        questionInfoMapper.deleteQuestionInfoByName(name);
        //删除题库中的表
        questionMapper.deleteQuestionByInfo(name);
    }

    //获得题库表中，所有与该工种关联的记录
//    @Override
//    public List<String> getQuestionInfoByWorkType(String workType) {
//        return questionInfoMapper.getQuestionInfoByWorkType(workType);
//    }

//    @Override
//    public void deleteByWorkTypeAndName(String workType, String name) {
//        questionInfoMapper.deleteByWorkTypeAndName(workType,name);
//    }

    @Override
    public List<String> getQuestionInfoWorkTypeNotHave(String workType) {
        return questionInfoMapper.getQuestionInfoWorkTypeNotHave(workType);
    }

//    @Override
//    public void addQuestionInfo(QuestionInfo questionInfo) {
//        questionInfoMapper.addQuestionInfo(questionInfo);
//    }

    @Override
    public List<String> getAllQuestionInfo() {
        return questionMapper.getAllQuestionInfo();
    }

    @Override
    public void addQuestionsToInfo(MultipartFile file,String fileType ,String workType) throws Exception {
        String questionInfo = file.getOriginalFilename().split("\\.")[0];

        //先查询关联表中有没有信息
        QuestionInfo exist = questionInfoMapper.getQuestionInfoByWorkTypeAndName(questionInfo, workType);
        if (exist == null){
            //如果关联表中没有该记录，添加
            //向关联表中添加信息
            QuestionInfo q = new QuestionInfo();
            q.setId(idUtil.getId());
            q.setName(questionInfo);
            q.setWorkType(workType);
            questionInfoMapper.addQuestionInfo(q);
        }
        //否则，直接更新题库

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            set.add((char) (65 + i));
        }
        InputStream inputStream = file.getInputStream();
        String content = null;
        if (fileType.equals(".doc")) {
            HWPFDocument hwpfDocument = new HWPFDocument(inputStream);
            WordExtractor wordExtractor = new WordExtractor(hwpfDocument);
            content = wordExtractor.getText().replaceAll("\r\n", "|");
        } else {
            XWPFDocument xwpfDocument = new XWPFDocument(inputStream);
            XWPFWordExtractor wordExtractor = new XWPFWordExtractor(xwpfDocument);
            content = wordExtractor.getText().replaceAll("\n", "|");
        }
        System.out.println(content);
        //整个题目的正则
        String pattern = "(\\|?)\\d+、(.*?答案：\\D+)";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(content);
        //选项的正则
        String answerPattern = "((\\w+)、(.*))";
        Pattern answerCompile = Pattern.compile(answerPattern);

        while (matcher.find()) {
            String item = matcher.group(2);
            String[] split = item.split("\\|");
            //System.out.println(Arrays.toString(split));
            String title = split[0];
            String answer = split[split.length - 1].split("：")[1];
            List<String> options = new ArrayList<>();
            for (int i = 1; i < split.length - 1; i++) {
                Matcher answerMatter = answerCompile.matcher(split[i]);
                //在匹配之前一定要调用一下find方法
                while (answerMatter.find()) {
                    String opt = answerMatter.group(2) + ":" + answerMatter.group(3);
                    options.add(opt.trim());
                }
            }
            char[] chars = answer.toCharArray();
            String type = "";
            if (chars.length > 1) {
                type = "多选";
            } else {
                type = "单选";
            }
            List<Character> ansList = new ArrayList<>();
            for (char c : chars) {
                if (set.contains(c)){
                    ansList.add(c);
                }
            }
            Question question = new Question();
            question.setTitle(title);
            question.setOptions(JSON.toJSONString(options));
            question.setAnswer(JSON.toJSONString(ansList));
            question.setType(type);
            question.setQuestionInfo(questionInfo);
            question.setCreateTime(new Date());
            //System.out.println("Title: " + title + "," + "Options : " + JSON.toJSONString(options) + "," + "Answer :" + JSON.toJSONString(ansList));
            questionMapper.addQuestion(question);
        }
    }

}
