package com.jery.contacto.component;

import org.springframework.stereotype.Component;

import com.jery.contacto.entity.Alumno;
import com.jery.contacto.model.AlumnoModel;

@Component("alumnoComponent")
public class AlumnoComponent {
	
	public Alumno convertAlumnoModeltoAlumno(AlumnoModel alumnoModel) {
		Alumno alumno = new Alumno();
		alumno.setId(alumnoModel.getId());
		alumno.setNombre(alumnoModel.getNombre());
		alumno.setApellidoPaterno(alumnoModel.getApellidoPaterno());
		alumno.setApellidoMaterno(alumnoModel.getApellidoMaterno());;
		alumno.setEdad(alumnoModel.getEdad());
		alumno.setCorreo(alumnoModel.getCorreo());
		
		return alumno;
	}
	
	public AlumnoModel convertAlumnoToAlumnoModel(Alumno alumno) {
		AlumnoModel alumnoModel = new AlumnoModel();
		alumnoModel.setId(alumno.getId());
		alumnoModel.setNombre(alumno.getNombre());
		alumnoModel.setApellidoPaterno(alumno.getApellidoPaterno());
		alumnoModel.setApellidoMaterno(alumno.getApellidoMaterno());;
		alumnoModel.setEdad(alumno.getEdad());
		alumnoModel.setCorreo(alumno.getCorreo());
		return alumnoModel;
	}

}
