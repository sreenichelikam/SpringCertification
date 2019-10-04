package fr.otahiri.spring.divers.web.data.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.otahiri.spring.divers.web.dto.Pizza;

public interface PizzaRepository extends PagingAndSortingRepository<Pizza, Long> {

}
