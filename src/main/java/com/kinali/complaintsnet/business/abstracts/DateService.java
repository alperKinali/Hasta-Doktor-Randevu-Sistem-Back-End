package com.kinali.complaintsnet.business.abstracts;

import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.entities.concretes.Date;

import java.time.LocalDate;
import java.util.List;

public interface DateService extends BaseEntityService<Date>{

    DataResult<List<Date>> getByDoctor_Id(int doctorId);
    DataResult<List<Date>> getByDateTime(LocalDate dateTime);
    DataResult<List<Date>> getByDoctor_DoctorTitleAndDoctor_DoctorDegree(String doctorTitle,String doctorDegree);
    DataResult<List<Date>> getByDoctor_DoctorTitle(String doctorTitle);
    DataResult<List<Date>> getByCity_Id(int cityId);



}
