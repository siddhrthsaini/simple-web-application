package org.task.core.course;

import org.task.core.common.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CourseBusinessValidation {

    private static Logger logger = LoggerFactory.getLogger(CourseBusinessValidation.class);

    public CommonResponse businessValidateCourse(Course course, String locale) throws Exception {
        CommonResponse commonResponse = new CommonResponse();
        List<String> errorList = ValidateCourse(course, locale);
        logger.info("-------In businessValidateCourse-----------Error Size : {} ",errorList.size());
        if(!errorList.isEmpty()) {
            commonResponse.setResponseMessage("FAILURE");
            commonResponse.setResponseObject(errorList);
            commonResponse.setResponseCode("400");
            commonResponse.setValidRequest(false);
        }
        return commonResponse;
    }

    public CommonResponse businessValidateDeleteById(String id, String locale) throws Exception {
        CommonResponse commonResponse = new CommonResponse();
        List<String> errorList = ValidateDeleteById(id, locale);
        logger.info("-------In businessValidateCourse-----------Error Size : {} ",errorList.size());
        if(!errorList.isEmpty()) {
            commonResponse.setResponseMessage("FAILURE");
            commonResponse.setResponseObject(errorList);
            commonResponse.setResponseCode("400");
            commonResponse.setValidRequest(false);
        }
        return commonResponse;
    }

    private List<String> ValidateCourse(Course course, String locale) throws Exception {

        List<String> errorList = new ArrayList<>();
        CourseHelper courseHelper = new CourseHelper();
        Course courseDB = courseHelper.getCourseByCourseID(course.getCourseID());
        if(courseDB != null) {
            errorList.add("Course already exists with this Course ID");
        }

        Course courseByName = courseHelper.getCourseByName(course.getName());
        if(courseByName != null) {
            errorList.add("Course already exists with this Name");
        }

        return errorList;
    }

    private List<String> ValidateDeleteById(String id, String locale) throws Exception {

        List<String> errorList = new ArrayList<>();
        CourseHelper courseHelper = new CourseHelper();
        Course courseDB = courseHelper.getCourseById(id);
        if(courseDB == null) {
            errorList.add("Course doesn't exists");
        }

        return errorList;
    }
}
