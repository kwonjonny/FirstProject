package Member;

public class Person {
	
	 private String name;
	    private String phoneNumber;
	    private String residentNumber;

	    public Person(String name, String phoneNumber, String residentNumber) {
	        this.name = name;
	        this.phoneNumber = phoneNumber;
	        this.residentNumber = residentNumber;
	        // this.name = name 에서 this.name은 인스턴스 변수 name 을 가르키고 
	        // name은 생성자의 매개변수 name을 가르킨다 생성자의 매개변수 name으로 전달된 값을
	        // 인스턴수 변수 name에 대입하기 위해 this의 키워드 사용
	        // 즉 생성자의 매개 변수는 public Person(String name)
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    public String getResidentNumber() {
	        return residentNumber;
	    }

	    public void setResidentNumber(String residentNumber) {
	        this.residentNumber = residentNumber;
	    }

	    public void print() {
	        System.out.println("Name: " + name);
	        System.out.println("Phone number: " + phoneNumber);
	        System.out.println("Resident number: " + residentNumber);
	    }
}

	class name {
    public static void main(String[] args) {
        Person person = new Person("권성준", "010-1234-5678", "950101-1234567");
        person.print();
    }
}
