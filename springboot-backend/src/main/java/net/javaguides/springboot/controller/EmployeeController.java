/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(method = RequestMethod.OPTIONS)
    ResponseEntity<?> options() {
      // @formatter:off
	  return ResponseEntity.ok().allow(
		       HttpMethod.GET,
		       HttpMethod.POST,
		       HttpMethod.HEAD,
		       HttpMethod.OPTIONS,
		       HttpMethod.PUT,
		       HttpMethod.DELETE).
		       build(); 
	  // @formatter:on
    }

    // get all employees
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok(this.employeeRepository.findAll());
    }

    // create employee rest api
    @PostMapping("/employees")
    public ResponseEntity<Employee> insert(@Validated @RequestBody Employee employee) {
        // Employee save = this.employeeRepository.save(employee);
        return ResponseEntity.ok(employee);
    }
}
