package me.warp.entidades.objetos;

public class PlayerWarp {

    private String player;
    private long currentTime;

    public PlayerWarp(String player, long currentTime) {
        this.player = player;
        this.currentTime = currentTime;
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
}
