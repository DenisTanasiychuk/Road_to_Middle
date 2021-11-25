package restApplication.dao.jdbc;

import restApplication.da.Util;
import restApplication.model.Faculty;
import restApplication.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsDAOImpl extends Util implements StudentsDAO {

    Connection connection = getConnection();

    @Override
    public List<Student> getAllStudents() throws SQLException {
        List<Student> studentList = new ArrayList<>();

        String sql = "SELECT * FROM students";
        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setMiddleName(resultSet.getString("middle_name"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
                student.setBirthday(resultSet.getString("birthday"));
                student.setFaculty(resultSet.getLong("faculty_id"));

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

        String sql = "SELECT * FROM students WHERE last_name=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lastName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setMiddleName(resultSet.getString("middle_name"));
                student.setEmail(resultSet.getString("email"));
                student.setPhone(resultSet.getString("phone"));
                student.setBirthday(resultSet.getString("birthday"));
                student.setFaculty(resultSet.getLong("faculty_id"));

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

        return studentList;
    }

    @Override
    public Student getStudentOnPhone(String phone) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM students WHERE phone=?";

        Student student = new Student();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,phone);

            ResultSet resultSet = preparedStatement.executeQuery();

            student.setId(resultSet.getInt("id"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setLastName(resultSet.getString("last_name"));
            student.setMiddleName(resultSet.getString("middle_name"));
            student.setEmail(resultSet.getString("email"));
            student.setPhone(resultSet.getString("phone"));
            student.setBirthday(resultSet.getString("birthday"));
            student.setFaculty(resultSet.getLong("faculty_id"));

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
    public List<Faculty> getAllFaculty() throws SQLException {
        List<Faculty> facultyList = new ArrayList<>();

        String sql = "SELECT * FROM faculties";

        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Faculty faculty = new Faculty();
                faculty.setId(resultSet.getInt("id"));
                faculty.setName(resultSet.getString("faculty_name"));

                facultyList.add(faculty);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }

        }

        return facultyList;
    }

    @Override
    public Faculty getFacultyMaxStudents() {
        PreparedStatement preparedStatement = null;

        return null;
    }

    @Override
    public List<Faculty> getFucultiesMore(int i) {
        return null;
    }

    @Override
    public void saveStudent(Student student) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO students (id, first_name, last_name, middle_name, email, phone, birthday, faculty_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

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

        String sql = "UPDATE students SET first_name=?, last_name=?, middle_name=?, email=?, phone=?, birthday=?, faculty_id=? WHERE id=?";

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

        String sql = "DELETE FROM students WHERE id=?";

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
