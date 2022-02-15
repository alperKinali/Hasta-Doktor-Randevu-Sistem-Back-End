package com.kinali.complaintsnet.dataAccess.abstracts;

import com.kinali.complaintsnet.entities.concretes.Complaint;
import com.kinali.complaintsnet.entities.concretes.DiseaseHistory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintDao extends JpaRepository<Complaint,Integer> {
    //List<Complaint> getByPatientRegistiration_Id(int patientRegistirationId);


    //List<Complaint> getByPatientRegistiration_Id(int patientRegistirationId, Sort sort);
}
