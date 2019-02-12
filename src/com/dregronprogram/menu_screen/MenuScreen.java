package com.dregronprogram.menu_screen;

import com.dregronprogram.display.Display;
import com.dregronprogram.state.StateMachine;
import com.dregronprogram.state.SuperStateMachine;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuScreen extends SuperStateMachine implements KeyListener {

    private Font tittleFont = new Font("French Script MT", Font.PLAIN, 84);
    private Font startFont = new Font("Arial", Font.PLAIN, 32);
    private Font playerFont = new Font("Time new roman", Font.PLAIN, 18);
    private String tittle1 = "Space";
    private String tittle2 = "Invaders";
    private String start = "Pleas select and Press Enter";
    private String player1 = "1 player";
    private String player2 = "2 players";
    private int strzalka = 0;

    public MenuScreen(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setFont(tittleFont);
        int tittleWidth = g.getFontMetrics().stringWidth(tittle1);
        g.setColor(Color.yellow);
        g.drawString(tittle1, ((Display.WIDTH/2)-(tittleWidth/2))-2, (Display.HEIGHT/2)-123);
        g.setColor(Color.green);
        g.drawString(tittle1, (Display.WIDTH/2)-(tittleWidth/2), (Display.HEIGHT/2)-125);

        g.setFont(tittleFont);
        int tittleWidth1 = g.getFontMetrics().stringWidth(tittle2);
        g.setColor(Color.yellow);
        g.drawString(tittle2, ((Display.WIDTH/2)-(tittleWidth/2))-42, (Display.HEIGHT/2)-73);
        g.setColor(Color.green);
        g.drawString(tittle2, (Display.WIDTH/2)-(tittleWidth/2)-40, (Display.HEIGHT/2)-75);

        g.setFont(startFont);
        g.setColor(Color.white);
        int startWidth = g.getFontMetrics().stringWidth(start);
        g.drawString(start, (Display.WIDTH/2)-(startWidth/2), (Display.HEIGHT/2)+75);
        g.setFont(playerFont);
        g.drawString(player1, (Display.WIDTH/2)-(startWidth/2)+30, (Display.HEIGHT/2)+95);
        g.drawString(" -> ", (Display.WIDTH/2)-(startWidth/2), (Display.HEIGHT/2)+95+strzalka);
        g.drawString(player2, (Display.WIDTH/2)-(startWidth/2)+30, (Display.HEIGHT/2)+115);

    }

    @Override
    public void init(Canvas canvas) {
        canvas.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int i=1;
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            if(strzalka>10){
                strzalka-=20;
                i--;
            }
            else{
                strzalka+=20;
                i++;
            }


        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            if(strzalka<10){
                strzalka+=20;
                i++;
            }
            else{
                strzalka-=20;
                i--;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if((i % 2) == 0){
                getStateMachine().setState((byte) 2);
            }
            else {
                getStateMachine().setState((byte) 1);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
