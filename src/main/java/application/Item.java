package application;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Item {
    private String name;
    private Double cost;

    private Item(){

    }

    @Override
    public String toString() {
        return getName() + "  |  " + getCost();
    }
}
