package com.inovationbehavior.backend.model.PO.intelligence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LecturerPO {
    Long _id;
    String name_en;
    String name_zn;
    String name_de;
    Long course_id;
}
