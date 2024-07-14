package com.razuahamed.springboot.project_management.controller;
import com.razuahamed.springboot.project_management.helper.AddTaskDto;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/addTask/{teamId}")
    public String addTask(@PathVariable("teamId") long teamId, Model model) {
        model.addAttribute("findMemberWithNoTask",taskRepository.findMembersWithNoTask());
        model.addAttribute("teamId", teamId);
        model.addAttribute("newTask", new Task());
        return "add-task";
    }

    @PostMapping("/addTask")
    public ResponseEntity<Map<String, String>> addTaskOnProject(@RequestBody AddTaskDto addTaskDto) {
        System.out.println("add task working");
        List<Member> members = new ArrayList<>();
        if (addTaskDto.membersId != null) {
            for (int memberId : addTaskDto.membersId) {
                members.add(memberRepository.findByIdEquals(memberId));
            }
        } else {
            System.out.println("No members selected");
        }
        Task task = new Task(addTaskDto.name, members);
        Team team = teamRepository.findById(Long.valueOf(addTaskDto.teamId)).orElse(null);
        if (team != null) {
            taskRepository.save(task);
            team.addTask(task);
            teamRepository.save(team);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Task added successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Team not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
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
        return "redirect:/team/teamDetails/"+teamId;
    }
}
