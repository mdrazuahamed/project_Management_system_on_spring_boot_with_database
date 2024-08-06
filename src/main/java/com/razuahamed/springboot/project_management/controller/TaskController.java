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
import com.razuahamed.springboot.project_management.service.ExcelService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private ExcelService excelService;

    public TaskController(TaskRepository taskRepository, MemberRepository memberRepository, TeamRepository teamRepository, ExcelService excelService) {
        this.taskRepository = taskRepository;
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
        this.excelService = excelService;
    }

    @GetMapping("/addTask/{teamId}")
    public String addTask(@PathVariable("teamId") long teamId, Model model) {
        model.addAttribute("findMemberWithNoTask",taskRepository.findMembersWithNoTask());
        model.addAttribute("teamId", teamId);
        model.addAttribute("newTask", new Task());
        return "add-task";
    }

    @PostMapping("/addTask")
    public void addTaskOnProject(@RequestBody AddTaskDto addTaskDto, HttpServletResponse response) throws IOException {
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
        XSSFWorkbook workbook = excelService.generateDummyExcel();

        if (team != null) {
            taskRepository.save(task);
            team.addTask(task);
            teamRepository.save(team);
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + "Test" + ".xlsx\"");
            workbook.write(response.getOutputStream());
            workbook.close(); // Ensure the workbook is properly closed
            response.getOutputStream().flush();
            response.getOutputStream().close();
            System.out.println("workbook work");
        } else {
            System.out.println("Team is null and not sending excel");
        }
    }

//        FileOutputStream outputStream = new FileOutputStream("C:\\Downloads\\hssf.xlsx");
//        workbook.write(outputStream);

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
