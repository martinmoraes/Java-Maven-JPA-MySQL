package com.lineset.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "processo")
public class Processo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	private String numeroProcesso;
	private String destaque;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "processo_id")
	private List<Parte> parte;


	public List<Parte> getParte() {
		return parte;
	}

	public void setParte(List<Parte> parte) {
		this.parte = parte;
	}


	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public String getDestaque() {
		return destaque;
	}

	public void setDestaque(String destaque) {
		this.destaque = destaque;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destaque == null) ? 0 : destaque.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((numeroProcesso == null) ? 0 : numeroProcesso.hashCode());
		result = prime * result + ((parte == null) ? 0 : parte.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processo other = (Processo) obj;
		if (destaque == null) {
			if (other.destaque != null)
				return false;
		} else if (!destaque.equals(other.destaque))
			return false;
		if (id != other.id)
			return false;
		if (numeroProcesso == null) {
			if (other.numeroProcesso != null)
				return false;
		} else if (!numeroProcesso.equals(other.numeroProcesso))
			return false;
		if (parte == null) {
			if (other.parte != null)
				return false;
		} else if (!parte.equals(other.parte))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Processo [id=" + id + ", numeroProcesso=" + numeroProcesso + ", parte=" + parte + ", destaque="
				+ destaque + "]";
	}




}
