package com.ldts.breakout;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private final Arena arena;
    private boolean stopThread = false;

    public Game(){

        try{
            Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(Constants.WIDTH, Constants.HEIGHT)).createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();


        }catch(IOException e){
            e.printStackTrace();
        }

        arena = new Arena();

    }

    // Only for tests
    public Game(Arena arena){
        this.arena = arena;
    }


    public void draw() throws IOException{
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    private void processKey(KeyStroke key) {
        System.out.println(key);
        if (key.getKeyType() == KeyType.ArrowRight) {
            arena.movePaddle(arena.moveRight());
        }
        if (key.getKeyType() == KeyType.ArrowLeft) {
            arena.movePaddle(arena.moveLeft());
        }
    }

    public class BallThread extends Thread{
        @Override
        public void run(){

            while(!stopThread){
                try {
                    sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    draw();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                arena.hitsPaddle();
                arena.getBall().move();
            }
        }

    }

    public void run(){
        try {
            BallThread BallThread = new BallThread();
            BallThread.start();
            while(true) {
                draw();
                com.googlecode.lanterna.input.KeyStroke key = screen.readInput();
                processKey(key);
                if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q')){
                    stopThread = true;
                    screen.close();
                    BallThread.interrupt();
                    return;
                }

                if (key.getKeyType() == KeyType.EOF)
                    break;

            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
