package com.kinali.complaintsnet.business.abstracts;

import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.entities.concretes.DoctorEducation;

public interface DoctorEducationService extends BaseEntityService<DoctorEducation>{

    DataResult<DoctorEducation> getByDoctor_Id(int doctorId);
}
