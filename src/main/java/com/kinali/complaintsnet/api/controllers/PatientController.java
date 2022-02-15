package com.kinali.complaintsnet.api.controllers;


import com.kinali.complaintsnet.business.abstracts.PatientService;
import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.entities.concretes.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
@CrossOrigin
public class PatientController {
    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }

    //auth için controller
    @PostMapping("/register")
    public Result register(@RequestBody Patient patient) throws Exception{
        return this.patientService.register(patient);
    }

    @GetMapping("/login")
    public Result login(@RequestParam String eMail,@RequestParam String passwordAgain) throws Exception{
        return this.patientService.login(eMail, passwordAgain);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Patient patient){
        return  this.patientService.add(patient);
    }
    @PutMapping("/update")
    public Result update(@RequestBody Patient patient){
        return this.patientService.update(patient);
    }

    @DeleteMapping("/delete")
    public Result delete( int id){
        return  this.patientService.delete(id);
    }
    @GetMapping("/getall")
    public DataResult<List<Patient>> getAll(){
        return this.patientService.getAll();

    }

    @GetMapping("/getByidentitynumber")
    public DataResult<Patient> getByNationalIdNumber(String identitynumber){
        return this.patientService.getByIdentityNumber(identitynumber);
    }


}
