package me.warp.entidades.objetos;

public class PlayerWarp {

    private String player;
    private boolean teletransportando;
    private long currentTime;
    private Warp warp;

    public PlayerWarp(String player) {
        this.player = player;
        this.teletransportando = false;
        this.currentTime = 0;
        this.warp = null;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public boolean isTeletransportando() {
        return teletransportando;
    }

    public void setTeletransportando(boolean teletransportando) {
        this.teletransportando = teletransportando;
    }

    public Warp getWarp() {
        return warp;
    }

    public void setWarp(Warp warp) {
        this.warp = warp;
    }
}
