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
//    @Query("SELECT m FROM Member m WHERE m NOT IN (SELECT t.member FROM Task t)")
//    public List<Member> findMemberWithNoTask(List<Member> member, List<Task> task);
}
