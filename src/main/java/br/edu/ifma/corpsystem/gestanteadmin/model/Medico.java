package br.edu.ifma.corpsystem.gestanteadmin.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="medico")
public class Medico {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String graduação;
	
	private String especialização;
	
	private String cadastroCRM;
	
	@Column(columnDefinition="text")
	private String sobre;
	
	@OneToMany(mappedBy="medico")
	private List<Dica> dicas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGraduação() {
		return graduação;
	}

	public void setGraduação(String graduação) {
		this.graduação = graduação;
	}

	public String getEspecialização() {
		return especialização;
	}

	public void setEspecialização(String especialização) {
		this.especialização = especialização;
	}

	public String getCadastroCRM() {
		return cadastroCRM;
	}

	public void setCadastroCRM(String cadastroCRM) {
		this.cadastroCRM = cadastroCRM;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public List<Dica> getDicas() {
		return dicas;
	}

	public void setDicas(List<Dica> dicas) {
		this.dicas = dicas;
	}
	
	

}
