package org.task.core.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CourseHelper {

    private static Logger logger = LoggerFactory.getLogger(CourseHelper.class);

    public Course createCourse(Course course, String locale) throws Exception {
        logger.info("----------inside createCourse------------");

        CourseDataAccess courseDataAccess = new CourseDataAccess();
        Course courseData = courseDataAccess.createCourse(course, locale);

        return courseData;
    }

    public Course getCourseById(String id) throws Exception {
        logger.info("----------inside getCourseById------------");
        CourseDataAccess courseDataAccess = new CourseDataAccess();
        Course course = courseDataAccess.getCourseById(id);

        return course;
    }

    public Course getCourseByCourseID(String courseID) throws Exception {
        logger.info("----------inside getCourseByCourseID------------");
        CourseDataAccess courseDataAccess = new CourseDataAccess();
        Course course = courseDataAccess.getCourseByCourseID(courseID);

        return course;
    }

    public Course getCourseByName(String name) throws Exception {
        logger.info("----------inside getCourseByName------------");
        CourseDataAccess courseDataAccess = new CourseDataAccess();
        Course course = courseDataAccess.getCourseByName(name);

        return course;
    }

    public void updateCourse(Course course, String locale) throws Exception {
        logger.info("----------inside createCourse------------");

        CourseDataAccess courseDataAccess = new CourseDataAccess();
        Course courseDB = courseDataAccess.getCourseById(course.getId());
        courseDB.setName(course.getName());
        courseDB.setCourseID(course.getCourseID());
        courseDB.setDescription(course.getDescription());

        courseDataAccess.updateCourse(courseDB, locale);

    }

    public void deleteCourse(String id, String locale) throws Exception {
        logger.info("----------inside deleteCourse------------");

        CourseDataAccess courseDataAccess = new CourseDataAccess();
        courseDataAccess.deleteCourse(id);
    }
}
