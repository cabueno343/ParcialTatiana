package com.Softamon.app.repositorio2;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.Softamon.app.entidades.Admin;

public interface AdminRepositorio extends MongoRepository<Admin, String> {

}
