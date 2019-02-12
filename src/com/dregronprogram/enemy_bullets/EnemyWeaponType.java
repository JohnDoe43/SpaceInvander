package com.dregronprogram.enemy_bullets;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import com.dregronprogram.display.Display;
import com.dregronprogram.enemy_bullets.EnemyBasicBullet;
import com.dregronprogram.game_screen.BasicBlocks;
import com.dregronprogram.game_screen.GameScreen;
import com.dregronprogram.game_screen.Player;
import com.dregronprogram.handler.EnemyBulletHandler;
import com.dregronprogram.sound.Sound;
import com.dregronprogram.sprite.SpriteAnimation;
import com.dregronprogram.timer.Timer;

public abstract class EnemyWeaponType {

    public abstract void draw(Graphics2D g);
    public abstract void update(double delta, BasicBlocks blocks, Player player);

    public abstract boolean collision(Rectangle rect);
    public abstract boolean destory();

    protected abstract void wallCollide(BasicBlocks blocks);
    protected abstract void isOutofBounds();

    public abstract int getxPos();
    public abstract int getyPos();
}
