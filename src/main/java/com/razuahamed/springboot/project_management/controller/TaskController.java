package com.razuahamed.springboot.project_management.controller;
import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.model.Task;
import com.razuahamed.springboot.project_management.model.Team;
import com.razuahamed.springboot.project_management.repository.MemberRepository;
import com.razuahamed.springboot.project_management.repository.TaskRepository;
import com.razuahamed.springboot.project_management.repository.TeamRepository;
//import com.razuahamed.springboot.project_management.service.MemberService;
//import com.razuahamed.springboot.project_management.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {
    //TeamService teamService;
    private TaskRepository taskRepository;
    private MemberRepository memberRepository;
    //private MemberService memberService;
    private TeamRepository teamRepository;

    public TaskController(TaskRepository taskRepository, MemberRepository memberRepository, TeamRepository teamRepository) {
        this.taskRepository = taskRepository;
        //this.memberService = memberService;
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
        //this.teamService = teamService;
    }
//
    @GetMapping("/addTask")
    public String addTask(Model model,@RequestParam("teamId") long teamId) {
        model.addAttribute("memberWithNoTask",taskRepository.findMemberWithNoTask(memberRepository.findAll(),taskRepository.findAll()));
        model.addAttribute("teamId", teamId);
        model.addAttribute("newTask", new Task());
        return "add-task";
    }

    @PostMapping("/addTaskOnProject")
    public String addTaskOnProject(@RequestParam("teamId") long teamId, Task task){
        Team team = teamRepository.findById(teamId).orElse(null);
        //System.out.println(team+task+member);
        taskRepository.save(task);
        System.out.println("---------------"+task.getMember());
        team.addTask(task);
        teamRepository.save(team);
        return "add-task-success";
    }

    @GetMapping("/completeTask")
    public String completeTask(@RequestParam("taskId") Long  taskId, @RequestParam("teamId") Long teamId) {

        Team team = teamRepository.findByIdEquals(teamId);
        team.removeTask(taskRepository.findById(taskId).orElse(null));
        teamRepository.save(team);
        //taskRepository.delete(taskRepository.findByName(taskName));

        return "remove-complete-task";
    }

}
