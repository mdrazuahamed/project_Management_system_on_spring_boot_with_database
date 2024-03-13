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
//			Member akash = new Member("Akash Rahman", 25, "akash@dsinnovators.com","12345","/images/Akash_Rahman.png");
//			Member nakib = new Member("Nakibur Rahman", 28, "nakib@dsinnovators.com","12345","/images/Nakibur_Rahman.png");
//			Member reyad = new Member("Reyad Ahamed", 24, "reyad@dsinnovators.com","12345","/images/Reyad_Ahamed.png");
//			Member foez = new Member("Foez Ahamed", 25, "foez@dsinnovators.com","12345","/images/Foez_Ahamed.png");
//			Member safi = new Member("Ataus Safi", 30, "safi@dsinnovators.com","12345","/images/Ataus_Safi.png");
//			Member rafi = new Member("Robiat Rafi", 23, "rafi@dsinnovators.com","12345","/images/Robiat_Rafi.png");
//			Member towsif = new Member("Towsif Abdullah", 24, "towsif@dsinnovators.com","12345","/images/Towsif_Abdullah.png");
//			Member tulon = new Member("Tulon Khan", 24, "tulon@dsinnovators.com","12345","/images/Tulon_Khan.png");
//			Member farhat = new Member("Farhat Shahir", 28, "Farhat@dsinnovators.com","12345","/images/Farhat_Shahir.png");
//			Member saurav = new Member("Siddique Saurav", 25, "saurav@dsinnovators.com","12345","/images/Siddique_Saurav.png");
//			Member anik = new Member("Mushraful Hoque Anik", 38, "mushraful.hoque@dsinnovators.com","12345","/images/Mushraful_Hoque_Anik.png");
//			Member aziz = new Member("Sk Adit Aziz", 25, "adit.aziz@dsinnovators.com","12345","/images/Sk_Adit_Aziz.png");
//			// memberRepository.save(anik);
//			memberRepository.save(aziz);
//			memberRepository.save(saurav);
//			List<Member> memberList = List.of(towsif,tulon,farhat);
//			memberRepository.saveAll(memberList);
//			memberRepository.save(reyad);
//			memberRepository.save(foez);
//			memberRepository.save(safi);
//			memberRepository.save(rafi);
// 			memberRepository.save(akash);
//			memberRepository.save(nakib);
//			Task task1 = new Task("Remove unwanted latch",List.of(memberRepository.findByName("Nakibur Rahman"), memberRepository.findByName("Foez Ahamed")));
//			Task task2 = new Task("Remove Lvs After Routing",List.of(memberRepository.findByName("Reyad Ahamed"),memberRepository.findByName("Ataus Safi")));
//			taskRepository.save(task1);
//			taskRepository.save(task2);
//			Task task3 = new Task("Design Reference Model for ICACHE",List.of(memberRepository.findByName("Farhat Shahir")));
//			taskRepository.save(task3);
//
//			Team hardware = new Team("Hardware",List.of(taskRepository.findByName("Remove unwanted latch"),taskRepository.findByName("Remove Lvs After Routing")),"Seamless, Secure, Scalable: Your Digital Landscape Refined. Building Tomorrow's Infrastructure Today","/images/hardware2.png");
//        	Team firmware = new Team("Firmware", List.of(taskRepository.findByName("Design Reference Model for ICACHE"))," Explore our work as we bridge the gap between hardware and software, providing innovative solutions and simulations that drive technological advancements.","/images/software2.png");
//			teamRepository.save(hardware);
//			teamRepository.save(firmware);
			System.out.println("Working");
		};
	}
}
