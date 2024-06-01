package kea.project.searchservice.domain.post.repository;

import kea.project.searchservice.domain.post.entity.PostLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikeJPARepository extends JpaRepository<PostLikeEntity, Long> {
}
