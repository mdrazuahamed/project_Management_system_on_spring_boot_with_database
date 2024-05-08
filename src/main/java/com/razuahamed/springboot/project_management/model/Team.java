package com.razuahamed.springboot.project_management.model;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
@Entity
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Task> tasks;
    private String intro;
    private String imagePath;

    public Team() {
        this.name = "No name";
        this.tasks = null;
        this.intro = "No intro";
        this.imagePath = null;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public Team(String name, List<Task> tasks, String intro, String imagePath) {
        this.name = name;
        this.tasks = tasks;
        this.intro = intro;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tasks=" + tasks +
                ", intro='" + intro + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
