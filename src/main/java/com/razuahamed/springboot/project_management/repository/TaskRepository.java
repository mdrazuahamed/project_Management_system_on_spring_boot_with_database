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


    @Query(value = "SELECT *\n" +
            "FROM member \n" +
            "LEFT JOIN task_members ON member.id = task_members.members_id\n" +
            "WHERE task_members.task_id IS NULL;", nativeQuery = true)
    public List<Member> findMemberWithNoTask(List<Member> member, List<Task> task);
}
