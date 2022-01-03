package com.algaworks.courseapi.core.usecase;

import com.algaworks.courseapi.core.gateway.CourseGateway;
import com.algaworks.courseapi.core.mapper.CourseMapper;
import com.algaworks.courseapi.entrypoint.request.CreateCourseRequest;
import com.algaworks.courseapi.entrypoint.response.CourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateCourse {

    private final CourseGateway courseGateway;
    private final CourseMapper courseMapper;

    public CourseResponse execute(final CreateCourseRequest createCourseRequest) {
        final var courseEntity = courseMapper.toCourse(createCourseRequest);
        final var createdCourse = courseGateway.save(courseEntity);
        return courseMapper.toResponse(createdCourse);
    }
}
