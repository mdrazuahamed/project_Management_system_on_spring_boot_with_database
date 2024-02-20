package com.razuahamed.springboot.project_management.repository;
import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.model.Task;
import com.razuahamed.springboot.project_management.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    public Task findByName(String name);

    //@Query("SELECT t FROM Task t WHERE t.id = :id")
    @Query("SELECT m FROM Member m WHERE m NOT IN (SELECT t.member FROM Task t)")
    public List<Member> findMemberWithNoTask(List<Member> member, List<Task> task);
}
//    public TaskRepository(MemberRepository memberRepository) {
//        taskList = new ArrayList<>();
//        List<Member> memberList = memberRepository.getMemberList();
//        Task task1 = new Task(1,"Fix Bug From verilog",memberList.get(0));
//        Task task2 = new Task(2,"Fix Error From Testbench",memberList.get(1));
//        Task task3 = new Task(3,"Remove Lvs After Routing",memberList.get(2));
//        Task task4 = new Task(4,"Ball Grid Array Design",memberList.get(3));
//        Task task5 = new Task(5,"L2 cache issue",memberList.get(4));
//        Task task6 = new Task(10,"Cleanup the code",memberList.get(5));
//        Task task7 = new Task(20,"latch remove",memberList.get(6));
//
//        taskList.add(task1);
//        taskList.add(task2);
//        taskList.add(task3);
//        taskList.add(task4);
//        taskList.add(task5);
//        taskList.add(task6);
//        taskList.add(task7);
//    }
//
//    public void addTask(Task task) {
//        task.setId(taskList.get(taskList.size()-1).getId()+20);
//        this.taskList.add(task);
//    }
//
//    public long newId(){
//        if(taskList.size() == 0){
//            return 10;
//        }
//        return taskList.get(taskList.size()-1).getId()+20;
//    }
//
//    public Task addAndGetTaskWithName(String name, Member member) {
//        Task task = new Task(newId(),name,member);
//        taskList.add(task);
//        return task;
//    }
//
//    public Task getTaskWithName(String name) {
//        for(Task task : taskList){
//            if(task.getName().equals(name)) {
//                return task;
//            }
//        }
//        return null;
//    }
//
//    public MemberRepository getMemberRepository() {
//        return memberRepository;
//    }
//
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    public List<Task> getTaskList() {
//        return taskList;
//    }
//
//    public void setTaskList(List<Task> taskList) {
//        this.taskList = taskList;
//    }
//
//    @Override
//    public String toString() {
//        return "TaskRepository{" +
//                "memberRepository=" + memberRepository +
//                ", taskList=" + taskList +
//                '}';
//    }

