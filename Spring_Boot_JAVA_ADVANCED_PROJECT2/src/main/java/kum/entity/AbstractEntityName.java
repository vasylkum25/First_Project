package kum.entity;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import kum.validation.anotation.UniqueCuisine;
import kum.validation.anotation.UniqueIngredient;
import kum.validation.flag.CuisineFlag;
import kum.validation.flag.IngredientFlag;

@MappedSuperclass
public abstract class AbstractEntityName extends AbstractEntity{
	@UniqueIngredient(message="Такий інгредієнт вже існує в БД", groups=IngredientFlag.class)
	@UniqueCuisine(message="Така назва вже існує в БД", groups=CuisineFlag.class)
	@NotBlank(message="Це поле обов'язкове до заповнення", groups={CuisineFlag.class, IngredientFlag.class})
	@Pattern(regexp = "^[A-Z][A-Za-z0-9]+| *$", groups={CuisineFlag.class, IngredientFlag.class}, message="Це поле не може починатися з малої букви")
	private String name;

	public AbstractEntityName() {
	}

	public AbstractEntityName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
