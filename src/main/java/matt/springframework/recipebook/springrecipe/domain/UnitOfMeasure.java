package matt.springframework.recipebook.springrecipe.domain;

import lombok.*;
import matt.springframework.recipebook.springrecipe.commands.UnitOfMeasureCommand;

import javax.persistence.*;

@Data
@Entity
public class UnitOfMeasure extends UnitOfMeasureCommand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;


    public String getUom() {
        return description;
    }

    public void setUom(String uom) {
        this.description = description;
    }

}
