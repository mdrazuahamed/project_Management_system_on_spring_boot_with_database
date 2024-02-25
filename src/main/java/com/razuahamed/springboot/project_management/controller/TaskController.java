package com.razuahamed.springboot.project_management.controller;
import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.model.Task;
import com.razuahamed.springboot.project_management.model.Team;
import com.razuahamed.springboot.project_management.repository.MemberRepository;
import com.razuahamed.springboot.project_management.repository.TaskRepository;
import com.razuahamed.springboot.project_management.repository.TeamRepository;
//import com.razuahamed.springboot.project_management.service.MemberService;
//import com.razuahamed.springboot.project_management.service.TeamService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {
    private TaskRepository taskRepository;
    private MemberRepository memberRepository;
    private TeamRepository teamRepository;

    public TaskController(TaskRepository taskRepository, MemberRepository memberRepository, TeamRepository teamRepository) {
        this.taskRepository = taskRepository;
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
    }

    @GetMapping("/addTask")
    public String addTask(Model model,@RequestParam("teamId") long teamId) {
        model.addAttribute("findMemberWithNoTask",taskRepository.findMembersWithNoTask());
        model.addAttribute("teamId", teamId);
        model.addAttribute("newTask", new Task());
        return "add-task";
    }

    @PostMapping("/addTaskOnProject")
    public String addTaskOnProject(@RequestParam("teamId") long teamId, @Valid Task task, @NotNull BindingResult bindingResult){
        Team team = teamRepository.findById(teamId).orElse(null);
        taskRepository.save(task);
        team.addTask(task);
        teamRepository.save(team);
        return "add-task-success";
    }

    @GetMapping("/completeTask")
    public String completeTask(@RequestParam("taskId") Long  taskId, @RequestParam("teamId") Long teamId) {
        Team team = teamRepository.findByIdEquals(teamId);
        List<Member> needToRemovedMembers = taskRepository.findMembersWithTaskId(taskId);
        Task task = taskRepository.findById(taskId).orElse(null);
        task.removeMembers(needToRemovedMembers);
        taskRepository.save(task);
        team.removeTask(taskRepository.findById(taskId).orElse(null));
        teamRepository.save(team);
        return "remove-complete-task";
    }

}
