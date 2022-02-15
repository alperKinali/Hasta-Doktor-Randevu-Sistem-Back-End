package com.kinali.complaintsnet.api.controllers;

import com.kinali.complaintsnet.business.abstracts.UserService;
import com.kinali.complaintsnet.business.abstracts.VaccinationCardService;
import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.entities.concretes.User;
import com.kinali.complaintsnet.entities.concretes.VaccinationCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacinationCard")
@CrossOrigin
public class VaccinationCardController {
    private VaccinationCardService vaccinationCardService;

    @Autowired
    public  VaccinationCardController(VaccinationCardService vaccinationCardService){
        this.vaccinationCardService=vaccinationCardService;
    }
    @PostMapping("/add")
    public Result add(@RequestBody VaccinationCard vaccinationCard){
        return this.vaccinationCardService.add(vaccinationCard);
    }
    @PutMapping("/update")
    public Result update(@RequestBody VaccinationCard vaccinationCard){
        return this.vaccinationCardService.update(vaccinationCard);
    }
    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.vaccinationCardService.delete(id);
    }
    @GetMapping("/getall")
    public DataResult<List<VaccinationCard>> getAll(){
        return this.vaccinationCardService.getAll();
    }
    @GetMapping("/getbyid")
    public DataResult<VaccinationCard> getById(int id){
        return this.vaccinationCardService.getById(id);
    }

    @GetMapping("/getbypatientregistirationid")
    public DataResult<List<VaccinationCard>> getByPatientRegistiration_Id(int patientRegistirationId){
        return this.vaccinationCardService.getByPatientRegistiration_Id(patientRegistirationId);
    }



}
