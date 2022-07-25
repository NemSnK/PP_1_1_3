package jm.task.core.jdbc.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0l;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private Byte age;

    public User() {

    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new String(name + " " + lastName + " " + age + " years old");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.compareTo(user.id) == 0 && name.compareTo(user.name) == 0
                && lastName.compareTo(user.lastName) == 0 && age.compareTo(user.age) == 0;
    }

    @Override
    public int hashCode() {
        //не совсем уверен правильно ли я сделал для полей типа String
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (int) (id ^ (id >>> 32));
        result = PRIME * result + (age ^ (age >>> 32));
        result = PRIME * result + name.hashCode();
        result = PRIME * result + lastName.hashCode();
        return result;
    }
}
