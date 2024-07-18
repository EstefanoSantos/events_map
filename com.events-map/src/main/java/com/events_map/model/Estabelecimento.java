package com.events_map.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "estabelecimento")
@SequenceGenerator(name = "seq_estabelecimento", sequenceName = "seq_estabelecimento", initialValue = 1, allocationSize = 1)
public class Estabelecimento extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private String cnpj;
	
	@OneToMany(mappedBy = "estabelecimento", orphanRemoval = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<User> colaboradores = new ArrayList<User>();
	
	@OneToMany(mappedBy = "estabelecimento", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ImagemEstabelecimento> imagens = new ArrayList<ImagemEstabelecimento>();
	
	@OneToOne(mappedBy = "estabelecimento", orphanRemoval = true ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Endereco endereco;
	
	@OneToMany(mappedBy = "estabelecimento", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<HorarioFuncionamento> horarioFuncionamento = new ArrayList<HorarioFuncionamento>();

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<User> getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(List<User> colaboradores) {
		this.colaboradores = colaboradores;
	}

	public List<ImagemEstabelecimento> getImagens() {
		return imagens;
	}

	public void setImagens(List<ImagemEstabelecimento> imagens) {
		this.imagens = imagens;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
