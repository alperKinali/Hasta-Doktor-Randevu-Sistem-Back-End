package com.kinali.complaintsnet.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "doctor_educations")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class DoctorEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  int id;




    @JsonIgnore
    @OneToMany(mappedBy ="doctorEducation" )
    private List<School> schools;

    // Doctor doctoreducation kısmını bağlıyorum

    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;












}
