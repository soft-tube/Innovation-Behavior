package com.inovationbehavior.backend.model.DO.patent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatentDO {
    Integer _id;
    String no;
    String name;
    String summary;
    String link;
    Timestamp update_time;
    List<String> pdfs;
}
