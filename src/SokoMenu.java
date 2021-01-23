package Project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SokoMenu extends IMenu{
	
	private JLabel rubrik;
	private JLabel creaters;
	private String [] names = {"Anja Karlsson", "Moa Arvidsson"};
	Window win = new Window();

	public SokoMenu() {
		
		win.frame.add(header("Welcome to SOKOBAN!"));
		win.frame.add(createBy(names));
		win.frame.add(startButton());
		win.frame.validate();
		win.frame.repaint();
	}
	
	@Override
	public JLabel header(String text) {
		rubrik = new JLabel(text);
		rubrik.setBounds(100, 100, 1000, 70);
		rubrik.setFont(new Font("Arial",Font.PLAIN,80));
		return rubrik;
	}

	@Override
	public JLabel createBy(String[] name) {
		String cn = "Created by: ";
		for (int i=0; i<name.length;i++) {
			cn = cn + "  " +name[i];
		}
		creaters = new JLabel(cn);
		creaters.setBounds(430,800,300,50);
		return creaters;		
	}
	public void startButtonPressed() {
		win.frame.dispose();
		new SokoPlayer();
	}



	
}
