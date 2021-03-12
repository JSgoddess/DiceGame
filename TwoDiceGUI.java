// this app needs the class die.java in the root directory
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoDiceGUI extends JFrame implements ActionListener
{

	Font mainFont = new Font("Impact", Font.PLAIN, 32);
	JLabel title = new JLabel("Two Dice Game");
	JLabel playerLabel = new JLabel("The player's roll is: ");
	JLabel comLabel = new JLabel("The computer's roll is: ");
	JLabel result = new JLabel("");
	JTextField pRoll = new JTextField(4);
	JTextField cRoll = new JTextField(4);
	JButton button = new JButton("Click to Play");

	// custom constructor for this class 
	public TwoDiceGUI()
	{
		super("Two Dice Game");
		setBounds(450, 450, 300, 240);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new FlowLayout());
		setResizable(false);
		getContentPane().setBackground(Color.CYAN);

		title.setFont(mainFont);
		result.setFont(mainFont);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);

		add(title);
		add(playerLabel);
		add(comLabel);
		add(result);
		add(pRoll);
		add(cRoll);
		add(button);

		button.addActionListener(this);
	}
	// event handling method
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// create two opbjects from the dice class
		Die playerDie = new Die();
		Die computerDie = new Die();
		String outcome;

		// Decide what the outcome of the game should be based on the values of the two Die objects
		if(playerDie.getDieValue() > computerDie.getDieValue())
		{
			outcome = "The player wins!";
			result.setForeground(Color.YELLOW);
		}
		else if(playerDie.getDieValue() < computerDie.getDieValue())
		{
			outcome = "The computer wins!";
			result.setForeground(Color.RED);

		}
		else
		{
			outcome = "We have a tie game.";
			result.setForeground(Color.ORANGE);

		}
		// this is the output to the GUI
		pRoll.setText("" +playerDie.getDieValue());
		cRoll.setText("" + computerDie.getDieValue());
		result.setText(outcome);
		button.setText("Play again!");
	}

	public static void main(String[] args) 
	{
		TwoDiceGUI from = new TwoDiceGUI();
	}
}