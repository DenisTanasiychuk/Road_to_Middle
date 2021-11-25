package restApplication.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty {

    private int id;
    private String name;
    private List<Student> studentsList;

    public Faculty() {
    }

    public Faculty(int id, String name, List<Student> studentsList) {
        this.id = id;
        this.name = name;
        this.studentsList = studentsList;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return id == faculty.id && Objects.equals(name, faculty.name) && Objects.equals(studentsList, faculty.studentsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, studentsList);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

//Hibernate
//package restApplication.model;
//
//        import javax.persistence.*;
//        import java.util.ArrayList;
//        import java.util.List;
//
//@Entity
//@Table(name = "faculties")
//public class Faculty {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "faculty_name")
//    private String name;
//
//    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
//            mappedBy = "faculty")
//    private List<Student> studentsList;
//
//    public Faculty() {
//    }
//
//    public Faculty(String name) {
//        this.name = name;
//    }
//
//    public void addStudentToFaculty(Student student){
//        if (studentsList == null){
//            studentsList = new ArrayList<>();
//        }
//        studentsList.add(student);
//        student.setFaculty(this);
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Student> getStudentsList() {
//        return studentsList;
//    }
//
//    public void setStudentsList(List<Student> studentsList) {
//        this.studentsList = studentsList;
//    }
//
//    @Override
//    public String toString() {
//        return "Faculty{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
//}
