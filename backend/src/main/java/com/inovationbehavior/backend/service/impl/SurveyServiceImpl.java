package com.inovationbehavior.backend.service.impl;

import com.inovationbehavior.backend.mapper.SurveyMapper;
import com.inovationbehavior.backend.model.survey.AwardInfo;
import com.inovationbehavior.backend.model.survey.Survey;
import com.inovationbehavior.backend.service.intf.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    private SurveyMapper surveyMapper;
    @Override
    public void postSurvey(Survey survey) {
        surveyMapper.postSurvey(survey);
    }

    @Override
    public void postIdentification(String patentNo, String identification,String invitationCode) {
        LocalDateTime time = LocalDateTime.now();
        surveyMapper.postIdentification(patentNo,identification,invitationCode, time);
    }

    @Override
    public void postEnterprise(String patentNo, String enterprise,String invitationCode) {
        LocalDateTime time = LocalDateTime.now();
        surveyMapper.postEnterprise(patentNo,enterprise,invitationCode, time);
    }

    @Override
    public void postValue(String patentNo, String value,String invitationCode) {
        LocalDateTime time = LocalDateTime.now();
        surveyMapper.postValue(patentNo,value,invitationCode, time);
    }

    @Override
    public void postUsage(String patentNo, String usage,String invitationCode) {
        LocalDateTime time = LocalDateTime.now();
        surveyMapper.postUsage(patentNo, usage,invitationCode, time);
    }

    @Override
    public void postPolicy(String patentNo, String policy,String invitationCode) {
        LocalDateTime time = LocalDateTime.now();
        surveyMapper.postPolicy(patentNo, policy, invitationCode,time);
    }

    @Override
    public int postAwardInfo(AwardInfo requestData) {
        System.out.println(surveyMapper.checkAward(requestData.getPatentNo()));
        if(surveyMapper.checkAward(requestData.getPatentNo())==0){
            surveyMapper.postAwardInfo(requestData.getPatentNo(), requestData.getAward(),requestData.getAddress());
            return 1;
        }
        return 0;
    }
}
