package com.Softamon.app.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Softamon.app.entidades.Empleado;

public interface EmpleadoRepositorio extends MongoRepository<Empleado, String> {

}
