package com.razuahamed.springboot.project_management.repository;
import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.model.Task;
import com.razuahamed.springboot.project_management.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public interface TeamRepository extends JpaRepository<Team, Long> {

    public Team findByIdEquals(Long id);

    public Team findByName(String name);
}
//    pri
//    publicvate List<Team> teamList;
//    private TaskRepository taskRepository;
//
//    public TeamRepository(TaskRepository taskRepository) {
//        teamList = new ArrayList<>();
//        List<Task> taskList = taskRepository.getTaskList();
//        List<Task> hardwareTasks = new ArrayList<>();
//        List<Task> firmwareTasks = new ArrayList<>();
//
//        hardwareTasks.add(taskList.get(0));
//        hardwareTasks.add(taskList.get(2));
//        hardwareTasks.add(taskList.get(3));
//        hardwareTasks.add(taskList.get(4));
//
//        firmwareTasks.add(taskList.get(5));
//        firmwareTasks.add(taskList.get(6));
//        firmwareTasks.add(taskList.get(1));
//
//
//        Team hardware = new Team(100,"Hardware",hardwareTasks);
//        Team firmware = new Team(200,"Firmware", firmwareTasks);
//
//        this.teamList = List.of(hardware,firmware);
//    }
//
//    public Team getTeamById(long id) {
//        for (Team team : teamList) {
//            if(team.getId() == id) {
//                return team;
//            }
//        }
//        return null;
//    }
//
//    public List<Team> getTeamList() {
//        return this.teamList;
//    }
//
//    public void setTeamList(List<Team> teamList) {
//        this.teamList = teamList;
//    }
//
//    @Override
//    public String toString() {
//        return "TeamRepository{" +
//                "teamList=" + teamList +
//                '}';
//    }
//}
