package me.warp.entidades.objetos;

import org.bukkit.Location;

public class Warp {

    private String nome;
    private Location location;
    private int delay;

    public Warp(String nome, Location location, int delay) {
        this.nome = nome;
        this.location = location;
        this.delay = delay;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
