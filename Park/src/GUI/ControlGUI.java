package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


import java.awt.event.InputEvent;
import java.util.ArrayList;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import GUI.Incom;
import Model.Park;
import control.control;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class ControlGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public static List list;
	public  ControlGUI gui = this;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlGUI frame = new ControlGUI();
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
	public JTable getTable() {
		return table;
	}
	public ControlGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(124, 252, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\u589E\u52A0\u505C\u8F66\u4F4D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*DefaultTableModel tableModel = (DefaultTableModel) getTable().getModel();

				list = control.getControl().findALL();
				int i=list.size();
				String s;
				
				for(int a=0;a<list.size();a++)
				{
					s=""+a;
					Park park = (Park)list.get(a);
					if(!s.equals(park.getParkId())&&park!=null)
					{
						i=a;
					}
				}
				s=""+i;
					tableModel.addRow(new Object[] {
						s,"unused",
						10.0,});
				
				control.getControl().save(s, "unused",10.0 );*/
				/*Add add = new Add();
				add.skip();
				InitialTable();*/
				Add add=new Add(gui);
				add.setVisible(true);
				
				
			}
				
		});
		btnNewButton.setBounds(10, 73, 117, 23);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(176, 56, 220, 153);
		panel.add(scrollPane);
		
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
				
			new Object[][] {
			},
			new String[] {
				"parkID", "static", "price"
			}
			
			
		) 
		
		{
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		InitialTable();
		
		table.getColumnModel().getColumn(0).setPreferredWidth(136);
		table.getColumnModel().getColumn(1).setPreferredWidth(140);
		table.getColumnModel().getColumn(2).setPreferredWidth(146);
		
		scrollPane.setViewportView(table);
		this.setVisible(true);
		
		
		
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u505C\u8F66\u4F4D");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel tableModel = (DefaultTableModel) getTable().getModel();
				if(getTable().getSelectedRowCount() == 0)
				{
					JOptionPane.showConfirmDialog(null, "请选择要删除的记录!","提示", JOptionPane.CLOSED_OPTION);
				}
				else if(getTable().getSelectedRowCount() > 0)
				{
					int choice = JOptionPane.showConfirmDialog(null, "选中的记录将被删除!","是否删除:", JOptionPane.OK_CANCEL_OPTION);
					if(choice == 0)//确定
					{						
						int i = getTable().getSelectedRow();
						Park park = control.getControl().findById(getTable().getModel().getValueAt(i, 0).toString());
						control.getControl().delete(park);	
						
					}
					InitialTable();
				}
				
				
			}
		});
		btnNewButton_1.setBounds(10, 122, 117, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u66F4\u6539\u505C\u8F66\u4F4D\u72B6\u6001");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*int c=0;
				if(getTable().getSelectedRowCount() == 0)
				{
					JOptionPane.showConfirmDialog(null, "请选择要修改的记录!","提示", JOptionPane.CLOSED_OPTION);
				}
				else
				{   
					int i = getTable().getSelectedRow();
					Park park = control.getControl().findById(getTable().getModel().getValueAt(i, 0).toString());
					if(park.getParkStatic().equals("unused"))
					{
						park.setParkStatic("used");
					}
					else if(park.getParkStatic().equals("used"))
					{
						park.setParkStatic("unused");
					}
					
					InitialTable();
				}	*/
				Modify modify=new Modify(gui);
				modify.setVisible(true);
			}
				
			
		});
		btnNewButton_2.setBounds(10, 172, 131, 23);
		panel.add(btnNewButton_2);
		
		JButton button_1 = new JButton("\u83B7\u5F97\u5F53\u524D\u8425\u4E1A\u989D");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Incom incom = new Incom();
				incom.skip();
		
			}
		});
		button_1.setBounds(215, 219, 148, 23);
		panel.add(button_1);
		
		JLabel label = new JLabel("\u505C\u8F66\u573A\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		label.setForeground(SystemColor.textHighlight);
		label.setBounds(71, 10, 247, 41);
		panel.add(label);
	
	}
	public void InitialTable()//初始表
	{
		DefaultTableModel tableModel = (DefaultTableModel) getTable().getModel();
		if(tableModel.getRowCount() != 0)
		{
			tableModel.setRowCount(0);
		}
		list = control.getControl().findALL();//返回数据表的每一行
		for(int i = 0;i < list.size();i++)//更新表
		{
			Park park = (Park)list.get(i);
			tableModel.addRow(new Object[] {
				park.getParkId(),park.getParkStatic(),
				park.getPrice(),});
		}
	}
}
