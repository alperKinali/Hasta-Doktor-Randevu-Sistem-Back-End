package com.kinali.complaintsnet.dataAccess.abstracts;

import com.kinali.complaintsnet.entities.concretes.Date;
import com.kinali.complaintsnet.entities.concretes.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;

public interface DateDao extends JpaRepository<Date,Integer> {
    List<Date> getByDoctor_Id(int doctorId);
    List<Date> getByDateTime(LocalDate dateTime);
    List<Date> getByDoctor_DoctorTitleAndDoctor_DoctorDegree(String doctorTitle,String doctorDegree);
    List<Date> getByDoctor_DoctorTitle(String doctorTitle);
    List<Date> getByCity_Id(int cityId);






}
