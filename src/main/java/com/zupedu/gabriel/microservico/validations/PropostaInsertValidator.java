package com.zupedu.gabriel.microservico.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.zupedu.gabriel.microservico.dtos.PropostaDTO;
import com.zupedu.gabriel.microservico.repositories.PropostaRepository;
import com.zupedu.gabriel.microservico.resouces.exceptions.FieldMessage;
import com.zupedu.gabriel.microservico.resouces.exceptions.utils.DataIntegrityException;
import com.zupedu.gabriel.microservico.validations.utils.BR;

public class PropostaInsertValidator implements ConstraintValidator<PropostaInsert, PropostaDTO> {
	
	@Autowired
	private PropostaRepository propostaRepository;

	@Override
	public boolean isValid(PropostaDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList();
		
		var proposta = propostaRepository.findByCpfOuCnpj(objDto.getCpfOuCnpj());
		if(proposta.isPresent()) {
			throw new DataIntegrityException("Já existe uma proposta cadastrada para esse cliente!");
		}
		
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
