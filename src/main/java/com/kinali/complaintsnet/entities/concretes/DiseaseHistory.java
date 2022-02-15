package com.kinali.complaintsnet.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "disease_histories")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class DiseaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @Column(name="disease_history")
    private String diseaseHistory;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_registiration_id")
    private PatientRegistiration patientRegistiration;
}
