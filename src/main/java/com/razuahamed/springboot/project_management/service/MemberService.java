//package com.razuahamed.springboot.project_management.service;
//import com.razuahamed.springboot.project_management.model.Member;
//import com.razuahamed.springboot.project_management.model.Task;
//import com.razuahamed.springboot.project_management.model.Team;
//import com.razuahamed.springboot.project_management.repository.MemberRepository;
//import com.razuahamed.springboot.project_management.repository.TeamRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//@Service
//public class MemberService {
//    private MemberRepository memberRepository;
//    private TeamRepository teamRepository;
//
//    public MemberService(MemberRepository memberRepository, TeamRepository teamRepository) {
//        this.memberRepository = memberRepository;
//        this.teamRepository = teamRepository;
//    }
//
////    public List<Member> memberListInNoTeam() {
////        List<Member> memberListInNoTeam = new ArrayList<>(memberRepository.getMemberList());
////        Iterator<Member> iterator = memberListInNoTeam.iterator();
////        while (iterator.hasNext()) {
////            Member member = iterator.next();
////            for (Team team : teamRepository.getTeamList()) {
////                for (Task task : team.getTaskList()) {
////                    if (member.getId() == task.getMember().getId()) {
////                        iterator.remove();
////                        break;
////                    }
////                }
////            }
////        }
////        return memberListInNoTeam;
////    }
//
//    @Override
//    public String toString() {
//        return "MemberService{" +
//                "memberRepository=" + memberRepository +
//                ", teamRepository=" + teamRepository +
//                '}';
//    }
//}
