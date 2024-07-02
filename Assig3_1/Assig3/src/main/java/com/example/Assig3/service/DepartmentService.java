package com.example.Assig3.service;
import java.util.List;

import com.example.Assig3.model.Department;
import com.example.Assig3.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

//Omnia Osama Ahmed 1084505
//Maryam Mohammed Ali 1079679
//Nourhan Ahmed Elmehalawy 1078096

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;

	public List<Department> getAll() {
		return repository.findAll();
	}

	@Cacheable(value="applicationCache", key="#deptId")
	public Department findById(Integer deptId) {
		return repository.findById(deptId).get();
	}
	
	@CacheEvict(value="applicationCache", allEntries=true)
	public void clearAllCache() {
		System.out.println("**** All cache evicted ***");
	}
	
	@CacheEvict(value="applicationCache", key="#deptId")
	public void clearDataFromCache(Integer deptId) {
		System.out.println("**** Data evicted from Cache : "+deptId);
	}
	
}