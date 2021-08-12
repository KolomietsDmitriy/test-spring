package ru.ubrr.testSpring.repository;

public interface HeroRepository<T> {
	public T save(T domain);
	public T findById(Long id);
	public Iterable<T> findAll();
}
