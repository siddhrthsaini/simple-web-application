package org.task.core.course;

import org.task.core.common.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    private static Logger logger = LoggerFactory.getLogger(CourseController.class);

    @PostMapping("/create")
    public CommonResponse createCourse(@RequestBody Course course, @RequestHeader("locale") String locale)
            throws Exception
    {
        CourseHelper courseHelper = new CourseHelper();
        CommonResponse commonResponse = new CommonResponse();

        try
        {
            commonResponse = new CourseFieldValidation().validateCreateCourse(course, locale);
            if (!commonResponse.isValidRequest()) {
                return commonResponse;
            }

            commonResponse = new CourseBusinessValidation().businessValidateCourse(course, locale);
            if (!commonResponse.isValidRequest()) {
                return commonResponse;
            }

            Course courseResponse = courseHelper.createCourse(course, locale);
            commonResponse.setResponseObject(courseResponse);

        } catch (Throwable e)
        {
            e.printStackTrace();
        }
        return commonResponse;
    }

    @GetMapping("/view/{id}")
    public CommonResponse getCourseById(@PathVariable("id") String id, @RequestHeader("locale") String locale) throws Exception {

        CourseHelper courseHelper = new CourseHelper();
        CommonResponse commonResponse = new CommonResponse();

        try {
            Course course = courseHelper.getCourseById(id);
            commonResponse.setResponseObject(course);

        } catch (Throwable e) {
            e.printStackTrace();
        }
        return commonResponse;
    }

    @PutMapping("/update")
    public CommonResponse updateCourse(@RequestBody Course course, @RequestHeader("locale") String locale)
            throws Exception
    {
        CourseHelper courseHelper = new CourseHelper();
        CommonResponse commonResponse = new CommonResponse();

        try
        {

            commonResponse = new CourseBusinessValidation().businessValidateCourse(course, locale);
            if (!commonResponse.isValidRequest()) {
                return commonResponse;
            }

            courseHelper.updateCourse(course, locale);
            commonResponse.setResponseObject("Course Updated Successfully");

        } catch (Throwable e)
        {
            e.printStackTrace();
        }
        return commonResponse;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResponse deleteCourse(@PathVariable("id") String id, @RequestHeader("locale") String locale)
            throws Exception
    {
        CourseHelper courseHelper = new CourseHelper();
        CommonResponse commonResponse = new CommonResponse();

        try
        {

            commonResponse = new CourseBusinessValidation().businessValidateDeleteById(id, locale);
            if (!commonResponse.isValidRequest()) {
                return commonResponse;
            }

            courseHelper.deleteCourse(id, locale);
            commonResponse.setResponseObject("Course Deleted Successfully");

        } catch (Throwable e)
        {
            e.printStackTrace();
        }
        return commonResponse;
    }

}
