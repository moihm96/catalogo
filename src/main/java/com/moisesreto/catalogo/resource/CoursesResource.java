package com.moisesreto.catalogo.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moisesreto.catalogo.mapper.CoursesMapper;
import com.moisesreto.catalogo.model.Courses;



@RestController
@RequestMapping("/rest/courses")
public class CoursesResource {
	
	private CoursesMapper coursesMapper;
	
	
	
	public CoursesResource(CoursesMapper coursesMapper) {
		this.coursesMapper = coursesMapper;
	}


	
	@GetMapping("/all")
	public List<Courses> getAll(){
		return coursesMapper.findAll();
	}
	
	@PostMapping(path = "/nuevo", consumes = "application/json", produces = "application/json")
	public Boolean createCourse(@RequestBody Courses course) {
		try {
			coursesMapper.insertCourse(course);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
