package fr.otahiri.spring.divers.web.data.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.otahiri.spring.divers.web.dto.Ingredient;

@CrossOrigin(origins="*")
public interface IngredientRepository 
         extends CrudRepository<Ingredient, String> {

}
