package com.mycompany.test01;

import com.badlogic.gdx.Game;
import com.mycompany.test01.Screen.WelcomeScreen;
import com.mycompany.test01.Service.EditMapService;

public class Main extends Game {
    //EditMapService editMapService;
    @Override
    public void create() {
        try {
            setScreen(new WelcomeScreen(this));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

