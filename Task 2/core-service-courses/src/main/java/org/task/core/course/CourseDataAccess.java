package org.task.core.course;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.task.core.common.dbUtil.WhiteRoseDBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseDataAccess {

    private static Logger logger = LoggerFactory.getLogger(CourseDataAccess.class);

    Connection connection;
    public CourseDataAccess() throws SQLException {
        connection = WhiteRoseDBUtil.getConnection();
    }

    public Course createCourse(Course course, String locale) throws Exception{
        String query = "INSERT INTO courses(id, name, courseid, description) " +
                "VALUES('"+course.getId()+"','"+course.getName()+"','"+course.getCourseID()+"','"+course.getDescription()+"');";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.executeUpdate();
        logger.info("----------------------Data Added-----------------------");

        return course;
    }

    public Course updateCourse(Course course, String locale) throws Exception{

        String query = "UPDATE courses SET name = '"+course.getName()+"' , courseid = '"+course.getCourseID()+"', description = '"+course.getDescription()+"' " +
                " WHERE id = '"+course.getId()+"';";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.executeUpdate();
        logger.info("----------------------Data Updated-----------------------");

        return course;
    }


    public Course getCourseById(String id) throws Exception {
        Connection connection = WhiteRoseDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        ResultSetHandler<Course> resultSetHandler = new BeanHandler<>(Course.class);

        String selectQuery = "select * from courses c where id = ? ;";
        Course course = queryRunner.query(connection, selectQuery, resultSetHandler, id);

        return course;
    }

    public Course getCourseByCourseID(String courseID) throws Exception {
        Connection connection = WhiteRoseDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        ResultSetHandler<Course> resultSetHandler = new BeanHandler<>(Course.class);

        String selectQuery = "select * from courses c where courseid = ? ;";
        Course course = queryRunner.query(connection, selectQuery, resultSetHandler, courseID);

        return course;
    }

    public Course getCourseByName(String name) throws Exception {
        Connection connection = WhiteRoseDBUtil.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        ResultSetHandler<Course> resultSetHandler = new BeanHandler<>(Course.class);

        String selectQuery = "select * from courses c where name = ? ;";
        Course course = queryRunner.query(connection, selectQuery, resultSetHandler, name);

        return course;
    }

    public void deleteCourse(String id) throws Exception{
        String query = "DELETE FROM courses WHERE id = '"+id+"' ;";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.executeUpdate();
        logger.info("----------------------Data Deleted-----------------------");

    }
}
