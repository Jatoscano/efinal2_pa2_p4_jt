package com.example.demo.uce.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.uce.edu.repository.model.Estudiante;
import com.example.demo.uce.edu.repository.model.Materia;
import com.example.demo.uce.edu.repository.model.Matricula;
import com.example.demo.uce.edu.service.EstudianteService;
import com.example.demo.uce.edu.service.MateriaService;
import com.example.demo.uce.edu.service.MatriculaService;

@Controller
@RequestMapping("/universidad")
public class MatriculaController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private MateriaService materiaService;
	
	@Autowired
	private MatriculaService matriculaService;
	
	// http://localhost:8080/uce/universidad/ingresarEstudiante
	@PostMapping("/ingresarEstudiante")
	public String insertarEstudiante(Estudiante estudiante) {
		this.estudianteService.registrar(estudiante);
		return "redirect:/universidad/reporteEstudiante";
	}
	
	// http://localhost:8080/uce/universidad/ingresarMateria
		@PostMapping("/ingresarMateria")
		public String insertarMateria(Materia materia) {
			this.materiaService.registrar(materia);
			return "redirect:/universidad/reporteEstudiante";
		}
		
	// http://localhost:8080/uce/universidad/ingresarMatricula
		@PostMapping("/ingresarMatricula")
		public String insertarEstudiante(Matricula matricula) {
			this.matriculaService.registrar(matricula);
			return "redirect:/universidad/reporteEstudiante";
		}	
	
	// Metodo de Pagina de ReDireccionamiento
	// http://localhost:8080/uce/universidad/nuevoPropietario
	@GetMapping("/nuevoEstudiante")
	public String paginaNuevoEstudiante(Model model, Estudiante estudiante) {
		model.addAttribute("estudiante", estudiante);
		return "vistaNuevoEstudiante";
	}
		
	// Metodo de Pagina de ReDireccionamiento
	// http://localhost:8080/uce/universidad/nuevaMateria
	@GetMapping("/nuevaMateria")
	public String paginaNuevaMateria(Model model, Materia materia) {
		model.addAttribute("materia", materia);
		return "vistaNuevaMateria";
	}
	
	// Metodo de Pagina de ReDireccionamiento
	// http://localhost:8080/uce/universidad/nuevaMateria
		@GetMapping("/nuevaMateria")
		public String paginaNuevaMatricula(Model model, Matricula matricula) {
			model.addAttribute("matricula", matricula);
			return "vistaNuevaMateria";
		}
	// http://localhost:8080/uce/universidad/reporteEstudiante
	@GetMapping("/reporteEstudiante")
	public String busquedaEstudiantes(Model modelo) {
				
		List<Estudiante> listaEstudiantes = this.estudianteService.reporteEstudiantes();
				
		modelo.addAttribute("universidad", listaEstudiantes);
		return "vistaListaEstudiantes";
	}
	
	// http://localhost:8080/uce/universidad/reporteMatricula
		@GetMapping("/reporteMatricula")
		public String busquedaMatricula(Model modelo) {
					
			List<Matricula> listaMatriculas = this.matriculaService.reporteMatriculas();
					
			modelo.addAttribute("universidad", listaMatriculas);
			return "vistaMatriculas";
		}	

}
