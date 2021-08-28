package restApplication.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import restApplication.model.Faculty;
import restApplication.model.Student;

import java.util.List;

@Repository
public class StudentsDAOImpl implements StudentsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Student> getAllStudents() {

        Session session = sessionFactory.getCurrentSession();

        List<Student> allStudents = session.createQuery("from Student", Student.class).getResultList();

        return allStudents;
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

        Session session = sessionFactory.getCurrentSession();
        List<Faculty> allFaculties = session.createQuery("from Faculty", Faculty.class).getResultList();
        return allFaculties;
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
