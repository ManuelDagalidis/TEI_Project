package com.coding_quest.gr_an.tei_project;

import java.io.Serializable;

public class Pedal implements Serializable {

    private String name, effect, imgurl, instrument, manufacturer, type;

    public Pedal ()
    {

    }

    public Pedal(String name, String effect, String imgurl, String instrument, String manufacturer) {
        this.name = name;
        this.effect = effect;
        this.imgurl = imgurl;
        this.instrument = instrument;
        this.manufacturer = manufacturer;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }

    public String getImgurl() {
        return imgurl;
    }

    public String getInstrument() {
        return instrument;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getType() {
        return type;
    }
}
