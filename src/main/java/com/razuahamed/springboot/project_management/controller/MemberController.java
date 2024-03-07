package com.razuahamed.springboot.project_management.controller;
import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.model.Task;
import com.razuahamed.springboot.project_management.repository.MemberRepository;
//import com.razuahamed.springboot.project_management.service.MemberService;
import com.razuahamed.springboot.project_management.repository.TaskRepository;
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
import java.util.Optional;

@Controller
@RequestMapping("/member")
public class MemberController {
    private MemberRepository memberRepository;
    private TaskRepository taskRepository;

    public MemberController(MemberRepository memberRepository, TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/addFreeMember")
    public String addFreeMember(Model model, @RequestParam("taskId") long taskId) {
        model.addAttribute("findMemberWithNoTask",taskRepository.findMembersWithNoTask());
        model.addAttribute("taskId", taskId);
        model.addAttribute("newTask", new Task());
        return "add-free-member";
    }

    @GetMapping("/allMember")
    public String addFreeMember(Model model) {
        model.addAttribute("allMember",memberRepository.findAll());
        return "all-member";
    }

    @PostMapping("/addFreeMember")
    public String addFreeMember( Task task, @RequestParam("taskId") long taskId) {
        System.out.println(taskId);
        Task task1 = taskRepository.findById(taskId).orElse(null);
        task1.addMembers(task.getMembers());
        taskRepository.save(task1);
        System.out.println(task1);
        return "add-free-member-success";
    }

    @GetMapping("/add")
    public String addMemberOnTeam(Model model) {
        model.addAttribute("newMember", new Member());
        return "add-member";
    }

    @PostMapping("/add")
    public String addMember(@Valid Member member, @NotNull BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/member/add";
        }
        else {
            //member.setImagePath();
            memberRepository.save(member);
            return "add-member-success";
        }
    }
}
