package ru.ubrr.testSpring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ubrr.testSpring.domain.Hero;
import ru.ubrr.testSpring.repository.HeroRepository;

@RestController
@RequestMapping("api")
public class HeroController {

	private HeroRepository<Hero> repository;

	public HeroController(final HeroRepository<Hero> repository) {
		this.repository = repository;
	}

	@PostMapping("hero")
	public ResponseEntity<Hero> create(@RequestBody Hero hero) {
		return ResponseEntity.ok(repository.save(hero));
	}

	@PostMapping("hero/upd")
	public ResponseEntity<Hero> createUpdate(@RequestBody Hero hero) {
		hero.setId(100);
		return ResponseEntity.ok(repository.save(hero));
	}

	@GetMapping("hero/{id}")
	public ResponseEntity<Hero> getById(@PathVariable Long id) {

		return ResponseEntity.ok(repository.findById(id));
	}

	@GetMapping("hero")
	public ResponseEntity<Iterable<Hero>> find() {
		return ResponseEntity.ok(repository.findAll());
	}

}
