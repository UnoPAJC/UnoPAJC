package unibs.pajc.uno.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Carta extends JPanel{

	private String value = "";
	
	private final int cardWidth = 100;
    private final int cardHeight = 150;
    private static final int margin = 5;
    
    private final Border defaultBorder = BorderFactory.createEtchedBorder(WHEN_FOCUSED, Color.white, Color.gray);
    private final Border focusedBorder = BorderFactory.createEtchedBorder(WHEN_FOCUSED, Color.black, Color.gray);
    

	private final Dimension dimension = new Dimension(cardWidth, cardHeight);
    
	public Carta(String value) {
		this.value = value;
		setPreferredSize(dimension);
        setBorder(defaultBorder);
	}
	
	@Override
    protected void paintComponent(Graphics g) {
		
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        var cardColor = Color.RED;

        fillBackground(g2, cardColor);
        drawWhiteOvalInCenter(g2);
        drawValueInCenter(g2, Color.CYAN);
        drawValueInCorner(g2);
    }
	
	private void fillBackground(Graphics2D g2, Color cardColor) {
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, cardWidth, cardHeight);

        g2.setColor(cardColor);
        g2.fillRect(margin, margin, cardWidth - 2 * margin, cardHeight - 2 * margin);
    }

    private void drawWhiteOvalInCenter(Graphics2D g2) {
        var transformer = g2.getTransform();
        g2.setColor(Color.white);
        g2.rotate(45, (double) cardWidth * 3 / 4, (double) cardHeight * 3 / 4);
        g2.fillOval(0, cardHeight / 4, cardWidth * 3 / 5, cardHeight);

        g2.setTransform(transformer);
    }

    private void drawValueInCenter(Graphics2D g2, Color cardColor) {
        var defaultFont = new Font("Helvatica", Font.BOLD, cardWidth / 2 + 5);
        var fontMetrics = this.getFontMetrics(defaultFont);
        int stringWidth = fontMetrics.stringWidth(value) / 2;
        int fontHeight = defaultFont.getSize() / 3;

        g2.setColor(cardColor);
        g2.setFont(defaultFont);
        g2.drawString(value, cardWidth / 2 - stringWidth, cardHeight / 2 + fontHeight);
    }

    private void drawValueInCorner(Graphics2D g2) {
        var defaultFont = new Font("Helvatica", Font.ITALIC, cardWidth / 5);

        g2.setColor(Color.white);
        g2.setFont(defaultFont);
        g2.drawString(value, margin, 5 * margin);
    }

    private void showHoverEffect(){
        setBorder(focusedBorder);

        Point p = getLocation();
        p.y -= 20;
        setLocation(p);
    }

    private void removeHoverEffect() {
        setBorder(defaultBorder);

        Point p = getLocation();
        p.y += 20;
        setLocation(p);
    }

	
}
