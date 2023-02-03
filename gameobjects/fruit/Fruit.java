package academy.mindswap.gameobjects.fruit;

import academy.mindswap.field.Field;
import academy.mindswap.field.Position;

import java.util.random.RandomGenerator;

public class Fruit {
    int col;
    int row;
    public Fruit() {
        this.col = (int) (Math.random() * (Field.getWidth() - 2));
        this.row = (int) (Math.random() * (Field.getHeight() - 2));
    }

    public Position getPosition() {
        return new Position(this.col, this.row);
    }
}
