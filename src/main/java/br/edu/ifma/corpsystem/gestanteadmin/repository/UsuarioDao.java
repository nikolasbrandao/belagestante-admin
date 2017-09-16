package br.edu.ifma.corpsystem.gestanteadmin.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifma.corpsystem.gestanteadmin.model.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{
	Usuario findById(Long id);
}
