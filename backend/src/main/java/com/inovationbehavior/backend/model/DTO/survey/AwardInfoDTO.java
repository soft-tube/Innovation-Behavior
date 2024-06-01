package com.inovationbehavior.backend.model.DTO.survey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwardInfoDTO {
    private String patentNo;
    private String award;
    private String address;
}
