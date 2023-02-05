package academy.mindswap;

import academy.mindswap.field.Field;
import academy.mindswap.gameobjects.fruit.Fruit;
import academy.mindswap.gameobjects.snake.Direction;
import academy.mindswap.gameobjects.snake.Snake;
import com.googlecode.lanterna.input.Key;

public class Game {

    private final Snake snake;
    private Fruit fruit;
    private final int delay;

    public Game(int cols, int rows, int delay) {
        Field.init(cols, rows);
        this.snake = new Snake();
        this.delay = delay;
    }

    public void start() throws InterruptedException {

        generateFruit();

        while (snake.isAlive()) {
            Thread.sleep(delay);
            Field.clearTail(snake);
            moveSnake();
            Field.score(snake.getEatedApples());
            checkCollisions();
            suicide();
            eatApple();
            Field.drawSnake(snake);
        }
    }

    private void suicide() {
        for (int i = 1; i < snake.getSnakeSize(); i++) {
            if (snake.getHead().equals(snake.getFullSnake().get(i))) {
                snake.die();
            }
        }
    }

    private void eatApple() {
        if (snake.getHead().equals(fruit.fruitPosition())) {
            snake.increaseSize(fruit.fruitPosition());
            generateFruit();
        }
    }

    private void generateFruit() {
        Field.drawFruits(this.fruit = new Fruit());
    }

    private void moveSnake() {

        Key k = Field.readInput();
        if (k != null) {
            switch (k.getKind()) {
                case ArrowUp:
                    snake.move(Direction.UP);
                    return;

                case ArrowDown:
                    snake.move(Direction.DOWN);
                    return;

                case ArrowLeft:
                    snake.move(Direction.LEFT);
                    return;

                case ArrowRight:
                    snake.move(Direction.RIGHT);
                    return;
            }
        }
        snake.move();
    }

    private void checkCollisions() {
        if (snake.getHead().getRow() == 0 || snake.getHead().getRow() == (Field.getHeight() - 1) ||
                snake.getHead().getCol() == 0 || snake.getHead().getCol() == (Field.getWidth() - 1)) {
            snake.die();
        }
    }
}