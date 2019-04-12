package com.rimore.controllers.user;

import javax.validation.Valid;

import com.rimore.persistence.models.UserModel;
import com.rimore.persistence.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository UserRepository;

    /**
     * Create a new user via form registration
     * 
     * @param userModel
     * @return
     */
    @RequestMapping(path = "/registration", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> registation(@Valid @RequestBody UserModel userModel) {
        UserModel newUser = UserRepository.save(userModel);

        if (null == newUser) {
            return new ResponseEntity<String>("User could not be created", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>("User successfully registered", HttpStatus.CREATED);
    }

}