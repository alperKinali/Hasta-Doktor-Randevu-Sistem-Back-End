package com.kinali.complaintsnet.api.controllers;

import com.kinali.complaintsnet.business.abstracts.UserService;
import com.kinali.complaintsnet.core.utilities.DataResult;
import com.kinali.complaintsnet.core.utilities.Result;
import com.kinali.complaintsnet.entities.concretes.Patient;
import com.kinali.complaintsnet.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    private UserService userService;

    @Autowired
    public  UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping("/add")
    public Result add(@RequestBody User user){
        return this.userService.add(user);
    }
    @PutMapping("/update")
    public Result update(@RequestBody User user){
        return this.userService.update(user);
    }
    @DeleteMapping("/delete")
    public Result delete(int id){
        return this.userService.delete(id);
    }
    @GetMapping("/getall")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }
    @GetMapping("/getbyid")
    public DataResult<User> getById(int id){
        return this.userService.getById(id);
    }
    @GetMapping("/getbyemail")
    public DataResult<User> getByEmail(String email){
        return this.userService.getByEmail(email);
    }
}
