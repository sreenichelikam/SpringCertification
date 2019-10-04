package fr.otahiri.spring.divers.web.data.jdbc;

import fr.otahiri.spring.divers.web.dto.Ingredient;

public interface IngredientRepository {

  Iterable<Ingredient> findAll();
  
  Ingredient findById(String id);
  
  Ingredient save(Ingredient ingredient);
  
}
