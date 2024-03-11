package com.razuahamed.springboot.project_management.controller;
import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.model.Task;
import com.razuahamed.springboot.project_management.model.Team;
//import com.razuahamed.springboot.project_management.service.TeamService;
import com.razuahamed.springboot.project_management.repository.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {
    TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/allTeam")
    public String showAllTeam(Model model) {
        model.addAttribute("allTeam", teamRepository.findAll());
        return "all-team";
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
