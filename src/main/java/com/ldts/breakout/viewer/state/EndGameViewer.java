package com.ldts.breakout.viewer.state;

import com.ldts.breakout.Constants;
import com.ldts.breakout.gui.GUI;
import com.ldts.breakout.model.Button;
import com.ldts.breakout.model.Position;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class EndGameViewer extends StateViewer {
    private final boolean won;

    public EndGameViewer(GUI gui, List<Button> buttons, boolean won) {
        super(gui, buttons);
        this.won = won;
    }

    @Override
    public void draw(){
        try {
            gui.clear();
            gui.createTextGraphics();
            if (!won) {
                gui.drawTitle(new Position(Constants.WIDTH / 2 - 5, Constants.HEIGHT / 2 - 3), "YOU LOST!", "#FF0000");
                gui.drawTitle(new Position(Constants.WIDTH / 2 - 8, Constants.HEIGHT / 2), "PRESS Q TO EXIT", "#FF0000");
            } else {
                gui.drawTitle(new Position(Constants.WIDTH / 2 - 3, Constants.HEIGHT / 2 - 3), "YOU WON!", "#0066FF");
                gui.drawTitle(new Position(Constants.WIDTH / 2 - 7, Constants.HEIGHT / 2), "PRESS Q TO EXIT", "#0066FF");
            }
            gui.refresh();
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (Exception e) {
            System.out.println("ERROR");
        }

    }
}
