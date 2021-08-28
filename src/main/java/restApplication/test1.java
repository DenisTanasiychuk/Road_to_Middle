package restApplication;

import restApplication.model.Faculty;
import restApplication.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Faculty.class)
                .buildSessionFactory();

        Session session = null;

        try {

            session = factory.getCurrentSession();

            session.beginTransaction();

            Student student = new Student("Sofia", "Sidorova", "Alexandrovna", "sofa@gmail.com" , "89625784159", "02.02.1992");
//            Faculty facult = new Faculty("Computer science faculty ");
//           Faculty facult = new Faculty("Faculty of Economics ");
           Faculty facult = new Faculty("Faculty of Medicine ");

            student.setFaculty(facult);

            session.save(student);

            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }




    }
}
