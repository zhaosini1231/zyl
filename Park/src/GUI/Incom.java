package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import Model.Park;
import control.control;
import GUI.ControlGUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
public class Incom extends JFrame {

	private JPanel contentPane;
	
	public static List list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Incom frame = new Incom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Incom() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		double cost=0.0;
		list = control.getControl().findALL();
		int num=0;
		for(int i=0;i<list.size();i++)
		{
			Park park = (Park)list.get(i);
			if(park.getParkStatic().equals("used"))
			{
				num++;
				cost+=park.getPrice();
			}
		}
		

		
		String incom;
		incom=""+cost;
		textPane.setText(incom);
		textPane.setBounds(184, 115, 84, 21);
		panel.add(textPane);
		
		JLabel label = new JLabel("\u83B7\u5F97\u6536\u5165\u4E3A");
		label.setBounds(93, 109, 70, 27);
		panel.add(label);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(149, 178, 93, 23);
		panel.add(button);
		
		JLabel label_1 = new JLabel("\u606D\u559C \uFF01\u53D1\u8D22\uFF01");
		label_1.setForeground(Color.RED);
		label_1.setBounds(149, 59, 108, 21);
		panel.add(label_1);
	}
	public void skip()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Incom frame = new Incom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
