package unibs.pajc.uno.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Image;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;

public class Game extends JFrame {

	JPanel gamePanel;
	
	private JPanel contentPane;
	private JPanel panelCarta;

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
		loadCard();
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
		
		gamePanel = new JPanel() { 		// set image as background
			
			public void paintComponent(Graphics g) {
				
				ImageIcon wallpaper = new ImageIcon("res/img/wallpaper.png");
				Image i = wallpaper.getImage();
				
				g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height, this);
				
			}
			
		};
		gamePanel.setBounds(0, 0, 580, 431);
		contentPane.add(gamePanel);
		gamePanel.setLayout(new BorderLayout(0, 0));
	    
	}
	
	public void loadCard() {
		panelCarta = new JPanel();
		gamePanel.add(panelCarta, BorderLayout.CENTER);
		panelCarta.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		for(int i = 0; i < 20; i++) {
			panelCarta.add(new Carta(String.valueOf(i)));
		}
		
		 
		
	}
}
