package com.razuahamed.springboot.project_management.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

@Entity
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is Require")
    private String name;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private List<Member> members;

    public Long getId() {
        return id;
    }

    public void removeMembers(List<Member> members) {
        this.members.removeAll(members);
    }

    public void addMembers(List<Member> members) {
        this.members.addAll(members);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task(String name) {
        this.name = name;
    }

    public Task() {
        this.name = null;
        this.members = null;
    }

    public Task(String name, List<Member> members) {
        this.name = name;
        this.members = members;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", members=" + members +
                '}';
    }
}
