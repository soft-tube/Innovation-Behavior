package com.inovationbehavior.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private Integer id;
    private String title;
    private String description;
    private String appln_id;
    private String owner;
    private String tel;
    private String value;
    private String time;
}
