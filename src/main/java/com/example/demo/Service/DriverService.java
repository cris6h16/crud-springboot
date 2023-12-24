package com.example.demo.Service;

import com.example.demo.Exceptions.DriverNotFoundExceptionHttp;
import com.example.demo.Exceptions.IdNotIsLongExceptionHttp;
import com.example.demo.Exceptions.IlegalArgumentExeptionHttp;
import com.example.demo.Exceptions.OptimisticLockingFailureExceptionHttp;
import com.example.demo.Service.DTOs.DriverDTO;
import com.example.demo.Repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.Entities.DriverEntity;

import java.net.URI;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    public ResponseEntity<?> list() {
        return ResponseEntity.status(HttpStatus.OK).body(driverRepository.findAll());
    }

    public ResponseEntity<?> getById(String idString) {
        Long id = parseId(idString);

        DriverEntity driverEntity = driverRepository.findById(id)
                .orElseThrow(DriverNotFoundExceptionHttp::new);

        return ResponseEntity.status(HttpStatus.FOUND).body(driverEntity);
    }

    public ResponseEntity<?> create(DriverDTO driverDTO) {

        DriverEntity driverEntity = DriverEntity.builder()
                .name(driverDTO.getName())
                .age(driverDTO.getAge())
                .build();

        driverEntity = saveHandledExceptions(driverEntity);

        return ResponseEntity.created(
                        URI.create("/api/driver/" + driverEntity.getId()))
                .body(driverEntity);
    }

    public ResponseEntity<?> update(String idString, DriverDTO driverDTO) {
        Long id = parseId(idString);

        DriverEntity driverEntity = driverRepository.findById(id)
                .orElseThrow(DriverNotFoundExceptionHttp::new);

        driverEntity.setName(driverDTO.getName());
        driverEntity.setAge(driverDTO.getAge());

        saveHandledExceptions(driverEntity);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public ResponseEntity<?> deleteById(String idString) {
        Long id = parseId(idString);

        driverRepository.findById(id).orElseThrow(DriverNotFoundExceptionHttp::new);
        driverRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public DriverEntity saveHandledExceptions(DriverEntity driverEntity) {
        try {
            driverEntity = driverRepository.save(driverEntity);
        } catch (IllegalArgumentException e) {
            throw new IlegalArgumentExeptionHttp(e.getMessage(), e.getCause());
        } catch (OptimisticLockingFailureException e) {
            throw new OptimisticLockingFailureExceptionHttp(e.getMessage(), e.getCause());
        }
        return driverEntity;
    }

    public Long parseId(String idString) {
        Long id;
        try {
            id = Long.parseLong(idString);
        } catch (NumberFormatException e) {
            throw new IdNotIsLongExceptionHttp(e.getCause());
        }
        return id;
    }
}