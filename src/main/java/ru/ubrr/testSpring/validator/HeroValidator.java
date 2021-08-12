package ru.ubrr.testSpring.validator;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import ru.ubrr.testSpring.domain.Hero;

public class HeroValidator {

	public void validate(Hero hero) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();

		Set<ConstraintViolation<Hero>> violations = validator.validate(hero);

		if (!violations.isEmpty()) {

			System.out.println(violations.toString());
			throw new ValidationException("Validation failed");
		}
	}
}
