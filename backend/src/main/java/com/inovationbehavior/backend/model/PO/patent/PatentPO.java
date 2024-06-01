package com.inovationbehavior.backend.model.PO.patent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatentPO {
    Integer _id;
    String no;
    String name;
    String summary;
    String link;
    Timestamp update_time;
    List<String> pdfs;
}
