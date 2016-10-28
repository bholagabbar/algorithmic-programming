package CODECHEF.COOK_OFFS.COOK55.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class scratch {
	static public class Book {
		private int id;
		private String bookTitle;
		private String authorName;
		private int bookReleaseYear;
		private int numOnLoan;
		private int numInStock;
		
		//constructor
		public Book(int id, String bookTitle, String authorName, int bookReleaseYear, int numOnLoan, int numInStock) {
			this.id = id;
			this.bookTitle = bookTitle;
			this.authorName = authorName;
			this.bookReleaseYear = bookReleaseYear;
			this.numOnLoan = numOnLoan;
			this.numInStock = numInStock;
		}
		
		//Getters/Setters
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public String getBookTitle() {
			return bookTitle;
		}
		
		public void setBookTitle(String bookTitle) {
			this.bookTitle = bookTitle;
		}
		
		public String getAuthorName() {
			return authorName;
		}
		
		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}
		
		public int GetNumOnLoan() {
			return numOnLoan;
		}
		
		public void setNumOnLoan(int numOnLoan) {
			this.numOnLoan = numOnLoan;
		}
		
		public int getNumInStock() {
			return numInStock;
		}
		
		public void setNumInStock(int numInStock) {
			this.numInStock = numInStock;
		}
		
		
		public int getBookReleaseYear() {
			return bookReleaseYear;
		}
		
		public void setBookReleaseYear(int bookReleaseYear) {
			this.bookReleaseYear = bookReleaseYear;
		}


//Methods
		
		public void PrintBookDetails() {
			System.out.println("Book Details");
			System.out.println("------------------");
			System.out.println("Book ID: " + this.id);
			System.out.println("Book Title: " + this.bookTitle);
			System.out.println("Author Name: " + this.authorName);
			System.out.println("Released In: " + this.bookReleaseYear);
			System.out.println("Number out on loan: " + this.numOnLoan);
			System.out.println("Number in Stock:" + this.numInStock);
			
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Book> books = CreateAlphabeticalBooksArrayList();
		Loanbook(new Scanner(System.in), books);
		Loanbook(new Scanner(System.in), books);
		
		String a = "aaaabbbbcccc";
		StringBuilder sb = new StringBuilder();
		HashSet<Character> hs = new HashSet<Character>(); //Stores a unique entry for each character
		for (int i = 0; i < a.length(); i++) {
			if (!hs.contains(a.charAt(i))) {
				sb.append(a.charAt(i));
				hs.add(a.charAt(i));
			}
		}
		String compStr = sb.toString();
		System.out.println(compStr);
		
	}
	
	public void getInitials(String name) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter name: ");
		String input = scanner.nextLine();
		String result = "";
		char firstChar = input.charAt(0);
		char fUpper = Character.toUpperCase(firstChar);
		result = result + fUpper;
		for (int i = 1; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			char cUpper = Character.toUpperCase(currentChar);
			char previousChar = input.charAt(i - 1);
			char pUpper = Character.toUpperCase(previousChar);
			if (pUpper == ' ') {
				result = result + "." + cUpper;
			}
		}
		System.out.println("Initials Are: " + result);
	}
	
	
	public static void Loanbook(Scanner sc, ArrayList<Book> books) {
		System.out.println("Please enter a book title");
		if (sc.hasNext()) {
			String criteria = sc.nextLine();
			for (int i = 0; i < books.size(); i++) {
				if (criteria.equals(books.get(i).getBookTitle())) {
					System.out.println("The book " + books.get(i).getBookTitle() + "    there are " + books.get(i).getNumInStock() + " in stock");
					books.get(i).setNumOnLoan(1);
					System.out.println("number on loan: " + books.get(i).GetNumOnLoan());
					break;
				}
			}
			System.out.println("Book Loaned");
			
		}
	}
	
	public static ArrayList<Book> CreateAlphabeticalBooksArrayList() {
		int[] id = {1, 2, 3, 4, 5};
		String[] bookTitle = {"bbbbb", "aaaaa", "zzzzz", "kkkkk", "qqqqq"};
		String[] authorName = {"bbbbb", "aaaaaa", "qqqqq", "zzzzz", "ggggg"};
		int[] bookReleaseYear = {401, 234, 358, 521, 100};
		int[] numOnLoan = {1, 2, 2, 3, 4};
		int[] numInStock = {5, 5, 5, 5, 5};
		
		
		int bID = -1;
		String bTitle = null;
		String aName = null;
		int bRelease = -1;
		int nLoan = -1;
		int nStock = -1;
		
		ArrayList<Book> books = new ArrayList<Book>();
		for (int i = 0; i < 5; i++) {
			bID = id[i];
			bTitle = bookTitle[i];
			aName = authorName[i];
			bRelease = bookReleaseYear[i];
			nLoan = numOnLoan[i];
			nStock = numInStock[i];
			books.add(new Book(bID, bTitle, aName, bRelease, nLoan, nStock));
			
		}
		
		return books;
	}
	
	//creates dummy array list for testing methods
	public static ArrayList<Book> CreateBooksArrayList() {
		int[] id = {1, 2, 3, 4, 5};
		String[] bookTitle = {"book1", "book2", "book3", "book4", "book5"};
		String[] authorName = {"author1", "author2", "author3", "author4", "author5"};
		int[] bookReleaseYear = {1995, 1990, 1945, 2001, 1800};
		int[] numOnLoan = {1, 2, 2, 3, 4};
		int[] numInStock = {5, 5, 5, 5, 5};
		
		
		int bID = -1;
		String bTitle = null;
		String aName = null;
		int bRelease = -1;
		int nLoan = -1;
		int nStock = -1;
		
		ArrayList<Book> books = new ArrayList<Book>();
		for (int i = 0; i < 5; i++) {
			bID = id[i];
			bTitle = bookTitle[i];
			aName = authorName[i];
			bRelease = bookReleaseYear[i];
			nLoan = numOnLoan[i];
			nStock = numInStock[i];
			books.add(new Book(bID, bTitle, aName, bRelease, nLoan, nStock));
			
		}
		return books;
	}
	
	
	public static void SearchBooks(Scanner sc, ArrayList<Book> books) {
		System.out.println("Please enter a book title");
		if (sc.hasNext()) {
			ArrayList<Book> book = CreateAlphabeticalBooksArrayList();
			String criteria = sc.next();
			for (int i = 0; i < books.size(); i++) {
				if (criteria.equals(books.get(i).getBookTitle())) {
					System.out.println("The book " + books.get(i).getBookTitle() + " is in stock, it is written by " + books.get(i).getAuthorName());
					break;
					
				} else {
					System.out.println("This book is not in stock");
				}
				
			}
			
		}
	}
}