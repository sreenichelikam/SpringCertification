package fr.otahiri.spring.divers.web.data.jpa;

import org.springframework.data.repository.CrudRepository;

import fr.otahiri.spring.divers.web.dto.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

}
