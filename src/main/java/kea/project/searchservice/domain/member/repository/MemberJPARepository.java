package kea.project.searchservice.domain.member.repository;

import kea.project.searchservice.domain.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberJPARepository extends JpaRepository<MemberEntity,Long> {
}
