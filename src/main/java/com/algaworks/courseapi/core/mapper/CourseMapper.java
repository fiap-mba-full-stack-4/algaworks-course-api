package com.algaworks.courseapi.core.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.algaworks.courseapi.core.entity.Course;
import com.algaworks.courseapi.entrypoint.request.CreateCourseRequest;
import com.algaworks.courseapi.entrypoint.response.CourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourseMapper {

    private final ModuleMapper moduleMapper;

    public Course toCourse(final CreateCourseRequest createCourseRequest) {
        final var modules = createCourseRequest.getModules().stream()
                .map(moduleMapper::toModule)
                .collect(Collectors.toList());

        return Course.builder()
                .name(createCourseRequest.getName())
                .description(createCourseRequest.getDescription())
                .level(createCourseRequest.getLevel())
                .originalPrice(createCourseRequest.getOriginalPrice())
                .promotionalPrice(createCourseRequest.getPromotionalPrice())
                .percentageDiscount(createCourseRequest.getPercentageDiscount())
                .imageUrl(createCourseRequest.getImageUrl())
                .modules(modules)
                .build();
    }

    public CourseResponse toResponse(final Course course) {
        final var moduleResponseList = course.getModules().stream()
                .map(moduleMapper::toResponse)
                .collect(Collectors.toList());

        return CourseResponse.builder()
                .id(course.getId())
                .name(course.getName())
                .description(course.getDescription())
                .level(course.getLevel())
                .originalPrice(course.getOriginalPrice())
                .promotionalPrice(course.getPromotionalPrice())
                .percentageDiscount(course.getPercentageDiscount())
                .modules(moduleResponseList)
                .imageUrl(course.getImageUrl())
                .build();

    }

    public List<CourseResponse> toResponse(final List<Course> courseList) {
        return courseList.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public Course updateCourse(final Course currentCourse, final CreateCourseRequest toUpdateCourseRequest) {
        final var newCourse = this.toCourse(toUpdateCourseRequest);
        newCourse.setId(currentCourse.getId());
        return newCourse;
    }
}
