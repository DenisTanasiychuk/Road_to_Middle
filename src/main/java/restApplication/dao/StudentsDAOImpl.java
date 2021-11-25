//package restApplication.dao;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import restApplication.model.Faculty;
//import restApplication.model.Student;
//
//import java.util.List;
//
//@Repository
//public class StudentsDAOImpl implements StudentsDAO {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public List<Student> getAllStudents() {
//
//        Session session = sessionFactory.getCurrentSession();
//        List<Student> allStudents = session.createQuery("from Student", Student.class).getResultList();
//        return allStudents;
//    }
//
//
//    @Override
//    public List<Student> getStudentsOnLastname(String lastName) {
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("from Student where lastName = : paramName");
//        query.setParameter("paramName", lastName);
//        List<Student> studentList = query.list();
//        return studentList;
//    }
//
//    @Override
//    public Student getStudentOnPhone(String phone) {
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("from Student where phone = : paramName");
//        query.setParameter("paramName", phone);
//        Student student = (Student) query;
//        return student;
//    }
//
//    @Override
//    public List<Faculty> getAllFaculties() {
//
//        Session session = sessionFactory.getCurrentSession();
//        List<Faculty> allFaculties = session.createQuery("from Faculty", Faculty.class).getResultList();
//        return allFaculties;
//    }
//
//    @Override
//    public List<Faculty> getAllFacultiesOnMaxQuantityStudents() {
//        return null;
//    }
//
//    @Override
//    public List<Faculty> getAllFacultiesOnQuantityStudents() {
//        return null;
//    }
//
//    @Override
//    public void saveStudent(Student student) {
//
//        Session session = sessionFactory.getCurrentSession();
//        session.save(student);
//    }
//
//    @Override
//    public void updateStudent(int id) {
//
//    }
//
//    @Override
//    public void deleteStudent(int id) {
//
//        Session session = sessionFactory.getCurrentSession();
//        Query<Student> query = session.createQuery("delete Student where id = : paramName ");
//        query.setParameter("paramName" , id);
//        int result = query.executeUpdate();
//
//
//    }
//}
