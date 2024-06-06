package com.example.Assig3.configuration;

import java.util.List;

import com.example.Assig3.model.Department_77_3;
import com.example.Assig3.service.DepartmentService_77_3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


import jakarta.annotation.PostConstruct;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfig_77_3 {

	@Autowired
	private CacheManager cacheManager;
	
	@Autowired
	DepartmentService_77_3 departmentService;
	
	@PostConstruct
	public void preloadCache() {
		
		Cache cache = cacheManager.getCache("applicationCache");
		
		System.out.println("****** Initializing Cache");
		
		List<Department_77_3> deptList = departmentService.getAll();
		
		for (Department_77_3 department : deptList) {
			cache.put(department.getId(), department);
		}

}
}
