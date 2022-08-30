package bcu.gui;

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

import bcu.model.Book;


public class AddBookWindow extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MainWindow mw;
	private JTextField isbnText = new JTextField();
	private JTextField titleText = new JTextField();
	private JTextField authText = new JTextField();
	private JTextField pubText = new JTextField();
	private JTextField pubDateText = new JTextField();
	
	private JButton addBtn = new JButton("Add");
	private JButton cancelBtn = new JButton("Cancel");
	
	public AddBookWindow(MainWindow mw){
		this.mw = mw;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
        try{ 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception ex){                
        } 
		
		

		//setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/icons/icon.JPG")));
		setTitle("Add a New Book");
		
		setSize(300, 200);
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(5,2));
		topPanel.add(new JLabel("ISBN : "));
		topPanel.add(isbnText);
		topPanel.add(new JLabel("Title : "));
		topPanel.add(titleText);
		topPanel.add(new JLabel("Author : "));
		topPanel.add(authText);
		topPanel.add(new JLabel("Publisher : "));
		topPanel.add(pubText);
		topPanel.add(new JLabel("Publishing Date : "));
		topPanel.add(pubDateText);		
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1,3));
		bottomPanel.add(new JLabel("     "));
		bottomPanel.add(addBtn);
		bottomPanel.add(cancelBtn);
		
		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		//this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(topPanel, BorderLayout.CENTER);
		this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		
		setVisible(true);		    
        		
	}		
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == addBtn){
			Book book = new Book();
			book.setIsbn(isbnText.getText());
			book.setTitle(titleText.getText());
			book.setAuthor(authText.getText());
			book.setPublisher(pubText.getText());
			book.setPudDate(pubDateText.getText());
			book.setStatus("Available");
			mw.addBookToList(book);
			mw.displayBooks();
			this.setVisible(false);
			
		}
		else if(ae.getSource() == cancelBtn){
			this.setVisible(false);
		}
		
	}

}
