package restApplication.service;

import restApplication.model.Faculty;
import restApplication.model.Student;

import java.util.List;

public interface StudentsService {

    public List<Student> getAllStudents();

    public List<Student> getStudentsOnLastname();

    public Student getStudentOnPhone();

    public List<Faculty> getAllFaculties();

    public Faculty getAllFacultiesOnMaxQuantityStudents();

    public List<Faculty> getAllFacultiesOnQuantityStudents();

    public void saveStudent(Student student);

    public void updateStudent(int id);

    public void deleteStudent(int id);
}
