package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "faculties")
public class Faculties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "faculty_name")
    private String name;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "faculty")
    private List<Students> studentsList;

    public Faculties() {
    }

    public Faculties(String name) {
        this.name = name;
    }

    public void addStudentToFaculty(Students student){
        if (studentsList == null){
            studentsList = new ArrayList<>();
        }
        studentsList.add(student);
        student.setFaculty(this);
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

    public List<Students> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Students> studentsList) {
        this.studentsList = studentsList;
    }

    @Override
    public String toString() {
        return "Faculties{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
