package com.mycompany.test01;

import com.badlogic.gdx.Game;
import com.mycompany.test01.Screen.WelcomeScreen;
import com.mycompany.test01.Service.MapService;

public class Main extends Game {
    MapService mapService;
    @Override
    public void create() {
        this.mapService = MapService.getInstance();
        mapService.firstInit();
        mapService.initRandomMapArray();
        setScreen(new WelcomeScreen(this));
    }
}

