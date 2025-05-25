package com.springboot_for_beginner;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
public class customer {
    @Id
    @SequenceGenerator(
            name = "customer_id_sequance",
            sequenceName = "customer_id_sequance"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
           generator = "customer_id_sequance"
    )
    private int id;
    private String name;
    private int age;
    private String email;

    public customer(int id,
                    String name,
                    int age,
                    String email
    ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public customer() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        customer customer = (customer) o;
        return id == customer.id && age == customer.age && Objects.equals(name, customer.name) && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, email);
    }

    @Override
    public String toString() {
        return "customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
