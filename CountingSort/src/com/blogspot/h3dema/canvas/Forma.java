package com.blogspot.h3dema.canvas;

/*
 * interface para desenho de formas no canvas
 */

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author h3dema
 */
public interface Forma {

    Color corBorda = Color.BLACK;
    Color corFundo = Color.WHITE;

    int DX = 20;
    int DY = 20;
    
    public void draw(Graphics g);
}
