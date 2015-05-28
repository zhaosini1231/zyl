package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import control.control;
import Model.Park;
import GUI.ControlGUI;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	final String [] temp = new String[3];
	private JTextField textField_2;
	public static List list;
	public ControlGUI top;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
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
	public Add(ControlGUI up) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		top = up;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(96, 50, 54, 15);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(198, 47, 66, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblStatic = new JLabel("static");
		lblStatic.setBounds(96, 87, 54, 15);
		panel.add(lblStatic);
		
		JLabel lblPrice = new JLabel("price");
		lblPrice.setBounds(96, 138, 54, 15);
		panel.add(lblPrice);
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"used", "unused"}));
		comboBox.setBounds(198, 83, 66, 23);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("\u589E\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				temp[0] = textField.getText();
				temp[1]	=comboBox.getSelectedItem().toString();	
				temp[2] = textField_2.getText();
				list = control.getControl().findALL();
				
				boolean nameUnique = true;
				for(int i = 0;i < list.size(); i++)
				{
					if(temp[0].equals(((Park)list.get(i)).getParkId().toString()))
					{
						nameUnique = false;
						break;
					}
				}
				if(temp[0].equals(""))
				{
					JOptionPane.showConfirmDialog(null, "请输入停车位ID","提示", JOptionPane.CLOSED_OPTION);
				}
			    if(!nameUnique)
				{
					JOptionPane.showConfirmDialog(null, "此停车位已存在！","提示", JOptionPane.CLOSED_OPTION);
				}
			    if(temp[1].equals(""))
				{
					JOptionPane.showConfirmDialog(null, "请选择使用状态！","提示", JOptionPane.CLOSED_OPTION);
				}
			    if(temp[2].equals(""))
				{
					JOptionPane.showConfirmDialog(null, "价格不能为空！","提示", JOptionPane.CLOSED_OPTION);
				}
			    if( Double.parseDouble(temp[2])<0)
				{
					JOptionPane.showConfirmDialog(null, "价格不能为负数！","提示", JOptionPane.CLOSED_OPTION);
				}
				else
				{
				
				
					
					
					DefaultTableModel tableModel = (DefaultTableModel) top.getTable().getModel();
					tableModel.addRow(new Object[] {
							temp[0],temp[1],temp[2]});
					control.getControl().save(temp[0], temp[1], Double.parseDouble(temp[2]));
					
					top.InitialTable();
					dispose();
				}
				
			}
			
		});
		btnNewButton.setBounds(96, 203, 93, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(219, 203, 93, 23);
		panel.add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(198, 135, 66, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		
	}
	/*public void skip()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
}
