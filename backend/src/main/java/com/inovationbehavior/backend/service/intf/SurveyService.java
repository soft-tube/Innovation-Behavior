package com.inovationbehavior.backend.service.intf;

import com.inovationbehavior.backend.model.survey.AwardInfo;
import com.inovationbehavior.backend.model.survey.Survey;

public interface SurveyService {
    void postSurvey(Survey survey);

    void postIdentification(String patentNo, String identification,String invitationCode);

    void postEnterprise(String patentNo, String enterprise,String invitationCode);

    void postValue(String patentNo, String value,String invitationCode);

    void postUsage(String patentNo, String usage,String invitationCode);

    void postPolicy(String patentNo, String policy,String invitationCode);

    int postAwardInfo(AwardInfo requestData);
}
