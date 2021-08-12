package ru.ubrr.testSpring.repository.impl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.ValidationException;
import org.springframework.stereotype.Repository;
import ru.ubrr.testSpring.domain.Hero;
import ru.ubrr.testSpring.repository.HeroRepository;
import ru.ubrr.testSpring.validator.HeroValidator;

@Repository
public class HeroRepositoryImpl implements HeroRepository<Hero> {

	private Map<Long, Hero> heroMap = new HashMap<>();
	private HeroValidator heroValidator = new HeroValidator();

	@Override
	public Hero save(Hero hero) {

		try {
			heroValidator.validate(hero);

			heroMap.put(hero.getId(), hero);

			return heroMap.get(hero.getId());
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Hero findById(final Long id) {
		return heroMap.get(id);
	}

	@Override
	public Iterable<Hero> findAll() {
		return heroMap.entrySet()
				.stream()
				.sorted(entryComparator)
				.map(Map.Entry::getValue)
				.collect(Collectors.toList());
	}

	final Comparator<Map.Entry<Long, Hero>> entryComparator =
			Comparator.comparing((Map.Entry<Long, Hero> ol) -> ol.getValue().getId());
}
