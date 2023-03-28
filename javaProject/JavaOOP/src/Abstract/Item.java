package Abstract;


// 물건의 이름과 가격 정보를 저장하는 Item 클래스가 있습니다. 
// 이 클래스를 상속받아 책 정보를 저장하는 Book 클래스와 음악 정보를 저장하는 
// Music 클래스를 구현하려고 합니다.
// 그리고 각 클래스의 정보를 출력하는 main 메소드를 작성하세요.
// Item클래스에는 name과 price 인스턴스변수가 있습니다.
// 또한 Item추상클래스에는 출력문 메소드가 정의되어 있습니다.

// Book클래스에는 author과 publisher 인스턴스변수가 있습니다.
// Book클래스에는 책이름, 책가격, 저자 , 출판사 등이 있습니다.

// Member클래스에는 artist와 album 인스턴스변수가 있습니다.
// Member클래스에는 음악이름, 음악가격, 아티스트, 앨범 등이 있습니다.


public abstract class Item {
	
	// 인스턴스 변수 선언
	protected String name;
	protected int price;
	
	// 생성자 선언
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	// 추상 메소드 선언
	public abstract void printinfo();
	
}


//Book클래스에는 author과 publisher 인스턴스변수가 있습니다.
class Book extends Item{
	
	// 인스턴스 변수 선언
	private String author;
	private String publisher;
	
	// 생성자 선언
	public Book(String name, int price, String author, String publisher) {
		super(name, price);
		this.author = author;
		this.publisher = publisher; 
	}
		
	// Getter Setter정의 캡슐화 정보은닉, 보수용이
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

	//Book클래스에는 책이름, 책가격, 저자 , 출판사 등이 있습니다.
	// 오버라이딩
	@Override
	public void printinfo() {
		System.out.println(name);
		System.out.println(price);
		System.out.println("저자"+author);
		System.out.println("출판사"+publisher);
	}
}


//Member클래스에는 artist와 album 인스턴스변수가 있습니다.
//Member클래스에는 음악이름, 음악가격, 아티스트, 앨범 등이 있습니다.
class Music extends Item {
	
	// 인스턴스 변수 정의
	private String artist;
	private String album;
	
	// 생성자 생성
	public Music(String name, int price, String artist, String album) {
		super(name,price);
		this.artist = artist;
		this.album = album;
	}

	
	// Getter Setter정의 캡슐화,정보은닉,보수용이
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}
	
	
	@Override
	public void printinfo() {
		System.out.println(name);
		System.out.println(price);
		System.out.println("아티스트" +artist);
		System.out.println("앨범" +album);
	}
	
}

class PPdn {
	public static void main(String [] args) {
		Item item1 = new Book("Java", 20000,"권성준","좋으니사랑해서");
		Item item2 = new Music("이름", 30000, "김선제", "앨범범범");
		
		item1.printinfo();
		item2.printinfo();
	}
}
