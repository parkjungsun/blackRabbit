package com.pjsun.blackrabbit.rest.common.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SampleRequestDto {
    @NotNull
    private Long division;
    @NotBlank
    @Pattern(regexp="^[ㄱ-ㅎ가-힣a-z0-9_-]{3,20}$")
    @Size(min=1, max=50)
    private String text;
}
