package com.zupedu.gabriel.microservico.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.zupedu.gabriel.microservico.dtos.PropostaDTO;
import com.zupedu.gabriel.microservico.resouces.exceptions.FieldMessage;
import com.zupedu.gabriel.microservico.validations.utils.BR;

public class PropostaInsertValidator implements ConstraintValidator<PropostaInsert, PropostaDTO> {

	@Override
	public boolean isValid(PropostaDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList();
		
		if(objDto.getCpfOuCnpj().length() == 11) {
			objDto.getCpfOuCnpj().length();
			if(!BR.isValidCPF(objDto.getCpfOuCnpj())) {
				list.add(new FieldMessage("cpfOuCnpj", "Campo inválido"));
			}
			
		}else {
			if(!BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
				list.add(new FieldMessage("cpfOuCnpj", "Campo inválido"));
			}
		}
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();

		}
		return list.isEmpty();
	}

}
