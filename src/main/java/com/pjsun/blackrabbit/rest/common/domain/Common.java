package com.pjsun.blackrabbit.rest.common.domain;

import com.pjsun.blackrabbit.rest.common.converter.BooleanToYNConverter;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

/* JPA 테스트를 위한 공통 Entity */
@Slf4j @ToString
@Entity @Getter
@Table(name = "common")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Common extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "common_id")
    private Long id;
    @Column(name = "nm", length = 50, nullable = false)
    private String nm;
    @Column(name="cnt",length = 4096)
    private String cnt;
    @Convert(converter = BooleanToYNConverter.class)
    @Column(name="use_yn", length = 1)
    private boolean useYn;
}
