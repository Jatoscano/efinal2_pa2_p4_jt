package com.example.demo.uce.edu.service;

import java.util.List;

import com.example.demo.uce.edu.repository.model.Matricula;

public interface MatriculaService {

	public void registrar(Matricula matricula);
	public void guardar(Matricula matricula);
    public Matricula buscar(Integer id);
    public void borrar(Integer id);
    
    public List<Matricula> reporteMatriculas();
}
