package com.events_map.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "imagem_estabelecimento")
@SequenceGenerator(name = "seq_imagem_estabelecimento", sequenceName = "seq_imagem_estabelecimento", initialValue = 1, allocationSize = 1)
public class ImagemEstabelecimento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_imagem_estabelecimento")
	private Long id;
	
	@Column(nullable = false)
	private String imagemReal;
	
	private String imagemMiniatura;
	
	@ManyToOne(targetEntity = Estabelecimento.class)
	@JoinColumn(name = "estabelecimento_id", nullable = false,
	foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "estabelecimento_id_fk"))
	private Estabelecimento estabelecimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImagemReal() {
		return imagemReal;
	}

	public void setImagemReal(String imagemReal) {
		this.imagemReal = imagemReal;
	}

	public String getImagemMiniatura() {
		return imagemMiniatura;
	}

	public void setImagemMiniatura(String imagemMiniatura) {
		this.imagemMiniatura = imagemMiniatura;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImagemEstabelecimento other = (ImagemEstabelecimento) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
