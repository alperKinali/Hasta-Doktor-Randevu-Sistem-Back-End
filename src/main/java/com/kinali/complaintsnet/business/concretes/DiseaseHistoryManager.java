package com.kinali.complaintsnet.business.concretes;

import com.kinali.complaintsnet.business.abstracts.DiseaseHistoryService;
import com.kinali.complaintsnet.core.utilities.*;
import com.kinali.complaintsnet.dataAccess.abstracts.DiseaseHistoryDao;
import com.kinali.complaintsnet.entities.concretes.DiseaseHistory;
import com.kinali.complaintsnet.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseHistoryManager implements DiseaseHistoryService {
    private DiseaseHistoryDao diseaseHistoryDao;


    @Autowired
    public DiseaseHistoryManager(DiseaseHistoryDao diseaseHistoryDao){
        this.diseaseHistoryDao=diseaseHistoryDao;
    }


    @Override
    public Result add(DiseaseHistory diseaseHistory) {
        this.diseaseHistoryDao.save(diseaseHistory);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(DiseaseHistory diseaseHistory) {
        this.diseaseHistoryDao.save(diseaseHistory);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.diseaseHistoryDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<DiseaseHistory>> getAll() {
        return new SuccessDataResult<List<DiseaseHistory>>(this.diseaseHistoryDao.findAll());
    }

    @Override
    public DataResult<DiseaseHistory> getById(int id) {
        return  new SuccessDataResult<DiseaseHistory>(this.diseaseHistoryDao.getById(id),Messages.dataListed);
    }


    @Override
    public DataResult<List<DiseaseHistory>> getByPatientRegistiration_Id(int patientRegistirationId) {
        return  new SuccessDataResult<List<DiseaseHistory>>(this.diseaseHistoryDao.getByPatientRegistiration_Id(patientRegistirationId));
    }




}
