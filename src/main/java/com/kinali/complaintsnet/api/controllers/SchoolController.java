package com.kinali.complaintsnet.api.controllers;

import com.kinali.complaintsnet.business.abstracts.SchoolService;
import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school")
@CrossOrigin
public class SchoolController {

    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody School school){
        return this.schoolService.add(school);
    }

    @PutMapping("/update")
    public Result update(@RequestBody School school){
        return this.schoolService.update(school);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.schoolService.delete(id);
    }
    @GetMapping("/getall")
    public DataResult<List<School>> getAll(){
        return this.schoolService.getAll();

    }

    @GetMapping("/getbyid")
    public DataResult<School> getById(int id){
        return this.schoolService.getById(id);
    }
}
