package com.jery.contacto.service;

import com.jery.contacto.entity.Alumno;
import java.util.List;

import com.jery.contacto.model.AlumnoModel;

public interface AlumnoService {
	public abstract AlumnoModel addContact(AlumnoModel alumnoModel);
	public abstract List<AlumnoModel> listAllAlumno();
        public abstract Alumno findAlumnoById(int id);
        public abstract void removeContact(int id);
	public abstract AlumnoModel findAlumnoByIdModel(int id);

}
