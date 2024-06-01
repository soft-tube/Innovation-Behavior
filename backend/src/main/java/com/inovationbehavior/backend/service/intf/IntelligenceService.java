package com.inovationbehavior.backend.service.intf;

import com.inovationbehavior.backend.entity.intelligence.Course;
import com.inovationbehavior.backend.entity.intelligence.CourseList;
import org.springframework.stereotype.Service;

@Service
public interface IntelligenceService {
    CourseList getCourseByPage(Integer page, Integer size, String type);

    Course getCourseById(Long id);
}
