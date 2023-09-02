package com.example.demo.uce.edu.repository;

import java.util.List;

import com.example.demo.uce.edu.repository.model.Matricula;

public interface MatriculaRepository {

	public void insertar(Matricula matricula);
	public void actualizar(Matricula matricula);
    public Matricula seleccionar(Integer id);
    public void eliminar(Integer id);
    
    public List<Matricula> listaMatriculas();
}
