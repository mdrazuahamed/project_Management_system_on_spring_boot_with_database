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
//			Member akash = new Member("Akash Rahman", 20, "akash@dsinnovators.com","12345","/images/male1.png");
//			Member nakib = new Member("Nakibur Rahman", 25, "nakib@dsinnovators.com","12345","/images/male2.png");
//			Member reyad = new Member("Reyad Ahamed", 30, "reyad@dsinnovators.com","12345","/images/male3.png");
//			Member foez = new Member("Foez Ahamed", 40, "foez@dsinnovators.com","12345","/images/male4.png");
//			Member safi = new Member("Ataus Safi", 50, "safi@dsinnovators.com","12345","/images/male5.png");
//			Member rafi = new Member("Rubait Rafi", 25, "rafi@dsinnovators.com","12345","/images/female1.png");
//			Member rifa = new Member("Rifa Mist", 24, "rifa@dsinnovators.com","12345","/images/female1.png");
//			Member tulon = new Member("Tulon khan", 25, "tulon@dsinnovators.com","12345","/images/male6.png");
//			Member fardin = new Member("Fardin Ahamed", 26, "fardin@dsinnovators.com","12345","/images/male7.png");
//			Member shahid = new Member("Shahid", 23, "shahid@dsinnovators.com","12345","/images/male8.png");
//
//
//			memberRepository.save(akash);
//			memberRepository.save(nakib);
//			memberRepository.save(reyad);
//			memberRepository.save(foez);
//			memberRepository.save(safi);
//			memberRepository.save(rafi);
//			List<Member> memberList = List.of(rifa,tulon,fardin);
//			memberRepository.save(shahid);
//			memberRepository.saveAll(memberList);
//
//			Task task1 = new Task("Fix Bug From verilog",List.of(memberRepository.findByName("Nakibur Rahman"), memberRepository.findByName("Tulon khan")));
//			Task task2 = new Task("Fix Error From Testbench",List.of(memberRepository.findByName("Reyad Ahamed"),memberRepository.findByName("Ataus Safi")));
//			taskRepository.save(task1);
//			taskRepository.save(task2);
//			Task task3 = new Task("Remove Lvs After Routing",List.of(memberRepository.findByName("Fardin Ahamed")));
//			taskRepository.save(task3);
//
//			Team hardware = new Team("Hardware",List.of(taskRepository.findByName("Fix Bug From verilog")),"Seamless, Secure, Scalable: Your Digital Landscape Refined. Building Tomorrow's Infrastructure Today","/images/hardware2.png");
//        	Team firmware = new Team("Firmware", List.of(taskRepository.findByName("Fix Error From Testbench"),taskRepository.findByName("Remove Lvs After Routing"))," Explore our work as we bridge the gap between hardware and software, providing innovative solutions and simulations that drive technological advancements.","/images/software2.png");
//			teamRepository.save(hardware);
//			teamRepository.save(firmware);
			System.out.println("Working");
		};
	}
}
