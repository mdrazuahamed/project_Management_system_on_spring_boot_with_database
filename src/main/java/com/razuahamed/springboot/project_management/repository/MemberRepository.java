
package com.razuahamed.springboot.project_management.repository;
import com.razuahamed.springboot.project_management.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface MemberRepository extends JpaRepository<Member,Long> {

    public Member findByName(String name);

    public void deleteById(Member member);

    Member findByIdEquals(long memberId);
}
