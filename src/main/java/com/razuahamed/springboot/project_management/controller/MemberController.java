package com.razuahamed.springboot.project_management.controller;
import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.repository.MemberRepository;
//import com.razuahamed.springboot.project_management.service.MemberService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    private MemberRepository memberRepository;
    //private MemberService memberService;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
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
            //return "add-member-with-age";
        }
        else {
            this.memberRepository.save(member);
            return "add-member-success";
        }
    }
}
