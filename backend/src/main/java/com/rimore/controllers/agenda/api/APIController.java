package com.rimore.controllers.agenda.api;

import java.util.List;

import javax.validation.Valid;

import com.rimore.persistence.models.AgendaRequestsModel;
import com.rimore.persistence.repo.AgendaRequestsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/agendaRequests")
public class APIController {

    /**
     *
     */
    @Autowired
    private AgendaRequestsRepository agendaRequestsRepository;

    /**
     * Return all availanle agenda requests
     * 
     * @TODO: fix this later on; this should not end in a production situation
     * @return
     */

    @GetMapping
    public Iterable<AgendaRequestsModel> findAll() {
        return agendaRequestsRepository.findAll();
    }

    /**
     * Find all requests for a specific userId
     * 
     * @param id
     * @return
     */
    @GetMapping("/byUserId/{id}")
    public ResponseEntity<?> findByUserId(@PathVariable Integer id) {
        List<AgendaRequestsModel> agendaRequests = agendaRequestsRepository.findByUserId(id);

        if (agendaRequests.isEmpty()) {
            return new ResponseEntity<String>("No user found with ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<AgendaRequestsModel>>(agendaRequests, HttpStatus.OK);
    }

    /**
     * Create a new agenda request
     * 
     * @param agendaRequestsModel
     * @return
     */
    @PostMapping(path = "/createRequest", consumes = "application/json")
    public ResponseEntity<String> createRequest(@Valid @RequestBody AgendaRequestsModel agendaRequestsModel) {
        AgendaRequestsModel saveNewRequestsModel = agendaRequestsRepository.save(agendaRequestsModel);

        if (null == saveNewRequestsModel) {
            return new ResponseEntity<String>("Could not create entry", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>("Entry successfully created", HttpStatus.CREATED);
    }

    /**
     * Delete request
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/deleteRequest/{id}")
    public ResponseEntity<HttpStatus> deleteRequest(@PathVariable Long id) {
        List<AgendaRequestsModel> agendaRequest = agendaRequestsRepository.findFirstById(id);

        if (agendaRequest.isEmpty()) {
            return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
        }

        agendaRequestsRepository.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    /**
     * Update request
     * 
     * @param id
     * @return
     */
    @PutMapping("/updateRequest/{id}")
    public ResponseEntity<String> updateRequest(@PathVariable Long id) {
        List<AgendaRequestsModel> agendaRequest = agendaRequestsRepository.findFirstById(id);

        if (agendaRequest.isEmpty()) {
            return new ResponseEntity<String>("Could not find agenda request ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<String>("Record successfully updated", HttpStatus.OK);
    }
}