package com.mycompany.test01.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.mycompany.test01.Config.FileConfig;

import static com.mycompany.test01.Config.FileConfig.*;

public class FileUtil {
    public static void checkOrInitDirs() {
        FileHandle dataDir = Gdx.files.local(GAME_DATA_FILE_PATH);
        if(!dataDir.exists()) dataDir.mkdirs();
        FileHandle armyDir = Gdx.files.local(ARMY_FILE_PATH);
        if(!armyDir.exists()) armyDir.mkdirs();
        FileHandle groupDir = Gdx.files.local(GROUP_FILE_PATH);
        if(!groupDir.exists()) groupDir.mkdirs();
        FileHandle mapDir = Gdx.files.local(FileConfig.MAP_FILE_PATH);
        if(!mapDir.exists()) mapDir.mkdirs();
        FileHandle scenarDir = Gdx.files.local(SCENAR_FILE_PATH);
        if(!scenarDir.exists()) scenarDir.mkdirs();
    }
}
