package chess_Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board_Redraw extends JFrame
{
	public Board_Redraw()
	{
		super("Chess Game");
		setContentPane(new JLabel(new ImageIcon("images//Background.jpg")));
		setResizable(false);
		// setSize(1017,538);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

		/// Dimension contentSize = this.getContentPane().getSize();
		// this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// this.setUndecorated(true);
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color(0, 0, 0));
		getContentPane().add(panel);
		panel.setLayout(null);
		//
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, (int) ((screenSize.height - 40) * 1.72 / 4), screenSize.height - 35);
		panel.add(panel_1);

		JPanel p = new JPanel();
		// p.setBounds(310, 0, 740, 740);
		p.setBounds((int) ((screenSize.height - 40) * 1.72 / 4), 0, screenSize.height - 35, screenSize.height - 35);
		panel.add(p);
		p.setLayout(new GridLayout(8, 8, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds((int) ((screenSize.height - 40) * 1.72 / 4) + (screenSize.height - 35), 0,
				(int) ((screenSize.height - 40) * 1.72 / 4), screenSize.height - 35);
		panel.add(panel_2);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				// btn[i][j]=new JButton();
				button[i][j] = new Pieces_btn(i, j);
				button[i][j].addActionListener(this);
				// btn[i][j].addActionListener(this);
				if ((i + j) % 2 == 0)
					button[i][j].setBackground(new Color(255, 229, 181));// btn[i][j].setBackground(new
																			// Color(255,229,181));
				else
					button[i][j].setBackground(new Color(176, 100, 43));// btn[i][j].setBackground(new
																		// Color(176,100,43));
				p.add(button[i][j]);// p.add(btn[i][j]);
			}
		}

		getContentPane().add(panel);

		setVisible(true);
	}

}
