package com.rimore.controllers.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class UserController {

    @RequestMapping(path = "/registration", method = RequestMethod.POST)
    public ResponseEntity<String> registation(WebRequest request, Model model) {

        return new ResponseEntity<String>("User successfully registered", HttpStatus.CREATED);
    }

}