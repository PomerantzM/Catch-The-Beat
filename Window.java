import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;

public class window extends JFrame 
{
	private ImageIcon picture = new ImageIcon("CenaTitle.gif");
	private ImageIcon beatFruit = new ImageIcon("JohnCena.gif");
	private JLabel displayPicJL, beatFruitJL;
	private JButton start, instruction;
	private InsHandler insHandler;
	private StaHandler staHandler;
	private JFrame frame;
	private AudioInputStream audioInputStream;
	private Clip clip;
	
	public window()
	{
		setTitle("John Cena's Fruit Catching Original Visual Novel Extraveganza Adventure");
		setSize(1280,720);
		setLocation(45, 0);
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
		frame.setLocation(595, 260);
		frame.add(start, BorderLayout.NORTH);
		frame.add(instruction, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		try{
			audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\48001131\\Documents\\SCHOOL\\Comp Prog\\Catch The Beat\\Audio\\AND HIS NAME IS JOHN CENAscreen.wav").getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start(); 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	private class InsHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			beatFruitJL = new JLabel(beatFruit);
			JOptionPane.showMessageDialog(null,"You have to find John Cena. After you click Start select an option from the bottom of the screen.", "Instructions", JOptionPane.INFORMATION_MESSAGE, beatFruit);
		}
	}
	private class StaHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			clip.stop();
			setVisible(false);
			dispose();
			frame.setVisible(false);
			frame.dispose();
			game game = new game();
			clip.stop();
		}
	}

	public static void main(String[] args)
	{
		window window = new window();
	}
}
