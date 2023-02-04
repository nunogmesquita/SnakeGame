package academy.mindswap.gameobjects.snake;

import academy.mindswap.field.Position;

import java.util.LinkedList;

public class Snake {

    private final static int SNAKE_INITIAL_SIZE = 3;
    LinkedList<Position> snake;
    private Direction direction;
    private boolean alive;
    private int applesEaten;

    public int getApplesEaten() {
        return applesEaten;
    }

    public void increaseSize(Position position) {
        applesEaten++;
        snake.addLast(position);
    }

    public Snake() {
        this.snake = new LinkedList<>();
        for (int i = 0; i < getSnakeSize(); i++) {
            snake.add(i, new Position(10 - i, 10));
        }
        this.direction = Direction.RIGHT;
        this.alive = true;
    }

    public void move(Direction direction) {
        if (invalidMovements(direction)) return;
        this.direction = direction;
        switch (direction) {
            case RIGHT -> {
                getFullSnake().removeLast();
                getFullSnake().addFirst(new Position(getFullSnake().get(0).getCol() + 1, getFullSnake().get(0).getRow()));
            }
            case LEFT -> {
                getFullSnake().removeLast();
                getFullSnake().addFirst(new Position(getFullSnake().get(0).getCol() - 1, getFullSnake().get(0).getRow()));
            }
            case UP -> {
                getFullSnake().removeLast();
                getFullSnake().addFirst(new Position(getFullSnake().get(0).getCol(), getFullSnake().get(0).getRow() - 1));
            }
            case DOWN -> {
                getFullSnake().removeLast();
                getFullSnake().addFirst(new Position(getFullSnake().get(0).getCol(), getFullSnake().get(0).getRow() + 1));
            }
        }
    }

    private boolean invalidMovements(Direction direction) {
        return this.direction == Direction.RIGHT && direction == Direction.LEFT ||
                this.direction == Direction.LEFT && direction == Direction.RIGHT ||
                this.direction == Direction.UP && direction == Direction.DOWN ||
                this.direction == Direction.DOWN && direction == Direction.UP;
    }

    public void move() {
        move(this.direction);
    }

    public void die() {
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public Position getHead() {
        return getFullSnake().getFirst();
    }

    public Position getTail() {
        return getFullSnake().getLast();
    }

    public LinkedList<Position> getFullSnake() {
        return snake;
    }

    public int getSnakeSize() {
        return applesEaten + SNAKE_INITIAL_SIZE;
    }
}