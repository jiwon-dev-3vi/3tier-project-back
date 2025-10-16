package com.example.project.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 모든 엔티티에 공통적으로 필요한 생성일과 수정일에 대한 BaseEntity입니다. 
 * 
 * 생성일과 수정일이 필요한 엔티티는 BaseEntity를 상속받아야 합니다.  
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    // 엔티티가 생성되어 저장될 때 시간이 자동 저장됩니다.
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // 조회한 엔티티의 값을 변경할 때 시간이 자동 저장됩니다.
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime modifieddAt;
}