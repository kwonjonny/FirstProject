import java.util.ArrayList;

//문제: Book2 클래스를 만들고, BookList2 클래스를 만드세요. Book 클래스는 책의 제목(title)과 저자(author) 필드를 갖고 있으며, 
//생성자와 각 필드의 getter/setter 메서드를 포함합니다. 

//BookList2 클래스는 ArrayList<Book> books 인스턴스 변수를 갖고 있으며, 
//생성자와 getter/setter 메서드를 포함합니다.
//BookList2 클래스에는 addBook(Book book) 메서드가 있어서 books 리스트에 책을 추가할 수 있습니다. 
//BookList2 클래스에는 
//printBooks() 메서드가 있어서 books 리스트에 있는 모든 책의 제목과 저자를 출력할 수 있습니다.

// 출력 예시
//Title: To Kill a Mockingbird, Author: Harper Lee
//Title: 1984, Author: George Orwell
//Title: The Great Gatsby, Author: F. Scott Fitzgerald

//GraduateBook 클래스는 Book 클래스를 상속받습니다. 
//그리고 전공(major)을 추가로 가집니다. 생성자에서는 부모 클래스의 생성자를 호출하며, 
//각 인스턴스 변수의 getter와 setter 메서드를 정의합니다.

// GraduateBookList 클래스를 만들어서 BookList 클래스를 상속받으세요. 
// GraduateBookList 클래스에는 전공(major) 필드를 추가로 받도록 해주세요. 
// GraduateBook 클래스를 만들어서 Book 클래스를 상속받으며, 전공 필드를 추가로 받도록 해주세요. 
// GraduateBookList 클래스의 addBook(Book book) 메서드를 오버라이딩하여, 
// 새로운 GraduateBook 인스턴스를 생성하고 books 리스트에 추가할 수 있도록 해주세요. 
// GraduateBookList 클래스의 생성자는 BookList 클래스의 생성자를 호출하며, 
// 전공 필드의 getter/setter 메서드도 포함해야 합니다

// 참고사항: 문제에서는 GraduateBookList와 GraduateBook 클래스를 만들어 상속을 이용한 
//문제 풀이를 연습할 수 있도록 했습니다. 
//하지만, 이 문제를 푸는데 있어서 상속은 필수가 아니며, 인터페이스를 이용해도 충분히 구현 가능합니다

public class Book2 {
	
	// 인스턴스 변수 정의
	private String title;
	private String author;

	// 생성자 정의
	public Book2(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	// Getter Setter정의 캡슐화,정보은닉,보수용이
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}


//BookList2 클래스는 ArrayList<Book> books 인스턴스 변수를 갖고 있으며, 
//생성자와 getter/setter 메서드를 포함합니다.
//BookList2 클래스에는 addBook(Book book) 메서드가 있어서 books 리스트에 책을 추가할 수 있습니다. 
//BookList2 클래스에는 
//printBooks() 메서드가 있어서 books 리스트에 있는 모든 책의 제목과 저자를 출력할 수 있습니다.
class BookList2{
	
	// 인스턴스 변수 ArrayList형 books정의
	private ArrayList<Book2> books;
	
	// 생성자 정의
	public BookList2() {
		this.books = books;
	}
	
	// Getter Setter정의 캡슐화,정보은닉,보수용이
	public ArrayList<Book2> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Book2> books) {
		this.books = books;
	}
	
	// books 리스트에 책 추가
	public void addBook(Book2 book) {
		books.add(book);
	}
	
	// books 리스트에 있는 모든 책의 제목과 저자 출력
	public void printBooks() {
		for(Book2 book : books) {
			System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
		}
	}
}

//GraduateBook 클래스는 Book 클래스를 상속받습니다. 
//그리고 전공(major)을 추가로 가집니다. 생성자에서는 부모 클래스의 생성자를 호출하며, 
//각 인스턴스 변수의 getter와 setter 메서드를 정의합니다.
class GraduateBook extends Book2 {
	
	// 인스턴스 변수 정의 
	private String major;
	
	// 생성자 정의
	// Book2클래스의 생성자 호출 & major 인스턴스 변수 초기화
	public GraduateBook(String title, String author, String major) {
		super(title,author);
		this.major = major;
	}
	
	// Getter Setter정의 캡슐화,정보은닉,보수용이
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
}


//GraduateBookList 클래스를 만들어서 BookList 클래스를 상속받으세요. 
//GraduateBookList 클래스에는 전공(major) 필드를 추가로 받도록 해주세요.  
//GraduateBookList 클래스의 addBook(Book book) 메서드를 오버라이딩하여, 
//새로운 GraduateBook 인스턴스를 생성하고 books 리스트에 추가할 수 있도록 해주세요. 
//GraduateBookList 클래스의 생성자는 BookList 클래스의 생성자를 호출하며, 
//전공 필드의 getter/setter 메서드도 포함해야 합니다
class GraduateBookList extends BookList2{
	
	// 인스턴스 변수 정의
	private String major;
	
	// 생성자 정의
	public GraduateBookList(String major) {
		super();
		this.major = major;
	}
	
	// Getter Setter 정의 캡슐화,정보은닉,보수용이
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	// 오버라이딩 
	@Override
	public void addBook(Book2 book) {
	    GraduateBook graduateBook = new GraduateBook(book.getTitle(), book.getAuthor(), major);
	    super.addBook(graduateBook);
	}
}

class ppaa {
	public static void main(String [] args) {


        BookList2 book1 = new BookList2();
        Book2 book2 = new Book2("Java Programming" , "John Smith");
        book1.addBook(book2);
        
        // GraduateBookList의 세 번째 인자인 major를 "Computer Science"로 지정합니다.
        GraduateBookList book3 = new GraduateBookList("Computer Science");
        GraduateBook graduateBook = new GraduateBook("Advanced Java Programming", "Jane Doe", "Computer Science");
        book3.addBook(graduateBook);

        // BookList2의 모든 책을 출력합니다.
        book1.printBooks();
	}
}


