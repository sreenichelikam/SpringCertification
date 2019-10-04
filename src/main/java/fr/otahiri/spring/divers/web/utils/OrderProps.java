package fr.otahiri.spring.divers.web.utils;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

//tag::notValidated[]
import org.springframework.boot.context.properties.
                                        ConfigurationProperties;
import org.springframework.stereotype.Component;
//end::notValidated[]
import org.springframework.validation.annotation.Validated;

//tag::notValidated[]
import lombok.Data;

@Component
@ConfigurationProperties(prefix="pizzas.orders")
@Data
@Validated
public class OrderProps {
  
  @Min(value=5, message="must be between 5 and 25")
  @Max(value=25, message="must be between 5 and 25")

  private int pageSize = 20;

}