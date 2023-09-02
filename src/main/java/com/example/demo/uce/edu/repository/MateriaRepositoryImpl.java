package com.example.demo.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MateriaRepositoryImpl implements MateriaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Materia materia) {
		
		this.entityManager.persist(materia);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Materia materia) {
		
		this.entityManager.merge(materia);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Materia seleccionar(Integer id) {
		
		return this.entityManager.find(Materia.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Materia> listaMaterias() {
		TypedQuery<Materia> typedQuery = this.entityManager.createQuery("SELECT ma FROM Materia ma"
		                                                         		, Materia.class);
		return typedQuery.getResultList();
	}

}
