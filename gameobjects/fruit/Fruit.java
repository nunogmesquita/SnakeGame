package academy.mindswap.gameobjects.fruit;

import academy.mindswap.field.Field;
import academy.mindswap.field.Position;

public class Fruit {
    int col;
    int row;
    public Fruit() {
        col = (int) (Math.random() * (Field.getWidth() - 2)) + 1;
        row = (int) (Math.random() * (Field.getHeight() - 2)) + 1;
    }

    public Position getPosition() {
        return new Position(col, row);
    }
}