package com.inovationbehavior.backend.model.DTO.survey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyDTO {
    private String patentNo;
    private String identification;
    private String enterprise;
    private String value;
    private String usage;
    private String policy;
    private String invitationCode;
}
