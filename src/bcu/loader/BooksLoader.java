package bcu.loader;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import bcu.model.Book;

public class BooksLoader {

	private ArrayList<Book> books = new ArrayList<Book>();
	
	public ArrayList<Book> loadBooks(){
		try{
			FileReader file = new FileReader(".\\data\\books.txt");
			BufferedReader fileReader = new BufferedReader(file);
			String line = fileReader.readLine();			
			while(line != null){				
				String[] parts = line.split("::");				
				Book book = new Book();
				book.setIsbn(parts[0]);
				book.setTitle(parts[1]);
				book.setAuthor(parts[2]);
				book.setPublisher(parts[3]);
				book.setPudDate(parts[4]);
				book.setStatus(parts[5]);
				books.add(book);
				line = fileReader.readLine();
			}
			fileReader.close();
		}catch(Exception exp){
			exp.printStackTrace();
		}
		
		return books;
	}
	
	
	
	
}
