package com.fastcampus.loan.domain;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert // Hibernate에서 `INSERT` 시 기본값이 설정된 필드를 제외하고 동적으로 SQL을 생성
@DynamicUpdate // Hibernate에서 `UPDATE` 시 변경된 필드만 포함하여 동적으로 SQL을 생성
@Where(clause = "is_deleted=false")  // 이 엔티티에 대한 조회 시, `is_deleted=false` 조건이 항상 붙도록 함
public class Counsel extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long conuselId;

    @Column(nullable = false, columnDefinition = "datetime COMMENT '신청일자'")
    private LocalDateTime appliedAt;

    @Column(nullable = false, columnDefinition = "varchar(12) COMMENT '상담 요청자'")
    private String name;

    @Column(nullable = false, columnDefinition = "varchar(23) COMMENT '전화번호'")
    private String cellPhone;

    @Column(columnDefinition = "varchar(50) DEFAULT NULL COMMENT '상담요청자 이메일'")
    private String email;

    @Column(columnDefinition = "text DEFAULT NULL COMMENT '상담메모'")
    private String memo;

    @Column(columnDefinition = "varchar(50) DEFAULT NULL COMMENT '주소'")
    private String address;

    @Column(columnDefinition = "varchar(50) DEFAULT NULL COMMENT '상세 주소'")
    private String adressDetail;

    @Column(columnDefinition = "varchar(50) DEFAULT NULL COMMENT '우편번호'")
    private String zipCode;
}
