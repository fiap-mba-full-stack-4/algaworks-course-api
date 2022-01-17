package com.algaworks.courseapi.core.usecase;

import java.util.List;

import com.algaworks.courseapi.core.gateway.CourseGateway;
import com.algaworks.courseapi.core.mapper.CourseMapper;
import com.algaworks.courseapi.entrypoint.response.CourseResponse;
import com.algaworks.courseapi.core.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SearchCourse {

    private final CourseGateway courseGateway;
    private final CourseMapper courseMapper;

    public List<CourseResponse> allByTerm(final String term) {
        final var courseList = courseGateway.findAllByTerm(term);
        return courseMapper.toResponse(courseList);
    }

    public CourseResponse byId(final Long id) {
        final var course = courseGateway.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Course [%s] not found", id)));

        return courseMapper.toResponse(course);
    }
}
