package com.ldts.breakout;

import java.awt.*;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, FontFormatException {
        Game game = new Game(15);
        game.start();
    }
}