//package com.razuahamed.springboot.project_management.service;
//import com.razuahamed.springboot.project_management.model.Member;
//import com.razuahamed.springboot.project_management.model.Task;
//import com.razuahamed.springboot.project_management.model.Team;
//import com.razuahamed.springboot.project_management.repository.TeamRepository;
//import org.springframework.stereotype.Service;
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Service
//public class TeamService {
//    private TeamRepository teamRepository;
//
//    public TeamService(TeamRepository teamRepository) {
//        this.teamRepository = teamRepository;
//    }
//
//    public List<Team> getAllTeam(){
//        return teamRepository.getTeamList();
//    }
//
//    public Team getTeamWithName(String name) {
//        List<Team> allTeams = teamRepository.getTeamList();
//
//        for (Team teamIndex : allTeams) {
//            if(teamIndex.getName().equals(name)) {
//                return teamIndex;
//            }
//        }
//        return null;
//    }
//
//    public Team getTeamHaveMaxAverageAge() {
//        List<Team> allTeams = teamRepository.getTeamList();
//        int[] averageAges = new int[allTeams.size()];
//        int teamIndex = 0;
//        Team team = new Team();
//        int averageAge = 0;
//        int totalAge ;
//        int taskCounter=0;
//
//        for (Team newTeam : allTeams) {
//            totalAge = 0;
//            taskCounter=0;
//            for(Task task : newTeam.getTaskList()) {
//                taskCounter++;
//                totalAge = totalAge + task.getMember().getAge();
//            }
//            averageAges[teamIndex] = totalAge / taskCounter;
//            teamIndex++;
//        }
//        System.out.println("Average age of " + allTeams.get(0).getName() + " is equal   " + averageAges[0]+"  and Average age of " + allTeams.get(1).getName() + " is equal   " + averageAges[1]);
//
//        if(averageAges[0]>averageAges[1]) {
//            return allTeams.get(0);
//        }
//        else
//            return allTeams.get(1);
//    }
//
//    public Team teamWithMaxMember() {
//        List<Team> allTeams = teamRepository.getTeamList();
//        int[]  numberOfTaskInTeams = new int[allTeams.size()];
//        int numberOfTask ;
//        int taskIndex = 0;
//
//        for(Team newTeam : allTeams) {
//            numberOfTask = 0;
//            for(Task task : newTeam.getTaskList()) {
//                numberOfTask ++;
//            }
//            numberOfTaskInTeams[taskIndex] = numberOfTask;
//            numberOfTask = 0;
//            taskIndex ++;
//        }
//
//        System.out.println("Number of Task in " + allTeams.get(0).getName() + " Is equal " + numberOfTaskInTeams[0] + " and Number of Task in " +  allTeams.get(1).getName() + " Is equal " + numberOfTaskInTeams[1] );
//        if(numberOfTaskInTeams[0]>numberOfTaskInTeams[1]) {
//            return allTeams.get(0);
//        }
//        else return allTeams.get(1);
//    }
//
//    public void removeTaskFromTeamById(Task task, long teamId) {
//        for (Team team : teamRepository.getTeamList()) {
//            if (teamId == team.getId()) {
//                team.getTaskList().remove(task);
//            }
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "TeamService{" +
//                "teamRepository=" + teamRepository +
//                '}';
//    }
//}
