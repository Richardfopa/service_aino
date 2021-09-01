package com.orange.homeword;

public class Tache {
    private int tCheckboxe;
    private String tLabel;


    public Tache(int tCheckboxe, String tLabel) {
        this.tCheckboxe = tCheckboxe;
        this.tLabel = tLabel;
    }

    public int gettCheckboxe() {
        return tCheckboxe;
    }

    public void settCheckboxe(int tCheckboxe) {
        this.tCheckboxe = tCheckboxe;
    }

    public String gettLabel() {
        return tLabel;
    }

    public void settLabel(String tLabel) {
        this.tLabel = tLabel;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "tCheckboxe=" + tCheckboxe +
                ", tLabel='" + tLabel + '\'' +
                '}';
    }

}
