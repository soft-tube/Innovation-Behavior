package com.inovationbehavior.backend.model.PO.intelligence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseListPO {

    List<CoursePO> lists;
    Long count;
}
