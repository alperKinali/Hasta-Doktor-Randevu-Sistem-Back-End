package com.kinali.complaintsnet.dataAccess.abstracts;

import com.kinali.complaintsnet.entities.concretes.PatientRegistiration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRegistirationDao extends JpaRepository<PatientRegistiration, Integer> {

    List<PatientRegistiration> getByPatient_Id(int patientId);
}
