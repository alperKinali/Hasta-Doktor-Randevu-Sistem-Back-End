package com.kinali.complaintsnet.business.concretes;

import com.kinali.complaintsnet.business.abstracts.DateService;
import com.kinali.complaintsnet.core.utilities.*;
import com.kinali.complaintsnet.dataAccess.abstracts.DateDao;
import com.kinali.complaintsnet.entities.concretes.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DateManager implements DateService {

    private DateDao dateDao;

    @Autowired
    public DateManager(DateDao dateDao){
        this.dateDao = dateDao;
    }

    @Override
    public Result add(Date date) {
        this.dateDao.save(date);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(Date date) {
        this.dateDao.save(date);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.dateDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<Date>> getAll() {
        return new SuccessDataResult<List<Date>>(this.dateDao.findAll(),Messages.dataListed);
    }

    @Override
    public DataResult<Date> getById(int id) {
        return new SuccessDataResult<Date>(this.dateDao.getById(id), Messages.dataListed);
    }

    @Override
    public DataResult<List<Date>> getByDoctor_Id(int doctorId) {
        return new SuccessDataResult<List<Date>>(this.dateDao.getByDoctor_Id(doctorId),Messages.dataListed);
    }

    @Override
    public DataResult<List<Date>> getByDateTime(LocalDate dateTime) {
        return new SuccessDataResult<List<Date>>(this.dateDao.getByDateTime(dateTime),Messages.dataListed);
    }

    @Override
    public DataResult<List<Date>> getByDoctor_DoctorTitleAndDoctor_DoctorDegree(String doctorTitle, String doctorDegree) {
        return new SuccessDataResult<List<Date>>(this.dateDao.getByDoctor_DoctorTitleAndDoctor_DoctorDegree(doctorTitle, doctorDegree),Messages.dataListed);
    }

    @Override
    public DataResult<List<Date>> getByDoctor_DoctorTitle(String doctorTitle) {
        return new SuccessDataResult<List<Date>>(this.dateDao.getByDoctor_DoctorTitle(doctorTitle),Messages.dataListed);
    }

    @Override
    public DataResult<List<Date>> getByCity_Id(int cityId) {
        return new SuccessDataResult<List<Date>>(this.getByCity_Id(cityId),Messages.dataListed);
    }
}
