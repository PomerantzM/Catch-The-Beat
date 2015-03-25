import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;

public class outside_cave extends JFrame
{
	private ImageIcon pic = new ImageIcon("Outside Cave with motor cycle jpeg FINAL.jpg");
	private ImageIcon death = new ImageIcon("john cena grave.png");
	private JFrame frame, button;
	private JLabel label, deathLabel;
	private ReHandler reHandler;
	private NextHandler nextHandler;
	private DeathHandler deathHandler;
	private AudioInputStream audioInputStream;
	private Clip clip;
	
	public outside_cave()
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
		JButton next = new JButton("Walk to Las Vegas");
		button.add(next);
		next.addActionListener(nextHandler);
		JButton death = new JButton("Take the motorcycle");
		button.add(death);
		death.addActionListener(deathHandler);
		
		try{
			audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\48001131\\Documents\\SCHOOL\\Comp Prog\\Catch The Beat\\Audio\\4 OUTSIDE CAVE.wav").getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start(); 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "<html><body><center><p style='width: 950px;'>" + "You emerge from the mouth of the cave, In the distance you see the Sin City, Las Vegas, Nevada. You realize you must be in the Mojave Desert. You could walk to Las Vegas, or you could take the motorcycle you see parked near the road, but you have an odd feeling about the bike, like something's wrong with it." + "</body></html>", null, JOptionPane.INFORMATION_MESSAGE);
		clip.stop();
	}
	
	private class ReHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try{
				audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\48001131\\Documents\\SCHOOL\\Comp Prog\\Catch The Beat\\Audio\\4 OUTSIDE CAVE.wav").getAbsoluteFile());
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
			at_vegas at_vegas = new at_vegas();
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
				audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\48001131\\Documents\\SCHOOL\\Comp Prog\\Catch The Beat\\Audio\\5 OUTSIDE CAVE DEATH.wav").getAbsoluteFile());
				clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start(); 
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "<html><body><center><p style='width: 950px;'>" + "You decide to get on the motorcycle. It’s a beautiful Yamaha FZ-09. You can’t help but admire it’s stunning beauty. You see the keys in the ignition and turn them. No sooner that that does the IED in the motorcycle explode leaving you strewn across the road." + "</body></html>", null, JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void main(String[] args)
	{
		outside_cave outside_cave = new outside_cave();
	}
}
