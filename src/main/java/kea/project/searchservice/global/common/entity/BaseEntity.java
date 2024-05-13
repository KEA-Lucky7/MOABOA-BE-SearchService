package kea.project.searchservice.global.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt = LocalDateTime.now();

}