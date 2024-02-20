//package com.razuahamed.springboot.project_management.service;
//import com.razuahamed.springboot.project_management.model.Task;
//import com.razuahamed.springboot.project_management.model.Team;
//import com.razuahamed.springboot.project_management.repository.TaskRepository;
//import com.razuahamed.springboot.project_management.repository.TeamRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class TaskService {
//    private TeamRepository teamRepository;
//    private TaskRepository taskRepository;
//
//    public TaskService(TeamRepository teamRepository, TaskRepository taskRepository) {
//        this.teamRepository = teamRepository;
//        this.taskRepository = taskRepository;
//    }
//
//    public void getTaskWithTeamAndMember() {
//        List<Team> teamList = teamRepository.getTeamList();
//        for(Team team : teamList) {
//            for(Task task : team.getTaskList()) {
//                System.out.println("Member Name = " + task.getMember().getName() + ", Team name = " + team.getName() + ", Task name = " + task.getName());
//
//            }
//        }
//    }
//
//    public void getTaskWithMember() {
//        List<Task> taskList = taskRepository.getTaskList();
//        for(Task task : taskList) {
//            System.out.println("Task name = " + task.getName() + ", Member Name = " + task.getMember().getName());
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "TaskService{" +
//                "teamRepository=" + teamRepository +
//                ", taskRepository=" + taskRepository +
//                '}';
//    }
//}
