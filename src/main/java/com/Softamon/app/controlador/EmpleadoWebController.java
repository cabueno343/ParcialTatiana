package com.Softamon.app.controlador;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Softamon.app.entidades.Empleado;
import com.Softamon.app.repositorio.EmpleadoRepositorio;

import com.Softamon.app.excepcion.NotFoundException;

@Controller
@RequestMapping("/empleados")

public class EmpleadoWebController {

	@Autowired
	private EmpleadoRepositorio empleadoRepositorio;

	@GetMapping("/")
	public String empleadosListTemplate(Model model) {
		model.addAttribute("empleados", empleadoRepositorio.findAll());
		return "empleados-list";
	}

	@GetMapping("/new")
	public String empleadosNewTemplate(Model model) {
		model.addAttribute("empleado", new Empleado());
		return "usuarios-form";
	}

	@GetMapping("/edit/{id}")
	public String empleadoEditTemplate(@PathVariable("id") String id, Model model) {
		model.addAttribute("empleado",
				empleadoRepositorio.findById(id).orElseThrow(() -> new NotFoundException("Empleado no encontrado")));
		return "empleados-form";
	}
	
	@GetMapping("/viewEmple/{id}")
	public String empleadoViewEmpleWeb(@PathVariable("id") String id, Model model) {
		model.addAttribute("empleado",
				empleadoRepositorio.findById(id).orElseThrow(() -> new NotFoundException("Empleado no encontrado")));
		return "iniciousuarios";
	}

	@PostMapping("/save")
	public String empleadosSaveProcess(@ModelAttribute("empleado") Empleado empleado) {
		if (empleado.getId().isEmpty()) {
			empleado.setId(null);
		}
		
		empleadoRepositorio.save(empleado);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String equipoDeleteProcess(@PathVariable("id") String id) {
		empleadoRepositorio.deleteById(id);
		return "redirect:/empleados/";
	}
	
	@GetMapping("/editEm/{id}")
	public String empleadoEdit(@PathVariable("id") String id, Model model) {
		model.addAttribute("empleado",
				empleadoRepositorio.findById(id).orElseThrow(() -> new NotFoundException("Empleado no encontrado")));
		return "EditarInfoEmpleado";
	}
	
	@PostMapping("/saveEm")
	public String empleadosSave(@ModelAttribute("empleado") Empleado empleado, @RequestParam("file") MultipartFile imagen) {
		if (empleado.getId().isEmpty()) {
			empleado.setId(null);
		}
		if(imagen.isEmpty()) {
			Path directorioImagenes =Paths.get("/src/main/resources/static/upload");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta =Paths.get(rutaAbsoluta + "/"+ imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				
				empleado.setImagen(imagen.getOriginalFilename());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		empleadoRepositorio.save(empleado);
		return "/iniciousuarios";
	}
	
	@PostMapping("/saveForm")
	public String empleadosSavea(@ModelAttribute("empleado") Empleado empleado) {
		if (empleado.getId().isEmpty()) {
			empleado.setId(null);
		}
		empleadoRepositorio.save(empleado);
		return "redirect:/empleados/";
	}
	
	@GetMapping("/newEm")
	public String empleadosNew(Model model) {
		model.addAttribute("empleado", new Empleado());
		return "empleados-form";
	}
	
	@GetMapping("/ViewEMP/{id}")
	public String Ver(@PathVariable("id") String id, Model model) {
		model.addAttribute("empleado",
				empleadoRepositorio.findById(id).orElseThrow(() -> new NotFoundException("Empleado no encontrado")));
		return "certificado";
	}

}
