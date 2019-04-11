package com.rimore.persistence.repo;

import java.util.Optional;

import com.rimore.persistence.models.UserModel;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long> {
    Optional<UserModel> findFirstById(Long id);

    Optional<UserModel> findFirstByEmail(String email);
}