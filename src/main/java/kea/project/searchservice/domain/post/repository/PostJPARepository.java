package kea.project.searchservice.domain.post.repository;

import kea.project.searchservice.domain.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostJPARepository extends JpaRepository<PostEntity, Long> {
}
