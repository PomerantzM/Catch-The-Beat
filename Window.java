import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class window extends JFrame 
{
	private ImageIcon picture = new ImageIcon("beat.gif");
	private ImageIcon beatFruit = new ImageIcon("beatFruit.jpg");
	private JLabel displayPicJL, beatFruitJL;
	private JButton start, instruction;
	private InsHandler insHandler;
	private StaHandler staHandler;
	private JFrame frame;
	
	public window()
	{
		setTitle("Catch the Beat");
		setSize(1280,720);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		displayPicJL = new JLabel(picture);
		c.add(displayPicJL);
		c.setLayout(new GridLayout(1,1));
		
		insHandler = new InsHandler();
		staHandler = new StaHandler();
		
		start = new JButton("Start");
		start.setPreferredSize(new Dimension(40,40));
		instruction = new JButton("Instructions");
		instruction.setPreferredSize(new Dimension(40,40));
		c.add(start);
		c.add(instruction);
		instruction.addActionListener(insHandler);
		start.addActionListener(staHandler); 
		
		frame = new JFrame("Frame");
		frame.setLayout(new BorderLayout());
		frame.setSize(new Dimension(160, 120));
		frame.setLocation(510, 260);
		frame.add(start, BorderLayout.NORTH);
		frame.add(instruction, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
	
	private class InsHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			beatFruitJL = new JLabel(beatFruit);
			JOptionPane.showMessageDialog(null,"Use the left and right arrows to move the character and try to catch all the beats!", "Instructions", JOptionPane.INFORMATION_MESSAGE, beatFruit);
		}
	}
	private class StaHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			game game = new game();
			setVisible(false);
			dispose();
			frame.setVisible(false);
		}
	}

	public static void main(String[] args)
	{
		window window = new window();
	}
}
