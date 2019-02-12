package com.dregronprogram.explosion;

import java.awt.*;

public interface ExplosionType {

    public void draw(Graphics2D g);
    public void update(double delta);

    public boolean destory();
}

