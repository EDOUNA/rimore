package com.rimore.controllers.agenda.api;

import java.util.List;

import com.rimore.persistence.models.AgendaRequestsModel;
import com.rimore.persistence.repo.AgendaRequestsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/agendaRequests")
public class APIController {

    @Autowired
    private AgendaRequestsRepository agendaRequestsRepository;

    @GetMapping
    public Iterable<AgendaRequestsModel> findAll() {
        return agendaRequestsRepository.findAll();
    }

    @GetMapping("/byUserId/{id}")
    public ResponseEntity<List<AgendaRequestsModel>> findByUserId(@PathVariable Integer id) {
        List<AgendaRequestsModel> agendaRequests = agendaRequestsRepository.findByUserId(id);

        if (null == agendaRequests) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<AgendaRequestsModel>>(agendaRequests, HttpStatus.OK);
    }

}