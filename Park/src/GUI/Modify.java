package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.control;
import Model.Park;
import GUI.ControlGUI;

import javax.swing.table.DefaultTableModel;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Modify extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	final String [] temp = new String[3];
	public static List list;
	public ControlGUI top;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modify frame = new Modify();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Modify(ControlGUI up) {
		top =up;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ParkID");
		lblNewLabel.setBounds(79, 52, 54, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Static");
		lblNewLabel_1.setBounds(79, 89, 54, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setBounds(79, 131, 54, 15);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(180, 49, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 131, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"used", "unused"}));
		comboBox.setBounds(180, 97, 66, 21);
		panel.add(comboBox);
		System.out.print(0);
		int rowNum = top.getTable().getSelectedRow();		
		System.out.print(1);
		textField.setText(top.getTable().getModel().getValueAt(rowNum, 0).toString());
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp[0] = textField.getText();
				temp[1]	= comboBox.getSelectedItem().toString();
				temp[2] = textField_1.getText();
				
				if(temp[2].equals(""))
				{
					JOptionPane.showConfirmDialog(null, "价格不能为空！","提示", JOptionPane.CLOSED_OPTION);
				}
				if( Double.parseDouble(temp[2])<0)
				{
					JOptionPane.showConfirmDialog(null, "价格不能为负数！","提示", JOptionPane.CLOSED_OPTION);
				}
				
				if((!temp[2].equals(""))&&(temp[1].equals("")))
				{
					JOptionPane.showConfirmDialog(null, "请选择停车位状态！","提示", JOptionPane.CLOSED_OPTION);
				}
				
				else
				{
					Park park=control.getControl().findById(textField.getText());
					control.getControl().delete(park);
					
					Park newPark = new Park(temp[0],temp[1],Double.parseDouble(temp[2]));
					DefaultTableModel tableModel = (DefaultTableModel) top.getTable().getModel();
					tableModel.addRow(new Object[] {
							temp[0],temp[1],temp[2]});
					control.getControl().save(temp[0], temp[1], Double.parseDouble(temp[2]));
					top.InitialTable();
					//control.getControl().merge(newPark);
					//top.InitialTable();
					dispose();
				}
				
				
			}
			
		});
		btnNewButton.setBounds(34, 183, 93, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(236, 183, 93, 23);
		panel.add(btnNewButton_1);
	}
}
