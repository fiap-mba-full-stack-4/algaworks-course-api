package com.algaworks.courseapi.infra.persistence.jpa.provider;

import java.util.List;
import java.util.Optional;

import com.algaworks.courseapi.core.entity.Course;
import com.algaworks.courseapi.core.gateway.CourseGateway;
import com.algaworks.courseapi.infra.persistence.jpa.repository.CourseJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseJPAProvider implements CourseGateway {

    private final CourseJPARepository courseJPARepository;

    @Override
    public Course save(final Course course) {
        return courseJPARepository.save(course);
    }

    @Override
    public Optional<Course> findById(final Long id) {
        return courseJPARepository.findById(id);
    }

    @Override
    public List<Course> findAllByTerm(final String term) {
        return courseJPARepository.findAllByNameContainingOrDescriptionContaining(term, term);
    }

    @Override
    public void delete(Course course) {
        courseJPARepository.delete(course);
    }
}
