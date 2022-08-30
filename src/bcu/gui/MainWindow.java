package bcu.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import bcu.loader.BooksLoader;
import bcu.model.Book;
import bcu.model.User;//

public class MainWindow extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
    private JMenuBar menuBar;
	private JMenu admin;
	private JMenu books;
	private JMenu members;
	
	
	private JMenuItem adminAdd;
	private JMenuItem adminChngePwd;
	private JMenuItem adminExit;
	
	private JMenuItem booksView;
	private JMenuItem booksAdd;
	private JMenuItem booksDel;	
	private JMenuItem booksIssue;
	private JMenuItem booksSearch;
	
	private JMenuItem memView;
	private JMenuItem memAdd;
	private JMenuItem memDel;
	private JMenuItem memSearch;

	
	
	
	private BooksLoader booksLoader = new BooksLoader();
	private ArrayList<Book> booksList = new ArrayList<Book>();
	
	private ArrayList<User> userList = new ArrayList<User>();
	
	public MainWindow() {
		
		initialize();
		
		booksList = booksLoader.loadBooks();
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
		setTitle("Library Management System");
		

		
		
		
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        //adding admin menu and menu items
        
        admin = new JMenu("Admin");
        menuBar.add(admin);
        
        adminAdd = new JMenuItem("Add Admin");
        adminChngePwd = new JMenuItem("Change Password");
        adminExit = new JMenuItem("Exit");
        admin.add(adminAdd);
        admin.add(adminChngePwd);
        admin.add(adminExit);
        adminAdd.addActionListener(this);
        adminChngePwd.addActionListener(this);
        adminExit.addActionListener(this);
        
        //adding books menu and menu items
        books = new JMenu("Books");
        menuBar.add(books);
        
        booksView = new JMenuItem("View");
        booksAdd = new JMenuItem("Add");
        booksDel = new JMenuItem("Delete");
        booksIssue = new JMenuItem("Issue");
        booksSearch = new JMenuItem("Search");
        books.add(booksView);
        books.add(booksAdd);
        books.add(booksDel);
        books.add(booksIssue);
        books.add(booksSearch);
        booksView.addActionListener(this);
        booksAdd.addActionListener(this);
        booksDel.addActionListener(this);
        booksIssue.addActionListener(this);
        booksSearch.addActionListener(this);
        
        //adding members menu and menu items
        
        members = new JMenu("Members");
        menuBar.add(members);
        
        memView = new JMenuItem("View");
        memAdd = new JMenuItem("Add");
        memDel = new JMenuItem("Delete");
        memSearch = new JMenuItem("Search");
        
        members.add(memView);
        members.add(memAdd);
        members.add(memDel);
        members.add(memSearch);

        memView.addActionListener(this);
        memAdd.addActionListener(this);
        memDel.addActionListener(this);      
        memSearch.addActionListener(this);
        
		setSize(800, 500);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE) ;        
        		
	}	
	
	public static void main(String[] args) {
			new MainWindow();			
	}



	@Override
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource() == adminAdd){
			
			
		}
		else if(ae.getSource() == adminChngePwd){
			
		}
		else if(ae.getSource() == adminExit){
			System.exit(0);
		}		
		else if(ae.getSource() == booksView){				
			displayBooks();
		}
		else if(ae.getSource() == memView){
			displayUser(); //
		

			
			
		}
		else if(ae.getSource() == booksAdd){
			new AddBookWindow(this);
			
		}				
		else if(ae.getSource() == booksDel){
			
		}				
		else if(ae.getSource() == booksIssue){
			
		}		
		else if(ae.getSource() == booksSearch){
			
		}				
		else if(ae.getSource() == memView){
			
		}
		else if(ae.getSource() == memAdd){
			
		}				
		else if(ae.getSource() == memDel){
			
		}				
		else if(ae.getSource() == memSearch){
			
		}						
	}	
	
	public void addBookToList(Book book){
		booksList.add(book);
	}
	
	public void displayBooks(){
		//headers for the table
        String[] columns = new String[] {
            "ISBN", "Title", "Author", "Publisher", "Pub Date", "Status"
        };
        
        Object[][] data = new Object[booksList.size()][6];
        for(int i = 0; i < booksList.size(); i++){
        	Book book = booksList.get(i);
        	data[i][0] = book.getIsbn();
        	data[i][1] = book.getTitle();
        	data[i][2] = book.getAuthor();
        	data[i][3] = book.getPublisher();
        	data[i][4] = book.getPudDate();
        	data[i][5] = book.getStatus();
        }
        
		JTable table = new JTable(data, columns);
		this.getContentPane().removeAll();
		this.getContentPane().add(new JScrollPane(table));
		this.revalidate();
	
	}


	public void addUserToList(User user){
		userList.add(user);
		}
	
	public void displayUser(){
	
		String[] columns = new String[] {
				"ID", "Name", "Number of Books Borrowed", "Phone Number"
		};
		
		Object[][] data = new Object[userList.size()][columns.length];
		for(int i = 0; i < userList.size(); i++){
			User user = userList.get(i);
			data[i][0] = user.getId();
			data[i][1] = user.getName();
			data[i][2] = user.getnumBooksBorrowed();
			data[i][3] = user.getPhone();
		}
		
		JTable table = new JTable(data, columns);
		this.getContentPane().removeAll();
		this.getContentPane().add(new JScrollPane(table));
		this.revalidate();
			
	}
}
