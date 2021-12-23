package com.example.praticas.dto;

import com.example.praticas.entity.Diploma;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiplomaDto {
    private String msg, nome;
    private float media;

//    public static Diploma toDiploma(DiplomaDto dto) {
//        return Diploma.builder().nome()
//    }
}
