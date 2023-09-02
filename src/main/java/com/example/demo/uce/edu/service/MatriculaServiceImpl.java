package com.example.demo.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.MatriculaRepository;
import com.example.demo.uce.edu.repository.model.Matricula;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements MatriculaService{

	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void registrar(Matricula matricula) {
		
		this.matriculaRepository.insertar(matricula);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardar(Matricula matricula) {
		
		this.matriculaRepository.actualizar(matricula);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Matricula buscar(Integer id) {
		
		return this.matriculaRepository.seleccionar(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void borrar(Integer id) {
		
		this.matriculaRepository.eliminar(id);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Matricula> reporteMatriculas() {
		
		return this.matriculaRepository.listaMatriculas();
	}

}
