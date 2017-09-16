package br.edu.ifma.corpsystem.gestanteadmin.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifma.corpsystem.gestanteadmin.model.Dica;

public interface DicaDao extends CrudRepository<Dica, Long>{
	List<Dica> findByTitulo(String titulo);
	Dica findById(Long id);
}
