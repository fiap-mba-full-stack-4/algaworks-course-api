package com.algaworks.courseapi.core.usecase;

import com.algaworks.courseapi.core.gateway.CourseGateway;
import com.algaworks.courseapi.core.mapper.CourseMapper;
import com.algaworks.courseapi.entrypoint.request.CreateCourseRequest;
import com.algaworks.courseapi.entrypoint.response.CourseResponse;
import com.algaworks.courseapi.core.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCourse {

    private final CourseMapper courseMapper;
    private final CourseGateway courseGateway;

    public CourseResponse processById(Long id, CreateCourseRequest toUpdateCourseRequest) {
        final var currentCourse =
                courseGateway.findById(id).orElseThrow(() -> new NotFoundException("a"));
        final var newCourse = courseMapper.updateCourse(currentCourse, toUpdateCourseRequest);
        final var updatedCourse = courseGateway.save(newCourse);
        return courseMapper.toResponse(updatedCourse);
    }
}
