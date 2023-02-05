package academy.mindswap.gameobjects.fruit;

import academy.mindswap.field.Field;
import academy.mindswap.field.Position;

public class Fruit {
    private Position position;

    public Fruit() {
        this.position = Field.randomScreenAppearance();
    }

    public Position fruitPosition() {
        return this.position;
    }
}