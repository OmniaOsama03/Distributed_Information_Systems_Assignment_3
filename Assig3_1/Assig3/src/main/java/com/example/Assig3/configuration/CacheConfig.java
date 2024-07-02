package com.example.Assig3.configuration;

import java.util.List;

import com.example.Assig3.model.Department;
import com.example.Assig3.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


import jakarta.annotation.PostConstruct;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfig {

	@Autowired
	private CacheManager cacheManager;
	
	@Autowired
	DepartmentService departmentService;
	
	@PostConstruct
	public void preloadCache() {
		
		Cache cache = cacheManager.getCache("applicationCache");
		
		System.out.println("****** Initializing Cache");
		
		List<Department> deptList = departmentService.getAll();
		
		for (Department department : deptList) {
			cache.put(department.getId(), department);
		}

}
}
