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
        snake = new Snake();
        this.delay = delay;
    }

    public void start() throws InterruptedException {

        generateFruit();

        while (snake.isAlive()) {
            Thread.sleep(delay);
            Field.drawSnake(snake);
            Field.clearTail(snake);
            moveSnake();
            checkCollisions();
            suicide();
            eatApple();
            Field.score(snake.getApplesEaten());
        }
    }

    private void generateFruit() {
        Field.drawFruit(this.fruit = new Fruit());
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

    private void eatApple() {
        if (snake.getHead().equals(fruit.fruitPosition())) {
            snake.increaseSize(fruit.fruitPosition());
            generateFruit();
        }
    }

    private void checkCollisions() {
        switch (snake.getHead().getRow()) {
            case 0:
                snake.getHead().setRow(Field.getHeight());
                break;
            case 25:
                snake.getHead().setRow(0);
                break;
        }
        switch (snake.getHead().getCol()) {
            case 0:
                snake.getHead().setCol(Field.getWidth());
                break;
            case 100:
                snake.getHead().setCol(0);
                break;
        }
    }

    private void suicide() {
        for (int i = 1; i < snake.getSnakeSize(); i++) {
            if (snake.getFullSnake().get(i).equals(snake.getHead())) {
                snake.die();
            }
        }
    }
}