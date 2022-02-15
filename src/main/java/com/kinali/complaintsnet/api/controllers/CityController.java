package com.kinali.complaintsnet.api.controllers;

import com.kinali.complaintsnet.business.abstracts.CityService;
import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
@CrossOrigin
public class CityController {
    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody City city){
        return cityService.add(city);
    }

    @PutMapping("/update")
    public Result update(@RequestBody City city){
        return cityService.update(city);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        return cityService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<City>> getAll(){
        return cityService.getAll();

    }

    @GetMapping("/getbyid")
    public DataResult<City> getById(int id){
        return cityService.getById(id);
    }

}
