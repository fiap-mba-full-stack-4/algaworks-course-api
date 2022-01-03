package com.algaworks.courseapi.entrypoint;

import java.util.List;

import com.algaworks.courseapi.core.usecase.CreateCourse;
import com.algaworks.courseapi.core.usecase.DeleteCourse;
import com.algaworks.courseapi.core.usecase.SearchCourse;
import com.algaworks.courseapi.core.usecase.UpdateCourse;
import com.algaworks.courseapi.entrypoint.request.CreateCourseRequest;
import com.algaworks.courseapi.entrypoint.response.CourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("cursos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class CourseController {

    private final SearchCourse searchCourse;
    private final CreateCourse createCourse;
    private final UpdateCourse updateCourse;
    private final DeleteCourse deleteCourse;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseResponse> create(
            @RequestBody final CreateCourseRequest createCourseRequest
    ) {
        final var createdCourseResponse = createCourse.execute(createCourseRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCourseResponse);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponse>> findAllByTerm(
            @RequestParam(name = "term", defaultValue = "", required = false) String term) {
        final var courseListResponse = searchCourse.allByTerm(term);
        return ResponseEntity.ok(courseListResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseResponse> findById(@PathVariable Long id) {
        final var courseResponse = searchCourse.byId(id);
        return ResponseEntity.ok(courseResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<CourseResponse> update(
            @PathVariable Long id,
            @RequestBody CreateCourseRequest toUpdateCourseRequest) {
        final var courseResponse = updateCourse.processById(id, toUpdateCourseRequest);
        return ResponseEntity.ok(courseResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CourseResponse> deleteById(
            @PathVariable(name = "id") Long id) {
        deleteCourse.processById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
