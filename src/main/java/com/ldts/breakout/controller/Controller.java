package com.ldts.breakout.controller;

import com.ldts.breakout.Game;

import java.io.IOException;

public abstract class Controller<T> {

    private T model;

    public Controller(T model) {this.model = model;}

    public T getModel() {return model;}

    public void setModel(T model) {this.model = model;}

    public abstract void step(Game game) throws IOException;

}
