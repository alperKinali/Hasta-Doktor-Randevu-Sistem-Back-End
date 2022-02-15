package com.kinali.complaintsnet.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "vaccination_cards")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class VaccinationCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @Column(name="name")
    private String name;

    @Column(name="vaccination_date")
    private LocalDate vaccinationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_registiration_id")
    private PatientRegistiration patientRegistiration;


}
