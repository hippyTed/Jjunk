package displaycards;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DisplayCards {
	
	public static void main(String[] args) {
		
		// Event dispatch thread
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				createMainWindow();
			}
		});			
	
	}
	
	private static void createMainWindow() {
		JFrame frame = new JFrame("DisplayCards");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		frame.add(new MainPanel());
		
		frame.pack();
		frame.setVisible(true);		
	}
}
	
class MainPanel extends JPanel {
	static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 850;
	private static final int FRAME_HEIGHT = 200;
	
	public MainPanel() {

		PlayCards game = new PlayCards();		
		game.dealCards(PlayCards.PLAYERS);
		
		for(int player = 1; player <= PlayCards.PLAYERS; player++)
			add(new HandComponent(player));

		add(new QuitButton("Quit"));
	}

	public Dimension getPreferredSize() {
		return new Dimension(FRAME_WIDTH, FRAME_HEIGHT);
	}
}

class HandComponent extends JTextArea {
	static final long serialVersionUID = 10L;
	private static final int HAND_WIDTH = 200;
	private static final int HAND_HEIGHT = 130;
	
	public HandComponent(int playerNumber) {
		append("Player " + playerNumber);
		append(PlayCards.hand[playerNumber - 1].getHand());
		setEditable(false);
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
		super(name);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT);
	}
}
