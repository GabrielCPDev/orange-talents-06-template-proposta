package com.zupedu.gabriel.microservico.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PropostaInsertValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PropostaInsert {

	String message() default "Erro de validação";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
