package com.kinali.complaintsnet.api.controllers;

import com.kinali.complaintsnet.business.abstracts.DateService;
import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.entities.concretes.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/date")
@CrossOrigin
public class DateController {
    private DateService dateService;

    @Autowired
    public DateController(DateService dateService) {
        this.dateService = dateService;
    }

    @PostMapping("/add")
   public Result add(@RequestBody Date date){
        return this.dateService.add(date);
   }

    @PutMapping("/update")
    public Result update(@RequestBody Date date){
        return this.dateService.update(date);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.dateService.delete(id);
    }
    @GetMapping("/getall")
    public DataResult<List<Date>> getAll(){
        return this.dateService.getAll();

    }
    @GetMapping("/getbyid")
    public DataResult<Date> getById(int id){
        return this.dateService.getById(id);

    }
    @GetMapping("getbydoctorid")
    public DataResult<List<Date>> getByDoctor_Id(int doctorId){
        return this.dateService.getByDoctor_Id(doctorId);
    }

    @GetMapping("getbydatetime")
    public DataResult<List<Date>> getByDateTime(LocalDate dateTime){
        return this.dateService.getByDateTime(dateTime);

    }
    @GetMapping("getbydoctordoctortitleanddoctordoctordegree")
    public DataResult<List<Date>> getByDoctor_DoctorTitleAndDoctor_DoctorDegree(String doctorTitle,String doctorDegree){
        return this.dateService.getByDoctor_DoctorTitleAndDoctor_DoctorDegree(doctorTitle,doctorDegree);
    }
    @GetMapping("getbydoctordoctortitle")
    public DataResult<List<Date>> getByDoctor_DoctorTitle(String doctorTitle){
        return this.dateService.getByDoctor_DoctorTitle(doctorTitle);
    }
    @GetMapping("getbycityid")
    public DataResult<List<Date>> getByCity_Id(int cityId){
        return this.dateService.getByCity_Id(cityId);
    }

}
