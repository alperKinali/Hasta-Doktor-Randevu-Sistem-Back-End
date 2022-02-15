package com.kinali.complaintsnet.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "patient_registirations")
public class PatientRegistiration  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @JsonIgnore
    @OneToMany(mappedBy = "patientRegistiration")
    private List<Medications> medications;

    @JsonIgnore
    @OneToMany(mappedBy = "patientRegistiration")
    private List<Complaint> complaints;

    @JsonIgnore
    @OneToMany(mappedBy = "patientRegistiration")
    private List<DiseaseHistory> diseaseHistories;

    @JsonIgnore
    @OneToMany(mappedBy = "patientRegistiration")
    private List<VaccinationCard> vaccinationCards;

    public PatientRegistiration(Patient patient){
        this.setPatient(patient);
    }

}
