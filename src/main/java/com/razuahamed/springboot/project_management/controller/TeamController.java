package com.razuahamed.springboot.project_management.controller;
import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.model.Task;
import com.razuahamed.springboot.project_management.model.Team;
//import com.razuahamed.springboot.project_management.service.TeamService;
import com.razuahamed.springboot.project_management.repository.TaskRepository;
import com.razuahamed.springboot.project_management.repository.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {
    TeamRepository teamRepository;
    TaskRepository taskRepository;

    public TeamController(TeamRepository teamRepository, TaskRepository taskRepository) {
        this.teamRepository = teamRepository;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/allTeam")
    public String showAllTeam(Model model) {
        model.addAttribute("allTeam", teamRepository.findAll());
        return "all-team";
    }

    @GetMapping("teamDetails/{teamId}/addFreeMember")
    public String addFreeMember(Model model, @RequestParam("taskId") long taskId, @PathVariable("teamId") Long teamId) {
        model.addAttribute("findMemberWithNoTask",taskRepository.findMembersWithNoTask());
        model.addAttribute("taskId", taskId);
        model.addAttribute("teamId",teamId);
        model.addAttribute("newTask", new Task());
        return "add-free-member";
    }

    @PostMapping("teamDetails/{teamId}/addFreeMember")
    public String addFreeMember(Task task, @RequestParam("taskId")long taskId) {
        System.out.println(taskId);
        Task task1 = taskRepository.findById(taskId).orElse(null);
        task1.addMembers(task.getMembers());
        taskRepository.save(task1);
        return "redirect:/team/teamDetails/{teamId}";
    }
    @GetMapping("/teamDetails/{teamId}")
    public String teamsDetail(Model model, @PathVariable("teamId") Long teamId) {
        model.addAttribute("team",teamRepository.findByIdEquals(teamId));
        return "team-details";
    }

    @GetMapping("/about")
    public String aboutOrganization() {
        return "about";
    }
}
