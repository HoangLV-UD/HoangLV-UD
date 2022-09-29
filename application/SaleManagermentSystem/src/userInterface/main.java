package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dao.CustomerDao;
import DomainObject.Customer;
import JDBC.jdbc;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;

public class main extends JFrame {

	private JPanel contentPane;
	private JTextField txtNameCustomer;
	private JTable tblCustomer;
	CustomerDao cusDao = new CustomerDao();
	private JTextField txtIdCustomer;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1074, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 1040, 472);
		contentPane.add(tabbedPane);

		JPanel Customer_1 = new JPanel();
		Customer_1.setToolTipText("");
		tabbedPane.addTab("Customer", null, Customer_1, null);
		Customer_1.setLayout(null);

		txtNameCustomer = new JTextField();
		txtNameCustomer.setBounds(133, 19, 96, 19);
		Customer_1.add(txtNameCustomer);
		txtNameCustomer.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Name Customer");
		lblNewLabel_1.setBounds(36, 22, 74, 13);
		Customer_1.add(lblNewLabel_1);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnAdd.setBounds(239, 18, 85, 21);
		Customer_1.add(btnAdd);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// btn update
				update();
			}
		});
		btnUpdate.setBounds(331, 18, 85, 21);
		Customer_1.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//btn delete 
				delete();
			}
		});
		btnDelete.setBounds(425, 18, 85, 21);
		Customer_1.add(btnDelete);

		tblCustomer = new JTable();
		tblCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// click table
				// tblCustomer.setEnabled(false);
				tblCustomer.setDefaultEditor(Object.class, null);
				if (e.getClickCount() == 2) {
					int row = tblCustomer.getSelectedRow();
					String idcustomer = tblCustomer.getValueAt(row, 0).toString();
					Customer cus = cusDao.selectId(idcustomer);
					setForm(cus);
					tblCustomer.setRowSelectionInterval(row, row);
				}
			}
		});
		tblCustomer.setModel(new DefaultTableModel(
				new Object[][] { { "", null }, { null, null }, { null, null }, { null, null }, { null, null }, },
				new String[] { "CustomerID", "CustomerName" }));
		tblCustomer.setBounds(59, 92, 657, 234);
		Customer_1.add(tblCustomer);

		JLabel lblNewLabel_1_1 = new JLabel("ID Customer");
		lblNewLabel_1_1.setBounds(36, 45, 74, 13);
		Customer_1.add(lblNewLabel_1_1);

		txtIdCustomer = new JTextField();
		txtIdCustomer.setEditable(false);
		txtIdCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdCustomer.setEditable(false);
			}
		});
		txtIdCustomer.setColumns(10);
		txtIdCustomer.setBounds(133, 48, 96, 19);
		Customer_1.add(txtIdCustomer);
		
				JPanel panel_2 = new JPanel();
				tabbedPane.addTab("Employee", null, panel_2, null);
				
				JLabel lblNewLabel_1_2 = new JLabel("Name Customer");
				panel_2.add(lblNewLabel_1_2);
				
				textField = new JTextField();
				textField.setColumns(10);
				panel_2.add(textField);
				
				JLabel lblNewLabel_1_1_1 = new JLabel("ID Customer");
				panel_2.add(lblNewLabel_1_1_1);
				
				textField_1 = new JTextField();
				textField_1.setEditable(false);
				textField_1.setColumns(10);
				panel_2.add(textField_1);
				
				JButton btnAdd_1 = new JButton("Add");
				panel_2.add(btnAdd_1);
				
				JButton btnUpdate_1 = new JButton("Update");
				panel_2.add(btnUpdate_1);
				
				JButton btnDelete_1 = new JButton("Delete");
				panel_2.add(btnDelete_1);
		
				JPanel panel_3 = new JPanel();
				tabbedPane.addTab("Product", null, panel_3, null);
				
				JSpinner spinner = new JSpinner();
				panel_3.add(spinner);
				
				table = new JTable();
				panel_3.add(table);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Orders", null, panel_4, null);

		JPanel Customer = new JPanel();
		tabbedPane.addTab("Line Item", null, Customer, null);

		JLabel lblNewLabel = new JLabel("Name Customer");
		Customer.add(lblNewLabel);

		loadtable();
	}

	public void loadtable() {
		DefaultTableModel model = (DefaultTableModel) tblCustomer.getModel();
		model.setRowCount(0);
		try {
			List<Customer> lst = cusDao.selectAll();
			for (Customer c : lst) {
				Object[] row = { c.getCustomerId(), c.getCustomerName() };
				model.addRow(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Customer getForm() {
		Customer c = new Customer();
		c.setCustomerId(Integer.valueOf(txtIdCustomer.getText()));
		c.setCustomerName(txtNameCustomer.getText());

		return c;
	}

	public void insert() {
		try {
			Customer c = getForm();
			cusDao.insert(c);
			JOptionPane.showMessageDialog(this, "them thanh cong");
			loadtable();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public void update() {
		try {
			cusDao.update(getForm());
			loadtable();
			JOptionPane.showMessageDialog(this, "Update Sussesfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Update Not Sussesfully");
		}
	}
	public void delete() {
		int d = JOptionPane.showConfirmDialog(null, "You Sure", "Delete Option", JOptionPane.YES_NO_OPTION);
		if(d == JOptionPane.YES_OPTION){
			try {
				int id = Integer.valueOf(txtIdCustomer.getText());
				cusDao.delete(id);
				loadtable();
				JOptionPane.showMessageDialog(this, "Delete Sussesfully");
				
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "Delete Not Sussesfully");
				// TODO: handle exception
			}
		}
		
	}

	public void setForm(Customer c) {
		txtNameCustomer.setText(c.getCustomerName());
		txtIdCustomer.setText(String.valueOf(c.getCustomerId()));
	}
}
