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
@Table(name = "doctors")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Doctor extends  User{
    @Column(name ="hospital_name")
    private String hospitalName;

    @Column(name ="hospital_address")
    private String hospitalAddress;

    @Column(name="doctor_degree")
    private String doctorDegree;
    ///DOc profosör, asistan, yarDoc

    @Column(name="doctor_tittle")
    private String doctorTitle;
    // göz doktoru alanı kalp doktoru vb

    public Doctor(int id, String firstName, String lastName, String email, String password, String hospitalName, String doctorTitle) {
        super.setId(id);
        super.setEmail(email);
        super.setPassword(password);
        this.setHospitalName(hospitalName);
        this.setDoctorTitle(doctorTitle);
    }
}
