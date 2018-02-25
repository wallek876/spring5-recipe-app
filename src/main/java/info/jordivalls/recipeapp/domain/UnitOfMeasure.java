package info.jordivalls.recipeapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnitOfMeasure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String description;

	
	public long gedId() {
		return id;
	}

	public void setId(long idLong) {
		this.id = idLong;
	}

	public String getUom() {
		return description;
	}

	public void setUom(String uom) {
		this.description = uom;
	}
	
	
	
	
}
