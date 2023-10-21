package com.Softamon.app.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Softamon.app.entidades.Admin;
import com.Softamon.app.entidades.Empleado;
import com.Softamon.app.repositorio.EmpleadoRepositorio;
import com.Softamon.app.repositorio2.AdminRepositorio;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String goHome(Model model) {
		model.addAttribute("titulo","Softamon");
		return "inicio";
	}
	
	
//	@GetMapping("/Usu")
//	public String goIu(Model model) {
	//	model.addAttribute("titulo","Softamon");
	//	return "iniciousuarios";
//	}
	
	@Autowired
	private EmpleadoRepositorio IEmpleado;
	
	@Autowired
	private AdminRepositorio IAdmin;

	

	@GetMapping("/login")
	public String loginEmpleado(Model model, @ModelAttribute Empleado empleado) {
		model.addAttribute("user", empleado);
		return "login";
	}

	@PostMapping("/login")
	public String loginEmpleado(@ModelAttribute Empleado empleado) {
		for (Empleado item : IEmpleado.findAll())
			if (item.getNombre_em().equals(empleado.getNombre_em())) {
				System.out.println("Inicio de sesión exitoso para el usuario: " + item.getNombre_em());
				if (item.getPass_usu().equals(empleado.getPass_usu())) {
					System.out.println("Inicio de sesión exitoso para el usuario con contraseña: " + item.getPass_usu());
				//	if (item.getRole().equals(empleado.getRole())) {
					//	System.out.println("Inicio de sesión exitoso para el usuario con role: " + item.getRole());
						return "redirect:/empleados/viewEmple/"+ item.getId();
					}
					
					
				//}
			}
		System.out.println("Inicio de sesión fallido para el usuario: " + empleado.getNombre_em());
		return "redirect:/login";
	}

	
	@GetMapping("/loginAdmin")
	public String loginAdmin(Model model, @ModelAttribute Admin admin) {
		model.addAttribute("user", admin);
		return "loginAdmin";
	}

	@PostMapping("/loginAdmin")
	public String loginAdmin(@ModelAttribute Admin admin) {
		for (Admin item : IAdmin.findAll())
			if (item.getNombre().equals(admin.getNombre())) {
				System.out.println("Inicio de sesión exitoso para el admin: " + item.getNombre());
				if (item.getPass_usu().equals(admin.getPass_usu())) {
					System.out.println("Inicio de sesión exitoso para el usuario con contraseña: " + item.getPass_usu());
					
						return "redirect:/empleados/";
					}
					
			}
		System.out.println("Inicio de sesión fallido para el admin: " + admin.getNombre());
		return "redirect:/loginAdmin";
	}
}

