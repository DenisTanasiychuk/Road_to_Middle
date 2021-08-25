//import model.Students;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//public class test2 {
//    public static void main(String[] args) {
//
//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Students.class)
//                .buildSessionFactory();
//
//        try {
//
//            Session session = factory.getCurrentSession();
//
//            Students student = new Students("Petr", "Petrov", "Petrovich", "petr@gmail.com", "9515887431", "25.02.1992", 1);
//
//            session.beginTransaction();
//
//            session.save(student);
//
//            session.getTransaction().commit();
//
//            int myID = student.getId();
//
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Students studentPetr = session.get(Students.class, myID);
//
//            session.getTransaction().commit();
//
//            System.out.println(studentPetr);
//
//
//        }finally {
//            factory.close();
//        }
//
//
//
//
//    }
//}
