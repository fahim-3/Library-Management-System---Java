package bcu.gui;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import bcu.model.User;

import javax.swing.JFrame;



public class AddUserWindow extends JFrame implements ActionListener{
	private MainWindow mw;
	private JTextField idText = new JTextField();
	private JTextField nameText = new JTextField();
	private JTextField noBorrowedBooksText = new JTextField();
	private JTextField phoneNumText = new JTextField();
	
	private JButton addBtn = new JButton("Add");
	private JButton cancelBtn = new JButton("Cancel");
	
	
	
	public AddUserWindow(MainWindow mw){
			this.mw = mw;
			initialize();
	 }

	private void initialize() {
		// TODO Auto-generated method stub
		
		setTitle("Add a New User");
		
		JPanel topPanel = new JPanel();
		 topPanel.setLayout(new GridLayout(5,2));
		 topPanel.add(new JLabel("ID : "));
		 topPanel.add(idText);
		 topPanel.add(new JLabel("Name : "));
		 topPanel.add(nameText);
		 topPanel.add(new JLabel("Number of Books Borrowed : "));
		 topPanel.add(noBorrowedBooksText);
		 topPanel.add(new JLabel("Phone Number : "));
		 topPanel.add(phoneNumText);

		 JPanel bottomPanel = new JPanel();
		 bottomPanel.setLayout(new GridLayout(1,3));
		 bottomPanel.add(new JLabel(" "));
		 bottomPanel.add(addBtn);
		 bottomPanel.add(cancelBtn); 

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addBtn){
			 User user = new User();
			 user.setId(idText.getText());
			 user.setName(nameText.getText());
			 user.setPhone(Integer.parseInt(phoneNumText.getText()));
			 mw.addUserToList(user);
			 mw.displayUser();
			 this.setVisible(false); 

			user.setnumBooksBorrowed(Integer.parseInt(noBorrowedBooksText.getText())); 
		}
	} 
}
