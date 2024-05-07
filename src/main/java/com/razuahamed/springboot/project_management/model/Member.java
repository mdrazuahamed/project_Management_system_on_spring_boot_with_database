package com.razuahamed.springboot.project_management.model;
import jakarta.validation.constraints.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
@Entity
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is require")
    private String name;
    @NotNull(message = "Provide Your Age")
    private int age;
    @NotBlank(message = "Provide Your Email")
    private String email;
    @NotBlank(message = "Name is require")
    private String password;
    private String imagePath;
    @NotNull(message = "Provide this member is active or not")
    private boolean active;

    public Member() {
    }

    public Member(String name, int age, String email, Long id) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.id = id;
    }
    public Member(String name, int age, String email, String password, String image_path, boolean active) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.imagePath = image_path;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Member(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", active=" + active +
                '}';
    }
}
