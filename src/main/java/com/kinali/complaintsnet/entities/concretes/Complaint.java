package com.kinali.complaintsnet.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "complaints")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @Column(name="complaint")
    private String complaint;

    // bunu arastır.
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_registiration_id")
    private PatientRegistiration patientRegistiration;
}
