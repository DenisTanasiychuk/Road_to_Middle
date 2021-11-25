package restApplication.dao.jdbc;//package restApplication.dao;

import restApplication.model.Faculty;
import restApplication.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentsDAO {

    public List<Student> getAllStudents() throws SQLException;

    public List<Student> getStudentsOnLastname(String lastName) throws SQLException;

    public Student getStudentOnPhone(String phone) throws SQLException;

    public List<Faculty> getAllFaculty() throws SQLException;

    public Faculty getFacultyMaxStudents();

    public List<Faculty> getFucultiesMore(int i);

    public void saveStudent(Student student) throws SQLException;

    public void updateStudent(Student student) throws SQLException;

    public void deleteStudent(Student student) throws SQLException;

}
