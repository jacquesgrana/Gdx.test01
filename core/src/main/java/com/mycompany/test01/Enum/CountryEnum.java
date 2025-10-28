package com.mycompany.test01.Enum;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.mycompany.test01.Util.GraphicUtil;

import java.util.Objects;

public enum CountryEnum {
    RED_COUNTRY ("Red Country", new Color(0.85f, 0.16f, 0.16f, 1.0f), GraphicUtil.counterBgRedCountry02Texture, GraphicUtil.counterBgRedCountry01Texture),
    BLUE_COUNTRY("Blue Country", new Color(0.12f, 0.47f, 0.88f, 1.0f), GraphicUtil.counterBgBlueCountry02Texture, GraphicUtil.counterBgBlueCountry01Texture),
    BLACK_COUNTRY ("Black Country", new Color(0.15f, 0.15f, 0.15f, 1.0f), GraphicUtil.counterBgBlackCountry02Texture, GraphicUtil.counterBgBlackCountry01Texture),
    GREEN_COUNTRY ("Green Country", new Color(0.27f, 0.64f, 0.25f, 1.0f), GraphicUtil.counterBgGreenCountry02Texture, GraphicUtil.counterBgGreenCountry01Texture),
    YELLOW_COUNTRY ("Yellow Country", new Color(0.98f, 0.85f, 0.27f, 1.0f), GraphicUtil.counterBgYellowCountry02Texture, GraphicUtil.counterBgYellowCountry01Texture),
    BROWN_COUNTRY ("Brown Country", new Color(0.65f, 0.45f, 0.22f, 1.0f), GraphicUtil.counterBgBrownCountry02Texture, GraphicUtil.counterBgBrownCountry01Texture),
    NO_COUNTRY ("No Country", new Color(0f, 0f, 0f, 0f), GraphicUtil.getEmptyTexture(), GraphicUtil.getEmptyTexture());

    private final String name;
    private final Color color;
    private final Texture countryTextureNormal;
    private final Texture countryTextureElite;

    CountryEnum(String name, Color color, Texture countryTextureNormal, Texture countryTextureElite) {
        this.name = name;
        this.color = color;
        this.countryTextureNormal = countryTextureNormal;
        this.countryTextureElite = countryTextureElite;
    }

    public String getName() {
        return this.name;
    }

    public Color getColor() {
        return color;
    }

    public Texture getCountryTextureNormal() {
        return countryTextureNormal;
    }

    public Texture getCountryTextureElite() {
        return countryTextureElite;
    }

    public boolean equals(CountryEnum toCompare) {
        return Objects.equals(this.name, toCompare.getName());
    }

    @Override
    public String toString() {
        return this.name;
    }
}
