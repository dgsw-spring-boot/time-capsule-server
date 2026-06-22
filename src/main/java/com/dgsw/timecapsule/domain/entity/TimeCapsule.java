package com.dgsw.timecapsule.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "time_capsule")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TimeCapsule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @CreationTimestamp
    @Column
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column
    private LocalDateTime updatedAt;

    @Column
    private LocalDateTime openAt;

    @Column
    private Boolean isPublic;

    public void update(String title, String content, LocalDateTime openAt, Boolean isPublic) {
        this.title = title;
        this.content = content;
        this.openAt = openAt;
        this.isPublic = isPublic;
    }
}
