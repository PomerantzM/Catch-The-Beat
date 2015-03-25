import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;

public class cave extends JFrame
{
	private ImageIcon pic = new ImageIcon("cave.jpg");
	private ImageIcon death = new ImageIcon("john cena grave.png");
	private JFrame frame, button;
	private JLabel label, deathLabel;
	private ReHandler reHandler;
	private NextHandler nextHandler;
	private DeathHandler deathHandler;
	private AudioInputStream audioInputStream;
	private Clip clip;
	
	public cave()
	{
		frame = new JFrame("John Cena's Fruit Catching Original Visual Novel Extraveganza Adventure");
		frame.setTitle("John Cena's Fruit Catching Original Visual Novel Extraveganza Adventure");
		label = new JLabel(pic);
		frame.add(label);
		frame.setSize(1280, 720);
		frame.setLocation(45, 0);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		reHandler = new ReHandler();
		nextHandler = new NextHandler();
		deathHandler = new DeathHandler(); 
		
		button = new JFrame("Buttons");
		button.setVisible(true);
		button.setLayout(new GridLayout(1,3));
		button.setSize(1280, 70);
		button.setLocation(45, 650);
		JButton replay = new JButton("Replay");
		button.add(replay);
		replay.addActionListener(reHandler);
		JButton next = new JButton("Exit the cave");
		button.add(next);
		next.addActionListener(nextHandler);
		JButton death = new JButton("Go deeper into the cave");
		button.add(death);
		death.addActionListener(deathHandler);
		
		try{
			audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\48001131\\Documents\\SCHOOL\\Comp Prog\\Catch The Beat\\Audio\\2. CAVE1.wav").getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start(); 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "<html><body><center><p style='width: 950px;'>" + "You awake in a cave, you don’t know who you are or how long you've been there. You see that you are near the exit, or you can go deeper into the cave" + "</body></html>", null, JOptionPane.INFORMATION_MESSAGE);
		clip.stop();
	}
	
	private class ReHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try{
				audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\48001131\\Documents\\SCHOOL\\Comp Prog\\Catch The Beat\\Audio\\2. CAVE1.wav").getAbsoluteFile());
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
			outside_cave outside_cave = new outside_cave();
		}
	}
	
	private class DeathHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			clip.stop();
			frame.remove(label);
			deathLabel = new JLabel(death);
			frame.add(deathLabel);
			frame.revalidate();
			button.setVisible(false);
			try{
				audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\48001131\\Documents\\SCHOOL\\Comp Prog\\Catch The Beat\\Audio\\3. CAVE DEATH.wav").getAbsoluteFile());
				clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start(); 
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "<html><body><center><p style='width: 950px;'>" + "You decide to go deeper into the cave and inside you see a creature that strikes deep into your subconscious primal fears, a beast too horrifying for words. You perish at it’s feet." + "</body></html>", null, JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void main(String[] args)
	{
		cave cave = new cave();
	}
}

