package Frontend;




import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
public class Menu extends JPanel implements ActionListener,KeyListener
{
    
	JFrame window = new JFrame();
	JPanel panel=new JPanel();
 
    
  
	Menu()
	{
  
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		window.setSize(screenSize.width, screenSize.height);
		window.setResizable(false);
  
		window.add(this);
		//window.setSize(1198,735);
		window.setVisible(true);
  
		//window.setLayout(null);	
		//  window.add(panel);
		// JButton m = new JButton("hello");	
		//  JButton exitButton = new JButton();
		// m.setBounds(250,250,120,35);
		//  panel.add(m);
  
 }
 public void paint(Graphics g)
 {
	 ImageIcon background =new ImageIcon("images//back.png");
	 g.drawImage(background.getImage(),0,0,this.getWidth(),this.getHeight(),this);
 }
 @Override
 public void keyTyped(KeyEvent e) {
	 // TODO Auto-generated method stub
  
 }
 @Override
 public void keyPressed(KeyEvent e) {
	 // TODO Auto-generated method stub
  
 }
 @Override
 public void keyReleased(KeyEvent e) {
	 // TODO Auto-generated method stub
  
 }
 @Override
 public void actionPerformed(ActionEvent e) {
	 // TODO Auto-generated method stub
  
 }
}