package com.example.demo.Controllers;

import com.example.demo.Service.DTOs.DriverDTO;
import com.example.demo.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        System.out.println("DriverController.list()");
        return driverService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDriverById(@PathVariable String id) {
        return driverService.getById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DriverDTO driverDTO) {
        return driverService.create(driverDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody DriverDTO driverDTO) {
        return driverService.update(id, driverDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return driverService.deleteById(id);
    }

}
