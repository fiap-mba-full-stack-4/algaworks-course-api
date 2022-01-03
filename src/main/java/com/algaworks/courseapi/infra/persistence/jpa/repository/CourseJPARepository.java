package com.algaworks.courseapi.infra.persistence.jpa.repository;

import java.util.List;

import com.algaworks.courseapi.core.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseJPARepository extends JpaRepository<Course, Long> {

    List<Course> findAllByNameContainingOrDescriptionContaining(String name, String description);
}
