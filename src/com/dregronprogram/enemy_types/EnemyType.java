package com.dregronprogram.enemy_types;

import com.dregronprogram.game_screen.BasicBlocks;
import com.dregronprogram.game_screen.Player;
import com.dregronprogram.handler.EnemyBulletHandler;
import com.dregronprogram.sprite.SpriteAnimation;

import java.awt.*;
import java.util.ArrayList;


public abstract class EnemyType {

    private EnemyBulletHandler bulletHandler;

    public EnemyType(EnemyBulletHandler bulletHandler) {
        this.bulletHandler = bulletHandler;
    }

    public abstract void draw(Graphics2D g);
    public abstract void update(double delta, Player player, BasicBlocks blocks);
    public abstract void changeDirection(double delta);

    public abstract boolean deathScene();
    public abstract boolean collide(int i, Player player, BasicBlocks blocks, ArrayList<EnemyType> enemys);
    public abstract boolean isOutOfBounds();

    public EnemyBulletHandler getBulletHandler() {
        return bulletHandler;
    }
    public abstract SpriteAnimation getSprite();
}

