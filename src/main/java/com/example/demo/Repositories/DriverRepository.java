package com.example.demo.Repositories;


import com.example.demo.Entities.DriverEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends CrudRepository<DriverEntity, Long> {
}
