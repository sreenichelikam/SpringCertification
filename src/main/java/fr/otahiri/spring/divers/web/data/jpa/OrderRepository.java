package fr.otahiri.spring.divers.web.data.jpa;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import fr.otahiri.spring.divers.web.dto.Order;
import fr.otahiri.spring.divers.web.dto.User;

public interface OrderRepository extends CrudRepository<Order, Long> {

	List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);

}
