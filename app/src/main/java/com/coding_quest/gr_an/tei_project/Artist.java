package com.coding_quest.gr_an.tei_project;

import java.io.Serializable;
import java.util.ArrayList;

public class Artist implements Serializable {


    private String name, imgurl, band;
    private ArrayList<String> pedals;

    public Artist() {

    }

    public Artist(String band, String imgurl, String name) {
        this.name = name;
        this.imgurl = imgurl;
        this.band = band;
    }


    public String getName() {
        return name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public String getBand() {
        return band;
    }

    public ArrayList<String> getPedals() {
        return pedals;
    }
}
