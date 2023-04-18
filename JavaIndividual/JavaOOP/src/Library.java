import java.util.ArrayList;

//문제: 도서관(Library) 시스템을 구현하려고 합니다. 도서관 시스템은 책(Book)과 회원(Member)으로 구성됩니다.
//책은 제목(title), 작가(author), 출판사(publisher), 출판년도(year) 정보를 가지며,
//회원은 이름(name), 이메일(email), 연락처(콜) 정보를 가지도록 합니다.
//도서관 시스템의 핵심 기능은 다음과 같습니다.
//
//도서 추가: 새로운 책을 도서관 시스템에 추가합니다.
//도서 대출: 책을 대출하고, 해당 책의 대출 상태를 변경합니다.
//도서 반납: 대출한 책을 반납하고, 해당 책의 대출 상태를 변경합니다.
//회원 추가: 새로운 회원을 도서관 시스템에 추가합니다.
//
//위 기능을 구현하기 위해 다음과 같이 클래스를 정의하고, 해당 클래스들 간의 관계를 구현하십시오.
//
//Book 클래스: 제목(title), 작가(author), 출판사(publisher), 출판년도(year), 대출여부(isBorrowed)
//변수를 가지고 있습니다. 대출여부 변수는 boolean 타입으로, 책이 대출 가능한 경우 false, 대출 중인 경우 true 값을 가집니다.
//Book 클래스는 다음과 같은 메소드를 가지고 있습니다.
//생성자: title, author, publisher, year 정보를 받아서 인스턴스 변수를 초기화합니다.
//대출여부 변수(isBorrowed)의 초기값은 false로 설정합니다.
//isBorrowed(): 해당 책이 대출 중인지 여부를 반환합니다.
//borrow(): 해당 책을 대출 가능한 상태에서 대출 중인 상태로 변경합니다.
//returnBook(): 해당 책을 대출 중인 상태에서 대출 가능한 상태로 변경합니다.
//
//Member 클래스: 이름(name), 이메일(email), 연락처(콜) 정보를 가지고 있습니다.
//Member 클래스는 다음과 같은 메소드를 가지고 있습니다.
//
//생성자: name, email, phone 정보를 받아서 인스턴스 변수를 초기화합니다.
//
//Library 클래스: Book, Member 객체들을 관리하고, 위 기능들을 구현합니다.
//Library 클래스는 다음과 같은 메소드를 가지고 있습니다.
//
//addBook(): 도서관에 새로운 책을 추가합니다.
//borrowBook(): 도서관에 있는 책 중 대출 가능한 책을 대출합니다.
//returnBook(): 대출 중인 책을 반납합니다.
//addMember(): 도서관에 새로운 회원을 추가합니다.
// 위의 기능을 구현한 후에는 다음과 같은 상황에서 실행해볼 수 있습니다.
//새로운 책을 추가합니다.
//도서관에 있는 책 중 대출 가능한 책을 대출합니다.
//대출 중인 책을 반납합니다.
//새로운 회원을 추가합니다.


//Book 클래스: 제목(title), 작가(author), 출판사(publisher), 출판년도(year), 대출여부(isBorrowed)
class Book {
	
	// 인스턴스 변수 정의
	private String title;
	private String author;
	private String publisher;
	private int year;
	private boolean isBorrowed;
	
	// 인스턴스 변수의 초기화
	// 생성자 정의
	public Book(String title, String author, String publisher, int year) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		//대출여부 변수(isBorrowed)의 초기값은 false로 설정합니다
		this.isBorrowed = false;
	}
	
	// Getter Setter 정의 캡슐화,정보은닉,보수용이
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
	
	
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	// 이 get과 set은 이미 생성자에서 false로 초기값을 초기화했지만
	// 차후에 코드의 보수를 할수도 있으므로 set메소드도 생성해둔다
	public boolean getIsBorrowed() {
	    return isBorrowed;
	}
	public void setIsBorrowed() {
		this.isBorrowed = isBorrowed;
	}
	
	
	//borrow(): 해당 책을 대출 가능한 상태에서 대출 중인 상태로 변경합니다.
	//returnBook(): 해당 책을 대출 중인 상태에서 대출 가능한 상태로 변경합니다.
	public void borrow() {
	    isBorrowed = true;
	}

	public void returnBook() {
	    isBorrowed = false;
	}
	
}


//회원은 이름(name), 이메일(email), 연락처(콜) 정보를 가지도록 합니다.
class Member {
	
	// 인스턴스 변수 정의
	private String name;
	private String email;
	private String call;
	
	//생성자: name, email, phone 정보를 받아서 인스턴스 변수를 초기화합니다.
	//생성자 정의
	public Member(String name, String email, String call) {
		this.name = name;
		this.email = email;
		this.call = call;
	}
	
	// Getter Setter정의 캡슐화,정보은닉,보수용이
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}
	
}


public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " 도서가 추가되었습니다.");
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println(member.getName() + " 회원이 추가되었습니다.");
    }

    public void borrowBook(Member member, String bookTitle) {
        boolean isBorrowed = false;
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle) && !book.getIsBorrowed()) {
                book.borrow();
                isBorrowed = true;
                System.out.println(member.getName() + " 회원이 " + bookTitle + " 도서를 대출하였습니다.");
                break;
            }
        }
        if (!isBorrowed) {
            System.out.println(bookTitle + " 도서는 대출 중이거나 존재하지 않습니다.");
        }
    }

    public void returnBook(Member member, String bookTitle) {
        boolean isReturned = false;
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle) && book.getIsBorrowed()) {
                book.returnBook();
                isReturned = true;
                System.out.println(member.getName() + " 회원이 " + bookTitle + " 도서를 반납하였습니다.");
                break;
            }
        }
        if (!isReturned) {
            System.out.println(bookTitle + " 도서는 대출 중이 아니거나 존재하지 않습니다.");
        }
    }
}


class Pain {
    public static void main(String[] args) {
        // 새로운 Library 객체 생성
        Library library = new Library();

        // 도서 추가
        library.addBook(new Book("Java의 정석", "남궁성", "도우출판", 2016));
        library.addBook(new Book("이것이 자바다", "신용권", "한빛미디어", 2019));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "Addison-Wesley", 2018));

        // 회원 추가
        library.addMember(new Member("홍길동", "hong@example.com", "010-1234-5678"));
    }
}