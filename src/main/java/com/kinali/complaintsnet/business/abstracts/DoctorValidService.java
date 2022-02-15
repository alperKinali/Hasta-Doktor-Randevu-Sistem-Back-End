package com.kinali.complaintsnet.business.abstracts;

import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.entities.concretes.Doctor;
import com.kinali.complaintsnet.entities.concretes.Patient;

public interface DoctorValidService {
    Result validate(Doctor doctor) throws Exception;
}
