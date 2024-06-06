package com.example.Assig3.controller;

import java.util.List;

import com.example.Assig3.model.Department_77_3;
import com.example.Assig3.service.DepartmentService_77_3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Omnia Osama Ahmed 1084505
//Maryam Mohammed Ali 1079679
//Nourhan Ahmed Elmehalawy 1078096

@RestController
public class DepartmentController_77_3 {

	@Autowired
	private DepartmentService_77_3 service;

	@GetMapping("/dept/findAll")
	public List<Department_77_3> findAll() {
		return service.getAll();
	}

	@GetMapping("/dept/find/{id}")
	public Department_77_3 findById(@PathVariable Integer id) {
		return service.findById(id);
	}
	@GetMapping("/dept/clearAllCache")
	public String clearAllCache() {
		service.clearAllCache();
		return "Data cleared from cache";
	}
	@GetMapping("/dept/clearDataFromCache/{id}")
	public String clearDataFromCache(@PathVariable Integer id) {
		service.clearDataFromCache(id);
		return id+" cleared from cache";
	}
	
}