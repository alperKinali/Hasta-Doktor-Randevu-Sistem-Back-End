package com.kinali.complaintsnet.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "schools")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_of_educational_institution")
    private String nameOfEducationalInstitution;

    @Column(name = "department")
    private String department;

    @Column(name = "degree")
    private String degree;

    @Column(name = "starting_date")
    private LocalDate startingDate;

    @Column(name = "graduation_date")
    private LocalDate graduationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_education_id")
    private DoctorEducation doctorEducation;



}
