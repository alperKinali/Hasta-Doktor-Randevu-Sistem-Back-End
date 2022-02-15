package com.kinali.complaintsnet.business.concretes;

import com.kinali.complaintsnet.business.abstracts.SchoolService;
import com.kinali.complaintsnet.core.utilities.*;
import com.kinali.complaintsnet.dataAccess.abstracts.SchoolDao;
import com.kinali.complaintsnet.entities.concretes.School;
import com.kinali.complaintsnet.entities.concretes.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {
    private SchoolDao schoolDao;

    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public Result add(School school) {
        this.schoolDao.save(school);
        return new SuccessResult(Messages.successAdd);
    }

    @Override
    public Result update(School school) {
        this.schoolDao.save(school);
        return new SuccessResult(Messages.successUpdate);
    }

    @Override
    public Result delete(int id) {
        this.schoolDao.deleteById(id);
        return new SuccessResult(Messages.successDelete);
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<List<School>>(this.schoolDao.findAll());
    }

    @Override
    public DataResult<School> getById(int id) {
        return new SuccessDataResult<School>(this.schoolDao.getById(id),Messages.dataListed);
    }

}
