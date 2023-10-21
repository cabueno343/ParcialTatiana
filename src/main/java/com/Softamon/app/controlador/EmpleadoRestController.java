package com.Softamon.app.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Softamon.app.entidades.Empleado;
import com.Softamon.app.repositorio.EmpleadoRepositorio;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.Softamon.app.excepcion.NotFoundException;

@RestController
@RequestMapping(value = "/api/empleados")

public class EmpleadoRestController {

	@Autowired
	private EmpleadoRepositorio empleadoRepositorio;

	@GetMapping("/")
	public List<Empleado> getAllEmpleados() {
		return empleadoRepositorio.findAll();
	}
	 @GetMapping("/{id}")
	 public Empleado getEmpleadoById(@PathVariable String id) {
		    return empleadoRepositorio.findById(id).orElseThrow(() -> new NotFoundException("Empleado no encontrado"));
	 }

	@PostMapping("/")
	public Empleado saveEmpleado(@RequestBody Map<String, Object> body) {
		ObjectMapper mapper = new ObjectMapper();
		Empleado empleado = mapper.convertValue(body, Empleado.class);
		return empleadoRepositorio.save(empleado);
	}

	@PutMapping("/{id}")
	public Empleado updateEmpleado(@PathVariable String id, @RequestBody Map<String, Object> body) {
		ObjectMapper mapper = new ObjectMapper();
		Empleado empleado = mapper.convertValue(body, Empleado.class);
		empleado.setId(id);
		return empleadoRepositorio.save(empleado);
	}
	
	@DeleteMapping("/{id}")
    public Empleado deleteEquipo(@PathVariable String id) {
        Empleado empleado = empleadoRepositorio.findById(id).orElseThrow(() -> new NotFoundException("Empleado no encontrado"));
        empleadoRepositorio.deleteById(id);
        return empleado;
    }


}
