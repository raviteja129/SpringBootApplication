package com.example.Reservation.controller;

import com.example.Reservation.exception.ResourceNotFoundException;
import com.example.Reservation.model.UsersModel;
import com.example.Reservation.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepo;

    @GetMapping
    public List<UsersModel> getAllUsers() {
        return usersRepo.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<UsersModel> getUser(@PathVariable long id) {
        UsersModel usersModel = usersRepo.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User does not exists with id: " + id));
        return ResponseEntity.ok(usersModel);
    }

    @PostMapping
    public UsersModel createUsers(@RequestBody UsersModel usersModel) {
        return usersRepo.save(usersModel);
    }

    @PutMapping("{id}")
    public ResponseEntity<UsersModel> updateUser(@PathVariable long id, @RequestBody UsersModel userDetails) {
        UsersModel updateUser = usersRepo.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User does not exists with id: " + id));
        updateUser.setLoginId(userDetails.getLoginId());
        updateUser.setFname(userDetails.getFname());
        updateUser.setLname(userDetails.getLname());
        updateUser.setEmail(userDetails.getEmail());
        updateUser.setMobile(userDetails.getMobile());
        updateUser.setPassword(userDetails.getPassword());
        usersRepo.save(updateUser);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id) {
        UsersModel usersModel = usersRepo.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User does not exists with id: " + id));
        usersRepo.delete(usersModel);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
