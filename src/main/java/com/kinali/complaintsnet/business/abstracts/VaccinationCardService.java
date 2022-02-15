package com.kinali.complaintsnet.business.abstracts;

import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.entities.concretes.VaccinationCard;

import java.util.List;

public interface VaccinationCardService extends BaseEntityService<VaccinationCard>
{
    DataResult<List<VaccinationCard>> getByPatientRegistiration_Id(int patientRegistirationId);

}
