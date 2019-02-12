package com.dregronprogram.handler;

import com.dregronprogram.enemy_bullets.EnemyWeaponType;
import com.dregronprogram.explosion.ExplosionManager;
import com.dregronprogram.game_screen.BasicBlocks;
import com.dregronprogram.game_screen.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EnemyBulletHandler {

    private List<EnemyWeaponType> weaponTypes = new ArrayList<>();

    public void addBullet(EnemyWeaponType weaponType) {
        this.weaponTypes.add(weaponType);
    }

    public void draw(Graphics2D g) {
        for (EnemyWeaponType enemyWeaponType : weaponTypes) {
            enemyWeaponType.draw(g);
        }
    }

    public void update(double delta, BasicBlocks blocks, Player player) {
        for (int i = 0; i < weaponTypes.size(); i++) {
            weaponTypes.get(i).update(delta, blocks, player);
            if (weaponTypes.get(i).collision(player.getRect())) {
                ExplosionManager.createPixelExplosion(weaponTypes.get(i).getxPos(), weaponTypes.get(i).getyPos());
                weaponTypes.remove(i);
                player.hit();
            }
        }
    }

    public void reset() {
        weaponTypes.clear();
    }

}
