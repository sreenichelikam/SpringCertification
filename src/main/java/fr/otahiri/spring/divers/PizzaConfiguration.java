package fr.otahiri.spring.divers;

import fr.otahiri.spring.divers.web.data.jpa.IngredientRepository;
import fr.otahiri.spring.divers.web.data.jpa.UserRepository;
import fr.otahiri.spring.divers.web.dto.Ingredient;
import fr.otahiri.spring.divers.web.dto.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Profile("!prod")
public class PizzaConfiguration {
	@Bean
	  public CommandLineRunner dataLoader(IngredientRepository repo,
	        UserRepository userRepo, PasswordEncoder encoder) { // user repo for ease of testing with a built-in user
		 return args -> {
	        repo.save(new Ingredient("FLTO", "Flour Tortilla", "WRAP"));
	        repo.save(new Ingredient("COTO", "Corn Tortilla", "WRAP"));
	        repo.save(new Ingredient("GRBF", "Ground Beef", "PROTEIN"));
	        repo.save(new Ingredient("CARN", "Carnitas", "PROTEIN"));
	        repo.save(new Ingredient("TMTO", "Diced Tomatoes", "VEGGIES"));
	        repo.save(new Ingredient("LETC", "Lettuce", "VEGGIES"));
	        repo.save(new Ingredient("CHED", "Cheddar", "CHEESE"));
	        repo.save(new Ingredient("JACK", "Monterrey Jack", "CHEESE"));
	        repo.save(new Ingredient("SLSA", "Salsa", "SAUCE"));
	        repo.save(new Ingredient("SRCR", "Sour Cream", "SAUCE"));
	        
	        
	        userRepo.save(new User("user", encoder.encode("password"), 
	            "Craig Walls", "123 North Street", "Cross Roads", "TX", 
	            "76227", "123-123-1234"));
	    };
	  }
}
