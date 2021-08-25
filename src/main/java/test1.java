import model.Faculties;
import model.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Students.class)
                .addAnnotatedClass(Faculties.class)
                .buildSessionFactory();

        Session session = null;

        try {

            session = factory.getCurrentSession();

            session.beginTransaction();

            Students student = new Students("Sofia", "Sidorova", "Alexandrovna", "sofa@gmail.com" , "89625784159", "02.02.1992");
//            Faculties facult = new Faculties("Computer science faculty ");
//           Faculties facult = new Faculties("Faculty of Economics ");
           Faculties facult = new Faculties("Faculty of Medicine ");

            student.setFaculty(facult);

            session.save(student);

            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }




    }
}
