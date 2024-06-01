package com.inovationbehavior.backend.service.impl;

import com.inovationbehavior.backend.mapper.IntelligenceMapper;
import com.inovationbehavior.backend.entity.intelligence.*;
import com.inovationbehavior.backend.service.intf.IntelligenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class IntelligenceServiceImpl implements IntelligenceService {
    @Autowired
    private IntelligenceMapper intelligenceMapper;


    @Override
    public CourseList getCourseByPage(Integer page, Integer size, String type) {
        Long count = intelligenceMapper.courseCount(type);
        Integer start = (page - 1) * size;
        List<Course> courses = intelligenceMapper.getCourseByPage(start, size, type);
        for (Course course : courses) {
            List<Lecturer> lecturers = intelligenceMapper.getLecturersByCourseId(course.get_id());
            course.setLecturers(lecturers);
        }
        CourseList result = new CourseList();
        result.setCount(count);
        result.setLists(courses);
        return result;
    }

    @Override
    public Course getCourseById(Long id) {
        Course result = intelligenceMapper.getCourseById(id);
        List<Lecturer> lecturers = intelligenceMapper.getLecturersByCourseId(result.get_id());
        result.setLecturers(lecturers);
        return result;
    }
}

