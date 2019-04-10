package com.rimore.persistence.repo;

import java.util.List;
import java.util.Optional;

import com.rimore.persistence.models.AgendaRequestsModel;

import org.springframework.data.repository.CrudRepository;

public interface AgendaRequestsRepository extends CrudRepository<AgendaRequestsModel, Long> {
    List<AgendaRequestsModel> findByActive(Integer active);
}