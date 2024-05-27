package kea.project.searchservice.domain.blog.repository;

import kea.project.searchservice.domain.blog.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogJPARepository extends JpaRepository<BlogEntity,Long> {
}
