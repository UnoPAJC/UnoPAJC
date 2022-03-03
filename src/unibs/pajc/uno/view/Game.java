package unibs.pajc.uno.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class Game extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Game() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 809, 470);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(8, 8, -5, -5));
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loadTitle();
		loadTable();	//parte sinistra, il tavolo di gioco
		loadChat();	//parte di destra, la chat
	}
	
	public void loadChat() {
		
		JTextArea chat = new JTextArea();
		chat.setBounds(579, 0, 214, 431);
		chat.setEditable(false);
		contentPane.add(chat);
	}
	
	public void loadTitle() {
		
		this.setTitle("Uno");	//set titolo
		
		Image bannerImage = new ImageIcon("res/img/main_banner.png").getImage().getScaledInstance(300, 300,
				java.awt.Image.SCALE_SMOOTH);

		this.setIconImage(bannerImage);		// set icona 
		
	}
	
	public void loadTable() {
		
		/*JPanel gamePanel = new JPanel() {
			
			public void paintComponent(Graphics g) {
				
				ImageIcon wallpaper = new ImageIcon("res/img/sfondo.png");
				Image i = wallpaper.getImage();
				
				g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height, this);
				
			}
			
		};*/
		JPanel gamePanel = new JPanel();
		gamePanel.setBackground(Color.MAGENTA);
		gamePanel.setBounds(0, 0, 580, 431);
		contentPane.add(gamePanel);
		gamePanel.setLayout(new BorderLayout(0, 0));
		
	    
	}
}
