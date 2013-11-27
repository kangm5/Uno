package cmsc519.team8.uno.gui;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import cmsc519.team8.uno.data.Deck;

import javax.swing.JLabel;

public class UnoGamePanel extends JPanel {

	/**
	 * UID
	 */
	private static final long serialVersionUID = -8758461344572468847L;

    private final DisplayableDeck displayableDeck = 
    		new DisplayableDeck(new Deck());

    private final DisplayableDiscardPile displayableDiscardPile = 
    		new DisplayableDiscardPile();
    
    private final DisplayableHand userHand = new DisplayableHand(true, 150, 380, false, false);
    private final DisplayableHand computer1 = new DisplayableHand(false, 0, 25, false, true);
    private final DisplayableHand computer2 = new DisplayableHand(false, 150, 0, true, false);
    private final DisplayableHand computer3 = new DisplayableHand(false, 650, 25, true, true);
 
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	displayableDeck.displayDeck(g, 260, 200);
        displayableDiscardPile.displayDiscardPile(g, 430, 200);
        computer1.paintComponent(g);
        computer2.paintComponent(g);
        computer3.paintComponent(g);
    }
     
	/**
	 * Create the panel. (image test right now)
	 */
	public UnoGamePanel() {
		this.setLayout(null);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setSize(30, 20);
		lblUser.setLocation(388, 360);
		lblUser.setVisible(true);
		add(lblUser);
		
		JLabel lblCpu1 = new JLabel("Computer1");
		lblCpu1.setSize(70, 20);
		lblCpu1.setLocation(150, 250);
		lblCpu1.setVisible(true);
		add(lblCpu1);
		
		JLabel lblCpu2 = new JLabel("Computer2");
		lblCpu2.setSize(70, 20);
		lblCpu2.setLocation(365, 150);
		lblCpu2.setVisible(true);
		add(lblCpu2);
		
		JLabel lblCpu3 = new JLabel("Computer3");
		lblCpu3.setSize(70, 20);
		lblCpu3.setLocation(570, 250);
		lblCpu3.setVisible(true);
		add(lblCpu3);
		
		userHand.setSize(500, 160);
		userHand.setLocation(150, 380);
		add(userHand);
		add(computer1);
		add(computer2);
		add(computer3);
		addMouseListener(new MouseController());
		
		//testing purposes
		for(int i = 0; i<7;i++){
			userHand.addCard(displayableDeck.drawCard());
			computer1.addCard(displayableDeck.drawCard());
			computer2.addCard(displayableDeck.drawCard());
			computer3.addCard(displayableDeck.drawCard());
		}
	}
	
	private class MouseController extends MouseAdapter
    {
        public void mouseClicked(MouseEvent me)
        {           
            int xHitOnPanel = me.getX();
            int yHitOnPanel = me.getY();

//            if (boundsForMouse.contains(xHitOnPanel, yHitOnPanel))
//                imageIndex = setImage(imageIndex);
        }
    }
}
