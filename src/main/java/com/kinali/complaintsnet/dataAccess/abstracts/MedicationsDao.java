package com.kinali.complaintsnet.dataAccess.abstracts;

import com.kinali.complaintsnet.entities.concretes.Medications;
import com.kinali.complaintsnet.entities.concretes.PatientRegistiration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationsDao extends JpaRepository<Medications,Integer> {
    List<Medications> getByPatientRegistiration_Patient_Id(int patientId);
}
