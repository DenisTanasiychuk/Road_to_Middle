package model;

import javax.persistence.*;

@Entity
@Table(name = "faculties")
public class Faculties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "faculty_name")
    private String name;

    public Faculties() {
    }

    public Faculties(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Faculties{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
