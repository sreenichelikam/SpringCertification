package fr.otahiri.spring.divers;

import fr.otahiri.spring.divers.web.dto.Ingredient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.otahiri.spring.divers.web.dto.Ingredient.Type;
import fr.otahiri.spring.divers.web.dto.User;
import fr.otahiri.spring.divers.web.data.jpa.IngredientRepository;
import fr.otahiri.spring.divers.web.data.jpa.UserRepository;

@Configuration
@Profile("!prod")
public class PizzaConfiguration {
	@Bean
	  public CommandLineRunner dataLoader(IngredientRepository repo,
	        UserRepository userRepo, PasswordEncoder encoder) { // user repo for ease of testing with a built-in user
		 return args -> {
	        repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
	        repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
	        repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
	        repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
	        repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
	        repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
	        repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
	        repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
	        repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
	        repo.save(new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));
	        
	        
	        userRepo.save(new User("user", encoder.encode("password"), 
	            "Craig Walls", "123 North Street", "Cross Roads", "TX", 
	            "76227", "123-123-1234"));
	    };
	  }
}
