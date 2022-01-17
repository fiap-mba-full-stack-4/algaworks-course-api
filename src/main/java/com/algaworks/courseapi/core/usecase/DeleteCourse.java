package com.algaworks.courseapi.core.usecase;

import com.algaworks.courseapi.core.gateway.CourseGateway;
import com.algaworks.courseapi.core.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCourse {

    private final CourseGateway courseGateway;

    public void processById(Long id) {
        final var course = courseGateway.findById(id).orElseThrow(() -> new NotFoundException("a"));
        courseGateway.delete(course);
    }
}
