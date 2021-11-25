package restApplication.model;

import java.util.List;
import java.util.Objects;


public class Role {

    private int id;
    private String roleName;
    private List<User> usersList;

    public Role() {
    }

    public Role(int id, String roleName, List<User> usersList) {
        this.id = id;
        this.roleName = roleName;
        this.usersList = usersList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id && Objects.equals(roleName, role.roleName) && Objects.equals(usersList, role.usersList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, usersList);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
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
//@Table(name = "users_roles")
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "user_role_name")
//    private String roleName;
//
//    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
//            mappedBy = "role")
//    private List<User> usersList;
//
//    public Role() {
//    }
//
//    public Role(String roleName) {
//        this.roleName = roleName;
//    }
//
//    public void addUsersToRole(User user){
//        if (usersList == null){
//            usersList = new ArrayList<>();
//        }
//        usersList.add(user);
//        user.setRole(this);
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
//    public String getRoleName() {
//        return roleName;
//    }
//
//    public void setRoleName(String roleName) {
//        this.roleName = roleName;
//    }
//
//    @Override
//    public String toString() {
//        return "Role{" +
//                "id=" + id +
//                ", roleName='" + roleName + '\'' +
//                '}';
//    }
//}
