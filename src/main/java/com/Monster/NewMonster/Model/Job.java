package com.Monster.NewMonster.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String location;
    @Min(200000)
    private Double salary;
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    private String companyEmail;
    @NotBlank
    private String companyName;
    @NotBlank
    private String employerName;
    @Enumerated(EnumType.STRING)
    private JobTypes jobTypes;
    private Date appliedDate;
}
