package com.ldts.breakout;

public interface Constants {
    int WIDTH = 57;
    int HEIGHT = 40;

    int INIT_PADDLE_X = (WIDTH / 2) - 3;
    int INIT_PADDLE_Y = HEIGHT - 5;

    int BORDER_RIGHT_X = 55;
    int BORDER_LEFT_X = 1;
    int BORDER_BOTTOM_Y = 38;
    int BORDER_TOP_Y = 1;

    int INIT_BALL_X = WIDTH / 2;
    int INIT_BALL_Y = HEIGHT -20;

    int RED_BRICK = 50;
    int DARK_ORANGE_BRICK = 20;
    int LIGHT_ORANGE_BRICK = 10;
    int YELLOW_BRICK = 5;
    int BLUE_BRICK = 1;

    int PADDLE_WIDTH = 7;
    int PADDLE_HEIGHT = 1;

    int MAX_POINTS = 7 * (RED_BRICK + DARK_ORANGE_BRICK + LIGHT_ORANGE_BRICK + YELLOW_BRICK + BLUE_BRICK);
}
