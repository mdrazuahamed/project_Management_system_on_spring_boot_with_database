package com.razuahamed.springboot.project_management.controller;
import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.model.Task;
import com.razuahamed.springboot.project_management.repository.MemberRepository;
//import com.razuahamed.springboot.project_management.service.MemberService;
import com.razuahamed.springboot.project_management.repository.TaskRepository;
import com.razuahamed.springboot.project_management.service.MemberService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/member")
public class MemberController {
    private MemberRepository memberRepository;
    private TaskRepository taskRepository;
    private MemberService memberService;
    private static String UPLOADED_FOLDER = "src/main/resources/static/images/";

    public MemberController(MemberRepository memberRepository, TaskRepository taskRepository, MemberService memberService) {
        this.taskRepository = taskRepository;
        this.memberRepository = memberRepository;
        this.memberService = memberService;
    }

    @GetMapping("/allMember")
    public String addFreeMember(Model model) {
        model.addAttribute("allMember",memberRepository.findAll());
        return "all-member";
    }

    @GetMapping("/deleteMember")
    public String memberDelete(@RequestParam("memberId") long memberId) {
        memberService.memberToDelete(memberId);
        return "redirect:/member/allMember";
    }

    @GetMapping("/add")
    public String addMemberOnTeam(Model model) {
        Member member = new Member();
        model.addAttribute("newMember", member);
        return "add-member";
    }

    @PostMapping("/add")
    public String addMember(@Valid @ModelAttribute("member") Member member, @RequestParam("image") MultipartFile file, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/member/add";
        }
        else {
            if (!file.isEmpty()) {
                try {
                    String fileName = member.getName() + ".png";
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(UPLOADED_FOLDER + fileName);
                    Files.write(path, bytes);
                    member.setImagePath("/images/" + fileName);
                    System.out.println(member);
                    memberRepository.save(member);
                    return "redirect:/member/allMember";
                } catch (IOException e) {
                    e.printStackTrace();
                    return "redirect:/member/add";
                }
            } else {
                return "redirect:/member/add";
            }
        }
    }

    @GetMapping("/memberSorting/{field}")
    public String memberDelete(Model model, @PathVariable String field) {
        List<Member> members = memberService.findMembersWithSorting(field);
        model.addAttribute("Member",  new Member());
        System.out.println(members);
        return "redirect:/member/allMember";
    }
}
