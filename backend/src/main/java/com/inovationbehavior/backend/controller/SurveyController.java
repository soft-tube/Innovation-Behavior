package com.inovationbehavior.backend.controller;

import com.inovationbehavior.backend.model.Result;
import com.inovationbehavior.backend.model.survey.AwardInfo;
import com.inovationbehavior.backend.model.survey.Survey;
import com.inovationbehavior.backend.service.intf.SurveyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/survey")
@RequiredArgsConstructor
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @PostMapping("")
    public Result postSurvey(@RequestBody Survey survey){
        surveyService.postSurvey(survey);
        return Result.success();
    }

    @PostMapping("/identification")
    public Result postIdentification(@RequestBody Map<String, String> requestData){
        String patentNo = requestData.get("patentNo");
        String identification = requestData.get("identification");
        String invitationCode = requestData.get("invitationCode");
        surveyService.postIdentification(patentNo,identification,invitationCode);
        return Result.success();
    }

    @PostMapping("/enterprise")
    public Result postEnterprise(@RequestBody Map<String, String> requestData){
        String patentNo = requestData.get("patentNo");
        String enterprise = requestData.get("enterprise");
        String invitationCode = requestData.get("invitationCode");
        surveyService.postEnterprise(patentNo,enterprise,invitationCode);
        return Result.success();
    }

    @PostMapping("/value")
    public Result postValue(@RequestBody Map<String, String> requestData){
        String patentNo = requestData.get("patentNo");
        String value = requestData.get("value");
        String invitationCode = requestData.get("invitationCode");
        surveyService.postValue(patentNo,value,invitationCode);
        return Result.success();
    }

    @PostMapping("/usage")
    public Result postUsage(@RequestBody Map<String, String> requestData){
        String patentNo = requestData.get("patentNo");
        String usage = requestData.get("usage");
        String invitationCode = requestData.get("invitationCode");
        surveyService.postUsage(patentNo,usage,invitationCode);
        return Result.success();
    }

    @PostMapping("/policy")
    public Result postPolicy(@RequestBody Map<String, String> requestData){
        String patentNo = requestData.get("patentNo");
        String policy = requestData.get("policy");
        String invitationCode = requestData.get("invitationCode");
        surveyService.postPolicy(patentNo,policy,invitationCode);
        return Result.success();
    }

    @PostMapping("/award")
    public Result postAwardInfo(@RequestBody AwardInfo requestData){
        int res = surveyService.postAwardInfo(requestData);
        if(res==1){
            return Result.success();
        }else{
            return Result.error("请勿重复领奖");
        }

    }
}
