package academy.mindswap.gameobjects.snake;

import academy.mindswap.field.Field;
import academy.mindswap.field.Position;

import java.util.LinkedList;

public class Snake {

    private final static int SNAKE_INITIAL_SIZE = 3;
    LinkedList<Position> snake;
    private Direction direction;
    private boolean alive;
    private int applesEaten;

    public void increaseSize() {
        applesEaten++;
    }

    public Snake() {
        this.snake = new LinkedList<>();
        for (int i = 0; i < getSnakeSize(); i++) {
            snake.add(i, new Position(10 - i, 10));
        }
        this.alive = true;
    }

    public void move(Direction direction) {
        switch (direction) {
            case RIGHT:
                getFullSnake().removeLast();
                getFullSnake().addFirst(new Position(getFullSnake().get(0).getCol() + 1, getFullSnake().get(0).getRow()));

                break;
            case LEFT:
                getFullSnake().removeLast();
                getFullSnake().addFirst(new Position(getFullSnake().get(0).getCol() - 1, getFullSnake().get(0).getRow()));
                break;
            case UP:
                getFullSnake().removeLast();
                getFullSnake().addFirst(new Position(getFullSnake().get(0).getCol(), getFullSnake().get(0).getRow() - 1));
                break;
            case DOWN:
                getFullSnake().removeLast();
                getFullSnake().addFirst(new Position(getFullSnake().get(0).getCol(), getFullSnake().get(0).getRow() + 1));

                break;
        }
    }

    public void move() {
        if(direction != null) {
            move(direction);
        } else move(Direction.RIGHT);
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

