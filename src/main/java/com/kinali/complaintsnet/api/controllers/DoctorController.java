package com.kinali.complaintsnet.api.controllers;

import com.kinali.complaintsnet.business.abstracts.DoctorService;
import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.entities.concretes.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
@CrossOrigin
public class DoctorController {
    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/register")
    public Result register(@RequestBody Doctor doctor) throws Exception{
        return this.doctorService.register(doctor);
    }

    @GetMapping("/login")
    public Result login(@RequestParam String Email,@RequestParam String passwordAgain) throws Exception{
        return this.doctorService.login(Email, passwordAgain);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Doctor doctor){
        return this.doctorService.add(doctor);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Doctor doctor){
        return this.doctorService.update(doctor);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.doctorService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<Doctor>> getAll(){
        return this.doctorService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Doctor> getById(int id){
        return this.doctorService.getById(id);
    }

}
