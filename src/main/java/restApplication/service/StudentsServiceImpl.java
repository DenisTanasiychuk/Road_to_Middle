package restApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restApplication.dao.StudentsDAO;
import restApplication.model.Faculty;
import restApplication.model.Student;

import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService{

    @Autowired
    private StudentsDAO studentsDAO;

    @Override
    public List<Student> getAllStudents() {
        return studentsDAO.getAllStudents();
    }

    @Override
    public List<Student> getStudentsOnLastname() {
        return null;
    }

    @Override
    public Student getStudentOnPhone() {
        return null;
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return studentsDAO.getAllFaculties();
    }

    @Override
    public Faculty getAllFacultiesOnMaxQuantityStudents() {
        return null;
    }

    @Override
    public List<Faculty> getAllFacultiesOnQuantityStudents() {
        return null;
    }

    @Override
    public void saveStudent(int id) {

    }

    @Override
    public void updateStudent(int id) {

    }

    @Override
    public void deleteStudent(int id) {

    }
}
