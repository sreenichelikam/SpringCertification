package fr.otahiri.spring.divers.web.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import fr.otahiri.spring.divers.web.dto.Ingredient;
import fr.otahiri.spring.divers.web.dto.Order;
import fr.otahiri.spring.divers.web.dto.Pizza;
import fr.otahiri.spring.divers.web.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.otahiri.spring.divers.web.dto.Ingredient.Type;
import fr.otahiri.spring.divers.web.data.jpa.IngredientRepository;
import fr.otahiri.spring.divers.web.data.jpa.PizzaRepository;
import fr.otahiri.spring.divers.web.data.jpa.UserRepository;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignPizzaController {
  
  private final IngredientRepository ingredientRepo;
  
  private PizzaRepository pizzasRepo;

  private UserRepository userRepo;

  @Autowired
  public DesignPizzaController(
        IngredientRepository ingredientRepo, 
        PizzaRepository pizzasRepo,
        UserRepository userRepo) {
    this.ingredientRepo = ingredientRepo;
    this.pizzasRepo = pizzasRepo;
    this.userRepo = userRepo;
  }

  @ModelAttribute(name = "order")
  public Order order() {
    return new Order();
  }
  
  @ModelAttribute(name = "design")
  public Pizza design() {
    return new Pizza();
  }
  
  @GetMapping
  public String showDesignForm(Model model, Principal principal) {
    List<Ingredient> ingredients = new ArrayList<>();
    ingredientRepo.findAll().forEach(i -> ingredients.add(i));
    
    Type[] types = Ingredient.Type.values();
    for (Type type : types) {
      model.addAttribute(type.toString().toLowerCase(), 
          filterByType(ingredients, type));      
    }
    
    String username = principal.getName();
    User user = userRepo.findByUsername(username);
    model.addAttribute("user", user);

    return "design";
  }

  @PostMapping
  public String processDesign(
      @Valid Pizza pizza, Errors errors, 
      @ModelAttribute Order order) {
    
    if (errors.hasErrors()) {
      return "design";
    }

    Pizza saved = pizzasRepo.save(pizza);
    order.addDesign(saved);

    return "redirect:/orders/current";
  }

  private List<Ingredient> filterByType(
      List<Ingredient> ingredients, Type type) {
    return ingredients
              .stream()
              .filter(x -> x.getType().equals(type))
              .collect(Collectors.toList());
  }
  
}
