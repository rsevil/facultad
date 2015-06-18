package com.uade.miniTennis.juego;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.uade.miniTennis.model.Pelota;
import com.uade.miniTennis.model.Raqueta;

public class Juego extends JPanel {

	private Pelota ball = new Pelota(this);
	private Raqueta racquet = new Raqueta(this);

	public Juego() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);
	}

	private void move() {
		ball.move();
		racquet.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
	}

	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over",
				JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Juego game = new Juego();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}

	public Pelota getBall() {
		return ball;
	}

	public void setBall(Pelota ball) {
		this.ball = ball;
	}

	public Raqueta getRacquet() {
		return racquet;
	}

	public void setRacquet(Raqueta racquet) {
		this.racquet = racquet;
	}
	
	
}
