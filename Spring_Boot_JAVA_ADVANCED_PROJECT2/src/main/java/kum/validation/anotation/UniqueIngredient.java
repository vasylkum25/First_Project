package kum.validation.anotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


import kum.validation.validator.IngredientValidator;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { IngredientValidator.class })
public @interface UniqueIngredient {

String message() default  "Not unique";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default{};
}
