package com.algaworks.courseapi.core.gateway;

import java.util.List;
import java.util.Optional;

import com.algaworks.courseapi.core.entity.Course;

public interface CourseGateway {

    Course save(Course course);

    Optional<Course> findById(Long id);

    List<Course> findAllByTerm(String term);

    void delete(Course course);
}
