package unibs.pajc.uno.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import unibs.pajc.uno.view.util.CustomFontManager;

/**
 * Class to launch main menu.
 * 
 * @author Stefano Valloncini
 */
public class MainMenu extends JFrame
{
	private static final String TITLE = "UnoPACJ, an opensource uno game made in Java";

	private JPanel bannerPanel;
	private JLabel bannerLabel;

	private JLabel bannerLabelSubtitle; // CURRENTLY NOT USED

	private JPanel buttonsPanel;
	private JPanel mainContainer;

	private JPanel newGameButtonPanel;
	private JButton newGameButton;

	private JPanel loadGameButtonPanel;
	private JButton loadGameButton;

	private JPanel AIGamePanel;
	private JButton AIGameButton;

	public MainMenu()
	{
		super("Uno");

		CustomFontManager.initializeFont();
		loadInterface();
	}

	private void loadInterface()
	{
		initializeBannerPanel();
		initializeButtonsPanel();

		this.setLayout(new BorderLayout());
		this.add(bannerPanel, BorderLayout.NORTH);
		// this.add(buttonsPanel, BorderLayout.SOUTH);
		this.add(mainContainer, BorderLayout.SOUTH);

		this.pack();
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Image bannerImage = new ImageIcon("res/img/main_icon.png").getImage().getScaledInstance(500, 500,
				java.awt.Image.SCALE_SMOOTH);

		this.setIconImage(bannerImage);
	}

	public void initializeBannerPanel()
	{
		Image bannerImage = new ImageIcon("res/img/main_banner.png").getImage().getScaledInstance(350, 250,
				java.awt.Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(bannerImage);

		bannerLabel = new JLabel(""); // Add text to main banner
		bannerLabelSubtitle = new JLabel("A chess game in Java");

		bannerLabel.setFont(CustomFontManager.robotoFont);
		bannerLabel.setForeground(new Color(20, 20, 20));
		bannerLabel.setIcon(image);
		bannerLabel.setIconTextGap(25);

		bannerPanel = new JPanel();
		bannerPanel.setPreferredSize(new Dimension(600, 250));
		bannerPanel.add(bannerLabel);
		// bannerPanel.add(bannerLabelSubtitle);
		bannerPanel.setBackground(new Color(237, 28, 36));
	}

	public void initializeButtonsPanel()
	{
		newGameButton = new JButton("New Online Game");
		loadGameButton = new JButton("New Offline Game");
		AIGameButton = new JButton("AI Simulated");

		newGameButtonPanel = new JPanel(new GridLayout());
		newGameButtonPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 40, 25));
		newGameButtonPanel.add(newGameButton);

		loadGameButtonPanel = new JPanel(new GridLayout(1, 1));
		loadGameButtonPanel.setBorder(BorderFactory.createEmptyBorder(30, 25, 40, 25));
		loadGameButtonPanel.add(loadGameButton);

		AIGamePanel = new JPanel(new GridLayout());
		AIGamePanel.setBorder(BorderFactory.createEmptyBorder(30, 25, 40, 40));
		AIGamePanel.add(AIGameButton);

		buttonsPanel = new JPanel(new GridLayout(1, 3));
		buttonsPanel.setPreferredSize(new Dimension(600, 150));
		buttonsPanel.add(newGameButtonPanel);
		buttonsPanel.add(loadGameButtonPanel);
		buttonsPanel.add(AIGamePanel);

		JLabel descriptorLabel = new JLabel("UnoPAJC, an opensource uno card game written in Java",
				SwingConstants.CENTER);
		JLabel authorLabel = new JLabel("Made by UnoTeam", SwingConstants.CENTER);
		authorLabel.setFont(new Font("Arial", Font.PLAIN, 10));
		// descriptorLabel.setFont(Font.PLAIN, 10, "TImes"); SETTING A CUSTOM FONT

		JPanel descriptorPanelNorth = new JPanel();
		descriptorPanelNorth.setBorder(BorderFactory.createEmptyBorder(10, 25, 1, 40));
		JPanel descriptionPaneSouth = new JPanel();
		descriptionPaneSouth.setBorder(BorderFactory.createEmptyBorder(1, 25, 1, 40));

		descriptorPanelNorth.add(descriptorLabel);
		descriptorLabel.setFont(CustomFontManager.robotoFont2);
		descriptionPaneSouth.add(authorLabel);

		mainContainer = new JPanel(new BorderLayout());
		mainContainer.add(descriptorPanelNorth, BorderLayout.NORTH);
		mainContainer.add(buttonsPanel, BorderLayout.CENTER);
		mainContainer.add(descriptionPaneSouth, BorderLayout.SOUTH);

		newGameButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Start a new game!");
			}
		});

		// ADDING MOUSE LISTENER TO CHANGE TEXT WHEN BUTTON IS HOVERED
		newGameButton.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				descriptorLabel.setText("Play SP against AI, ML local or ML on LAN");
			}

			public void mouseExited(MouseEvent e)
			{
				descriptorLabel.setText(TITLE);
			}
		});

		loadGameButton.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				descriptorLabel.setText("Load a pre-existing game.");
			}

			public void mouseExited(MouseEvent e)
			{
				descriptorLabel.setText(TITLE);
			}
		});

		AIGameButton.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				descriptorLabel.setText("Sit back and play against AI.");
			}

			public void mouseExited(MouseEvent e)
			{
				descriptorLabel.setText(TITLE);
			}
		});
	}
}
