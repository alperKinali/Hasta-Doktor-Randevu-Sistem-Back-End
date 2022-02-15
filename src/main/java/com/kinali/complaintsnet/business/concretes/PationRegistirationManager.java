package com.kinali.complaintsnet.business.concretes;

import com.kinali.complaintsnet.business.abstracts.*;
import com.kinali.complaintsnet.core.utilities.*;
import com.kinali.complaintsnet.dataAccess.abstracts.PatientRegistirationDao;
import com.kinali.complaintsnet.entities.concretes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PationRegistirationManager implements PatientRegistirationService {

    private PatientRegistirationDao patientRegistirationDao;
    //private MedicationsService medicationsService;
    //private ComplaintService complaintService;
    //private DiseaseHistoryService diseaseHistoryService;
    //private VaccinationCardService vaccinationCardService;

    @Autowired
    public PationRegistirationManager(PatientRegistirationDao patientRegistirationDao) {
        this.patientRegistirationDao=patientRegistirationDao;

    }
    @Override
    public Result add(PatientRegistiration patientRegistiration) {
      this.patientRegistirationDao.save(patientRegistiration);
        return new SuccessResult(Messages.successAdd);

    }

    @Override
    public Result update(PatientRegistiration patientRegistiration) {
        this.patientRegistirationDao.save(patientRegistiration);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.patientRegistirationDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<PatientRegistiration>> getAll() {
        return new SuccessDataResult<List<PatientRegistiration>>(this.patientRegistirationDao.findAll(),Messages.dataListed);
    }

    @Override
    public DataResult<PatientRegistiration> getById(int id) {
        return new SuccessDataResult<PatientRegistiration>(this.patientRegistirationDao.getById(id),Messages.dataListed);

    }

    @Override
    public DataResult<List<PatientRegistiration>> getByPatient_Id(int patientId) {
        return new SuccessDataResult<List<PatientRegistiration>>(this.patientRegistirationDao.getByPatient_Id(patientId),Messages.dataListed);
    }
}
