package com.moisesreto.catalogo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.moisesreto.catalogo.model.Courses;

@Mapper
public interface CoursesMapper {

	@Select("select * from courses")
	List<Courses> findAll();
	
	
	 @Insert("INSERT INTO Courses ( titulo,nivel,profesor,activo,horas ) VALUES ( #{course.titulo}, #{course.nivel},#{course.profesor},#{course.activo}, #{course.horas})")
	 Boolean insertCourse(@Param("course") Courses course) throws Exception;
	

}
