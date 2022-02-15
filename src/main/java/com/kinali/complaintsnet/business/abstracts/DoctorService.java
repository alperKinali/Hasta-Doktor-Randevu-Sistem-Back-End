package com.kinali.complaintsnet.business.abstracts;

import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.entities.concretes.Doctor;
import com.kinali.complaintsnet.entities.concretes.Patient;

public interface DoctorService extends BaseEntityService<Doctor>{
    Result register(Doctor doctor) throws Exception;
    Result login(String Email, String passwordAgain) throws Exception;
}
