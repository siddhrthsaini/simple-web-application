package org.task.core.course;

import org.task.core.common.AllEnum;
import org.task.core.common.CommonResponse;
import org.task.core.validation.Validation;
import org.task.core.validation.ValidationHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseFieldValidation {

    private static Logger logger = LoggerFactory.getLogger(CourseFieldValidation.class);

    public CommonResponse validateCreateCourse(Course course, String locale) throws Exception{

        CommonResponse commonResponse = new CommonResponse();
        Map<String, String> errors = validateCourse(course, locale);
        logger.info("Error Size : {} ",errors.size());
        if(errors.size() > 0) {
            commonResponse.setResponseMessage("FAILURE");
            commonResponse.setResponseObject(errors);
            commonResponse.setResponseCode("400");
            commonResponse.setValidRequest(false);
        }
        return commonResponse;
    }
    public Map<String, String> validateCourse(Course course, String locale) throws Exception{

        String module = AllEnum.Modules.course.name();
        Map<String, String> hashmap = new HashMap<>();
        ValidationHelper validationHelper = new ValidationHelper();
        String errorField = null;

        List<Validation> validationList = validationHelper.getValidationsList(module, locale);

        errorField = validationHelper.validateField(course.getCourseID(), "courseID", validationList);
        if (errorField != null) {
            hashmap.put("courseID", errorField);
        }

        errorField = validationHelper.validateField(course.getName(), "name", validationList);
        if (errorField != null) {
            hashmap.put("name", errorField);
        }

        return hashmap;
    }
}
