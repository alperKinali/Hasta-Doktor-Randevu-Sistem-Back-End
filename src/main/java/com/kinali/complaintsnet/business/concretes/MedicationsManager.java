package com.kinali.complaintsnet.business.concretes;

import com.kinali.complaintsnet.business.abstracts.MedicationsService;
import com.kinali.complaintsnet.core.utilities.*;
import com.kinali.complaintsnet.dataAccess.abstracts.MedicationsDao;
import com.kinali.complaintsnet.entities.concretes.Medications;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicationsManager implements MedicationsService {
    private MedicationsDao medicationsDao;

    @Autowired
    public MedicationsManager(MedicationsDao medicationsDao){
        this.medicationsDao=medicationsDao;
    }

    @Override
    public Result add(Medications medications) {
        this.medicationsDao.save(medications);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(Medications medications) {
        this.medicationsDao.save(medications);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.medicationsDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<Medications>> getAll() {
        return new SuccessDataResult<List<Medications>>(this.medicationsDao.findAll(), Messages.dataListed);
    }

    @Override
    public DataResult<Medications> getById(int id) {
        return new SuccessDataResult<Medications>(this.medicationsDao.getById(id),Messages.dataListed);
    }


    @Override
    public DataResult<List<Medications>> getByPatientRegistiration_Patient_Id(int patientId) {
        return new SuccessDataResult<List<Medications>>(this.medicationsDao.getByPatientRegistiration_Patient_Id(patientId));
    }
}
