import model.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Students.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();

            Students students = new Students("Ivan", "Ivanov", "Ivanovich", "ivan@gmail.com", "9294789562", "19.09.1990", 2);

            session.beginTransaction();

            session.save(students);

            session.getTransaction().commit();
        }finally {
            factory.close();
        }




    }
}
