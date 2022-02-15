package com.kinali.complaintsnet.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "patients")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Patient extends User {

    /*
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
     */

    @Column(name="identiy_number")
    private  String identityNumber;

    @Column(name="age_of_year")
    private  int ageOfYear;



}
