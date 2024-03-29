package com.razuahamed.springboot.project_management;

import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.model.Task;
import com.razuahamed.springboot.project_management.model.Team;
import com.razuahamed.springboot.project_management.repository.MemberRepository;
//import com.razuahamed.springboot.project_management.repository.TaskRepository;
//import com.razuahamed.springboot.project_management.repository.TeamRepository;
//import com.razuahamed.springboot.project_management.service.TaskService;
//import com.razuahamed.springboot.project_management.service.TeamService;
import com.razuahamed.springboot.project_management.repository.TaskRepository;
import com.razuahamed.springboot.project_management.repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ProjectManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(String[] args, MemberRepository memberRepository, TaskRepository taskRepository, TeamRepository teamRepository) {
		return runner -> {
//			Member akash = new Member("Akash Rahman", 20, "akash@dsinnovators.com");
//			Member nakib = new Member("Nakibur Rahman", 25, "nakib@dsinnovators.com");
//			Member reyad = new Member("Reyad Ahamed", 30, "reyad@dsinnovators.com");
//			Member foez = new Member("Foez Ahamed", 40, "foez@dsinnovators.com");
//			Member safi = new Member("Ataus Safi", 50, "safi@dsinnovators.com");
//			Member rafi = new Member("Rubait Rafi", 25, "rafi@dsinnovators.com");
//			Member rifa = new Member("Rifa Mist", 24, "rifa@dsinnovators.com");
//			Member tulon = new Member("Tulon khan", 25, "tulon@dsinnovators.com");
//			Member fardin = new Member("Fardin Mia", 26, "fardin@dsinnovators.com");
//
//			memberRepository.save(akash);
//			memberRepository.save(nakib);
//			memberRepository.save(reyad);
//			memberRepository.save(foez);
//			memberRepository.save(safi);
//			memberRepository.save(rafi);
//			List<Member> memberList = List.of(rifa,tulon,fardin);
//			memberRepository.saveAll(memberList);
//			//System.out.println(memberRepository.findAll());
//			//System.out.println(memberRepository.findByName("Akash Rahman"));
//
//			Task task1 = new Task("Fix Bug From verilog",memberRepository.findByName("Nakibur Rahman"));
//			Task task2 = new Task("Fix Error From Testbench",memberRepository.findByName("Reyad Ahamed"));
//			taskRepository.save(task1);
//			taskRepository.save(task2);
//			Task task3 = new Task("Remove Lvs After Routing",memberRepository.findByName("Tulon khan"));
//			taskRepository.save(task3);
//
//			Team hardware = new Team("Hardware",List.of(taskRepository.findByName("Fix Bug From verilog")));
//        	Team firmware = new Team("Firmware", List.of(taskRepository.findByName("Fix Error From Testbench"),taskRepository.findByName("Remove Lvs After Routing")));
//			teamRepository.save(hardware);
//			teamRepository.save(firmware);
//			System.out.println("Working");
//
//			System.out.println(teamRepository.findByIdEquals(1L));
//			System.out.println(taskRepository.findMemberWithNoTask(memberRepository.findAll(),taskRepository.findAll()));
		};
	}
}
