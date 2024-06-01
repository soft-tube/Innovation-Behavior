package com.inovationbehavior.backend.entity.intelligence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseList {

    List<Course> lists;
    Long count;
}
