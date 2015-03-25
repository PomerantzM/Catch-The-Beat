import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;

public class game extends JFrame
{
	private ImageIcon cenaFruit = new ImageIcon("cena temple.png");
	private JFrame frame, button;
	private JLabel cenaFruitPic;
	private ReHandler reHandler;
	private NextHandler nextHandler;
	private AudioInputStream audioInputStream;
	private Clip clip;

	public game()
	{
		frame = new JFrame("John Cena's Fruit Catching Original Visual Novel Extraveganza Adventure");
		frame.setTitle("John Cena's Fruit Catching Original Visual Novel Extraveganza Adventure");
		cenaFruitPic = new JLabel(cenaFruit);
		frame.add(cenaFruitPic);
		frame.setSize(1280, 720);
		frame.setLocation(45, 0);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		reHandler = new ReHandler();
		nextHandler = new NextHandler();
		
		button = new JFrame("Buttons");
		button.setVisible(true);
		button.setLayout(new GridLayout(1,2));
		button.setSize(1280, 70);
		button.setLocation(45, 650);
		JButton replay = new JButton("Replay");
		button.add(replay);
		replay.addActionListener(reHandler);
		JButton next = new JButton("Next");
		button.add(next);
		next.addActionListener(nextHandler);
		
		try{
			audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\48001131\\Documents\\SCHOOL\\Comp Prog\\Catch The Beat\\Audio\\1 INTRO1.wav").getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start(); 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "<html><body><center><p style='width: 950px;'>" + "Years ago Earth passed through a fruit field floating in space. The fruit was going to anhilate the Earth but the WWE Wrestlers banded together to catch the fruit and save the Earth. It was a tough battle and one by one the World Wrestlers began to fall. But among the Wrestlers there was one man who never fell. AND HIS NAME IS JOHN CENA!!!" + "</body></html>", null, JOptionPane.INFORMATION_MESSAGE);
		clip.stop();
		
		try{
			audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\48001131\\Documents\\SCHOOL\\Comp Prog\\Catch The Beat\\Audio\\AND HIS NAME IS JOHN CENA.wav").getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start(); 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		try {
		    Thread.sleep(20000);                
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		try{
			audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\48001131\\Documents\\SCHOOL\\Comp Prog\\Catch The Beat\\Audio\\1 INTRO2.wav").getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);   				
			clip.start(); 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "<html><body><center><p style='width: 950px;'>" + "In a last ditch attempt to aid John Cena during the last leg of the battle the US military brought out a weapon that only John Cena himself could wield: A titanium alloy plate with a diameter of 220km. John Cena traversed the earth moving at 99% of the speed of light, catching each piece of fruit before it could hit the earth. Once  the battle was concluded and the dust settled, John Cena was nowhere to be found, leaving only the titanium alloy plate and a pile of fruit 100 km high. That was seven years ago, but John Cena still lives on in the hearts of of all as the savior of humanity and the guardian of earth. Though for some reason no one can remember his face." + "</body></html>", null, JOptionPane.INFORMATION_MESSAGE);
		clip.stop();
	}
	
	private class ReHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try{
				audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\48001131\\Documents\\SCHOOL\\Comp Prog\\Catch The Beat\\Audio\\1INTRO1.wav").getAbsoluteFile());
				clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start(); 
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			try {
			    Thread.sleep(23500);                
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}

			try{
				audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\48001131\\Documents\\SCHOOL\\Comp Prog\\Catch The Beat\\Audio\\1 INTRO2.wav").getAbsoluteFile());
				clip = AudioSystem.getClip();
				clip.open(audioInputStream);   				
				clip.start(); 
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	private class NextHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			clip.stop();
			frame.dispose();
			button.dispose();
			cave cave = new cave();
		}
	}
	
	public static void main(String[] args)
	{
		game game = new game();
	}
}
