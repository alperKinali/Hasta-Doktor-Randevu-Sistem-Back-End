package com.kinali.complaintsnet.dataAccess.abstracts;

import com.kinali.complaintsnet.entities.concretes.DoctorEducation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorEducationDao extends JpaRepository<DoctorEducation,Integer> {

    DoctorEducation getByDoctor_Id(int doctorId);
    // doctor education için ıd'değerleri gönderiliyor.



}
