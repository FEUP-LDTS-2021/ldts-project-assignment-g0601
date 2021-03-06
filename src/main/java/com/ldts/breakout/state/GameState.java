package com.ldts.breakout.state;

import com.ldts.breakout.Game;
import com.ldts.breakout.model.Button;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

public abstract class GameState {
    protected Game game;
    private List<Button> buttons;

    public GameState(Game game, List<Button> buttons) {
        this.game = game;
        this.buttons = buttons;
    }

    public void changeState(GameState gameState){this.game.setGameState(gameState);}

    public Game getGame(){return game;}
    public void setGame(Game game){this.game = game;}

    public List<Button> getButtons(){return buttons;}
    public void setButtons(List<Button> buttons) {this.buttons = buttons;}

    public abstract void start();

    public abstract void step(Game game) throws IOException;
}
