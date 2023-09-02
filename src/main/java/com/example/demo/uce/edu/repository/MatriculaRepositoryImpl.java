package com.example.demo.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Materia;
import com.example.demo.uce.edu.repository.model.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements MatriculaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Matricula matricula) {
		
		this.entityManager.persist(matricula);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Matricula matricula) {
		
		this.entityManager.merge(matricula);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Matricula seleccionar(Integer id) {
		
		return this.entityManager.find(Matricula.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Matricula> listaMatriculas() {
		TypedQuery<Matricula> typedQuery = this.entityManager.createQuery("SELECT mt FROM Matricula mt"
         																	, Matricula.class);
		return typedQuery.getResultList();
	}
}
