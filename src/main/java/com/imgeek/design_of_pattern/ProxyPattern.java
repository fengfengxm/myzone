package com.imgeek.design_of_pattern;

/**
 * author:  xiemin
 * date:    2017-07-14
 * desc:    代理模式
 */

interface IGamePlayer {
    void killBoss();
}

class GamerPlayer implements IGamePlayer {
    private String _name;

    public GamerPlayer(String name) {
        this._name = name;
    }

    @Override
    public void killBoss() {
        System.out.println("kill Boss");
    }
}

class GamerPlayerProxy implements IGamePlayer {
    private GamerPlayer gamerPlayer;

    public GamerPlayerProxy(String _name) {
        this.gamerPlayer = new GamerPlayer(_name);
    }

    @Override
    public void killBoss() {
        preHandler();
        gamerPlayer.killBoss();
        afterHandler();
    }

    public void preHandler() {
        System.out.println("preHandler");
    }

    public void afterHandler() {
        System.out.println("afterHandler");
    }
}


public class ProxyPattern {
}
