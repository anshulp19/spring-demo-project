package com.springboottutorial.course.api;

import com.springboottutorial.course.model.Course;
import com.springboottutorial.course.service.CourseService;
import com.springboottutorial.topic.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/topics/{topicId}/courses")
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses(@PathVariable @NonNull String topicId) {
        return courseService.getAllCourses(topicId);
    }

    @GetMapping(path = "{courseId}")
    public Course getCourse(@PathVariable @NonNull String courseId) {
        return courseService.getCourseById(courseId)
                .orElseThrow(() -> new EntityNotFoundException(courseId));
    }

    @PostMapping
    public void addCourse(@PathVariable @NonNull String topicId, @RequestBody @Valid @NonNull Course course){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @PutMapping(value = "{id}")
    public void updateCourse(@PathVariable @NonNull String topicId, @PathVariable @NonNull String id, @RequestBody @NonNull @Valid Course course) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @DeleteMapping(value = "{id}")
    public void deleteCourse(@PathVariable @NonNull String id) {
        courseService.deleteCourse(id);
    }
}
