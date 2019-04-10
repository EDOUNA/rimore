package com.rimore.persistence.repo;

import java.util.List;

import com.rimore.persistence.models.AgendaRequestsModel;

import org.springframework.data.repository.Repository;

public interface AgendaRequestsRepository extends Repository<AgendaRequestsModel, Long> {
    List<AgendaRequestsModel> findAll();

    List<AgendaRequestsModel> findByActive(Integer active);

    List<AgendaRequestsModel> findByUserId(Integer userId);
}