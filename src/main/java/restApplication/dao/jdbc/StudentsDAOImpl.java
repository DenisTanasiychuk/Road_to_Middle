package restApplication.dao.jdbc;

import restApplication.da.Util;
import restApplication.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsDAOImpl extends Util implements StudentsDAO {

    Connection connection = getConnection();

    @Override
    public List<Student> getAllStudents() throws SQLException {
        List<Student> studentList = new ArrayList<>();

        String sql = "SELECT ID, FIRSTNAME, LASTNAME, MIDDLENAME, EMAIL, PHONE, BIRTHDAY, FACULT";
        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("ID"));
                student.setFirstName(resultSet.getString("FIRSTNAME"));
                student.setLastName(resultSet.getString("LASTNAME"));
                student.setMiddleName(resultSet.getString("MIDDLENAME"));
                student.setEmail(resultSet.getString("EMAIL"));
                student.setPhone(resultSet.getString("PHONE"));
                student.setBirthday(resultSet.getString("BIRTHDAY"));
                student.setFaculty(resultSet.getLong("FACULT"));

                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }

        return studentList;
    }

    @Override
    public List<Student> getStudentsOnLastname(String lastName) throws SQLException {
        List<Student> studentList = new ArrayList<>();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, FIRSTNAME, LASTNAME, MIDDLENAME, EMAIL, PHONE, BIRTHDAY, FACULTY FROM STUDENTS WHERE LASTNAME=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lastName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("ID"));
                student.setFirstName(resultSet.getString("FIRSTNAME"));
                student.setLastName(resultSet.getString("LASTNAME"));
                student.setMiddleName(resultSet.getString("MIDDLENAME"));
                student.setEmail(resultSet.getString("EMAIL"));
                student.setPhone(resultSet.getString("PHONE"));
                student.setBirthday(resultSet.getString("BIRTHDAY"));
                student.setFaculty(resultSet.getLong("FACULT"));

                studentList.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }

        return null;
    }

    @Override
    public Student getStudentOnPhone(String phone) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, FIRSTNAME, LASTNAME, MIDDLENAME, EMAIL, PHONE, BIRTHDAY, FACULTY FROM STUDENTS WHERE PHONE=?";

        Student student = new Student();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,phone);

            ResultSet resultSet = preparedStatement.executeQuery();

            student.setId(resultSet.getInt("ID"));
            student.setFirstName(resultSet.getString("FIRSTNAME"));
            student.setLastName(resultSet.getString("LASTNAME"));
            student.setMiddleName(resultSet.getString("MIDDLENAME"));
            student.setEmail(resultSet.getString("EMAIL"));
            student.setPhone(resultSet.getString("PHONE"));
            student.setBirthday(resultSet.getString("BIRTHDAY"));
            student.setFaculty(resultSet.getLong("FACULTY"));

            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }

        }
        return student;
    }

    @Override
    public void saveStudent(Student student) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO STUDENT (ID, FIRSTNAME, LASTNAME, MIDDLENAME, EMAIL, PHONE, BIRTHDAY, FACULTY) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, student.getId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setString(4, student.getMiddleName());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, student.getPhone());
            preparedStatement.setString(7, student.getBirthday());
            preparedStatement.setLong(8, student.getFaculty());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement != null ){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE STUDENTS SET FIRSTNAME=?, LASTNAME=?, MIDDLENAME=?, EMAIL=?, PHONE=?, BIRTHDAY=?, FACULTY=? WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getMiddleName());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getPhone());
            preparedStatement.setString(6, student.getBirthday());
            preparedStatement.setLong(7, student.getFaculty());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (preparedStatement != null ){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }

    }

    @Override
    public void deleteStudent(Student student) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM STUDENTS WHERE ID=?";

        try {
            preparedStatement.executeQuery(sql);
            preparedStatement.setInt(1, student.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (preparedStatement != null ){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }
}
