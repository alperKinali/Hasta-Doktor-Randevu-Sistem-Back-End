package com.kinali.complaintsnet.business.concretes;

import com.kinali.complaintsnet.business.abstracts.VaccinationCardService;
import com.kinali.complaintsnet.core.utilities.*;
import com.kinali.complaintsnet.dataAccess.abstracts.UserDao;
import com.kinali.complaintsnet.dataAccess.abstracts.VaccinationCardDao;
import com.kinali.complaintsnet.entities.concretes.User;
import com.kinali.complaintsnet.entities.concretes.VaccinationCard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinationCardManager implements VaccinationCardService {
    private VaccinationCardDao vaccinationCardDao;

    public  VaccinationCardManager(VaccinationCardDao vaccinationCardDao){
        this.vaccinationCardDao=vaccinationCardDao;

    }



    @Override
    public Result add(VaccinationCard vaccinationCard) {
        this.vaccinationCardDao.save(vaccinationCard);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(VaccinationCard vaccinationCard) {
        this.vaccinationCardDao.save(vaccinationCard);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.vaccinationCardDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<VaccinationCard>> getAll() {
        return new SuccessDataResult<List<VaccinationCard>>(this.vaccinationCardDao.findAll());
    }

    @Override
    public DataResult<VaccinationCard> getById(int id) {
        return new SuccessDataResult<VaccinationCard>(this.vaccinationCardDao.getById(id),Messages.dataListed);
    }

    @Override
    public DataResult<List<VaccinationCard>> getByPatientRegistiration_Id(int patientRegistirationId) {
        return new SuccessDataResult<List<VaccinationCard>>(this.vaccinationCardDao.getByPatientRegistiration_Id(patientRegistirationId),Messages.dataListed);
    }
}
