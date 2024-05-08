package com.razuahamed.springboot.project_management.service;

import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.model.Task;
import com.razuahamed.springboot.project_management.repository.MemberRepository;
import com.razuahamed.springboot.project_management.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    MemberRepository memberRepository;
    TaskRepository taskRepository;

    public  MemberService(MemberRepository memberRepository, TaskRepository taskRepository){
        this.memberRepository = memberRepository;
        this.taskRepository = taskRepository;
    }
    public void memberToDelete(long memberId){
        Member member = memberRepository.findByIdEquals(memberId);
        List<Task> tasks = taskRepository.findAll();
        List<Task> tasksToUpdate = new ArrayList<>();
        List<Member> membersToRemove = new ArrayList<>();

        for (Task task : tasks) {
            for (Member newMember : task.getMembers()) {
                if (member.equals(newMember)) {
                    membersToRemove.add(newMember);
                }
            }
            task.removeMembers(membersToRemove);
            tasksToUpdate.add(task);
        }
        taskRepository.saveAll(tasksToUpdate);
        memberRepository.deleteById(memberId);
    }

    public List<Member> findMembersWithSorting(String field) {
        return memberRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public Page<Member> findmemberWithPagination(int offset, int pageSize) {
        return memberRepository.findAll(PageRequest.of(offset,pageSize));
    }
}
