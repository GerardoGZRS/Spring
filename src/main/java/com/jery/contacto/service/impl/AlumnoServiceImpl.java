package com.jery.contacto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.jery.contacto.component.AlumnoComponent;
import com.jery.contacto.component.ContactConvert;
import com.jery.contacto.entity.Alumno;
import com.jery.contacto.model.AlumnoModel;
import com.jery.contacto.repository.RegistrarAlumnoRepository;
import com.jery.contacto.service.AlumnoService;
import java.util.ArrayList;

@EnableJpaRepositories(basePackages = { "com.jery.contacto.repository" })
@EntityScan(value = { "com.jery.contacto.entity" })
@Service("alumnoServiceImpl")
public class AlumnoServiceImpl implements AlumnoService{

	@Autowired
	private RegistrarAlumnoRepository registrarAlumnoRepository;
	
	@Autowired
	@Qualifier("alumnoComponent")
	private AlumnoComponent alumnoComponent;
	
	@Override
	public AlumnoModel addContact(AlumnoModel alumnoModel) {
		
		Alumno alumno = registrarAlumnoRepository.save(alumnoComponent.convertAlumnoModeltoAlumno(alumnoModel));
		return alumnoComponent.convertAlumnoToAlumnoModel(alumno);
	}

	@Override
	public List<AlumnoModel> listAllAlumno() {
            List<Alumno> listAlumnos = registrarAlumnoRepository.findAll();
            List<AlumnoModel> listAlumnoModel = new ArrayList<AlumnoModel>();
            for(Alumno a : listAlumnos){
                listAlumnoModel.add(alumnoComponent.convertAlumnoToAlumnoModel(a));
            }
		return listAlumnoModel;
	}

    @Override
    public Alumno findAlumnoById(int id) {
        
        return registrarAlumnoRepository.findById(id);
    }

    @Override
    public void removeContact(int id) {
        Alumno alumno = findAlumnoById(id);
        if (null != alumno) {
			registrarAlumnoRepository.delete(alumno);
		}
    }

    @Override
    public AlumnoModel findAlumnoByIdModel(int id) {
        return alumnoComponent.convertAlumnoToAlumnoModel(findAlumnoById(id));
    }

}
