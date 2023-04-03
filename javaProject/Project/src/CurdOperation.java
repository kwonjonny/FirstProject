
public interface CurdOperation {
	
	 public void create(Contact newContact);
	 public void searchcontacts(String keyword);
	 public void update(int index, String name, String phoneNumber, String email, String address, String birthday, String group);
	 
	 // smartPhone클래스의 delte 메소드를 오버라이딩 할때는 
	 // public void delte(int index); 로 선언해야 오류가 안난다 ..
	 public void delete(String index);
	 
		 
}
