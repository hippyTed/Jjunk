package displaycards;

import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DisplayCards {
	
	public static void main(String[] args) {
		
		// Event dispatch thread
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new MainFrame();
				frame.setTitle("DisplayCards");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});			
	
	}
}
	
class MainFrame extends JFrame {
	static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 900;
	private static final int FRAME_HEIGHT = 300;
	private JPanel handPanel;
	private JPanel buttonPanel;
	
	public MainFrame() {
	
		PlayCards game = new PlayCards();
		
		game.dealCards(PlayCards.PLAYERS);
		
		for(int player = 0; player < PlayCards.PLAYERS; player++) {
			add(new HandComponent());
		}
		
		buttonPanel = new JPanel();
		buttonPanel.add(new QuitButton("Quit"));
		add(buttonPanel);
		
		pack();
	}

	public Dimension getPreferredSize() {
		return new Dimension(FRAME_WIDTH, FRAME_HEIGHT);
	}
}

class HandComponent extends JComponent {
	static final long serialVersionUID = 10L;
	private static final int HAND_WIDTH = 200;
	private static final int HAND_HEIGHT = 200;
	
	public void paintComponent(Graphics g) {		
		int x = 20;
		int y = 20;
		for (Hand h: PlayCards.hand) {
			g.drawString(h.getHand(), x, y);
			y += HAND_HEIGHT/4;
		}
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(HAND_WIDTH, HAND_HEIGHT);
	}
}

class QuitButton extends JButton {
	private static final long serialVersionUID = 100L;
	private static final int BUTTON_WIDTH = 100;
	private static final int BUTTON_HEIGHT = 30;

	QuitButton(String name) {
		JButton button = new JButton(name);
	
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
	}
	public Dimension getPreferredSize() {
		return new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT);
	}
}
