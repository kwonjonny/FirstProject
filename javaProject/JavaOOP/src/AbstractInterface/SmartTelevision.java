package AbstractInterface;

//아래 코드는 책에 있는 코딩문제입니다.
//Q. 다음 요구사항을 인터페이스를 활용해 구현하세요.
//1. SmartTelevision클래스를 생성해 다음의 기능을 제공하세요
// - 채널을 변경하는 기능의 turnOnDmb()과 turnOffDmb()를 제공합니다.
// - 인터넷 검색을 하는 search() 기능을 제공합니다.
// - 전원을 켜는 turnOn(), 전원을 끄는 turnOff() 메소드를 제공합니다.
// - Audio 인터페이스를 구현해 볼륨을 조절하는 setVolume() 메소드를 제공합니다.
//2. SmartTelevision을 생성해 인터페이스의 메소드들을 호출해 실행하는 main 메소드를 작성하세요.
// - 볼륨조절은 Audio 인터페이스의 setVolume()을 이용하세요.


interface RemoteController {
	void turnOnDmb();
	void turnOffDmb();
	void serach();
}

interface Audio {
	void setVolume(int volume);
}

interface PowerController {
	void turnOn();
	void turnOff();
}

public class SmartTelevision implements RemoteController,Audio,PowerController{

	@Override
	public void turnOn() {
		System.out.println("TV전원을 킵니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV전원을 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		System.out.println("볼륨조절" + volume + "으로 조절합니다.");
	}

	@Override
	public void turnOnDmb() {
		System.out.println("DMB를 켭니다.");
	}

	@Override
	public void turnOffDmb() {
		System.out.println("DMB를 끕니다.");
	}

	@Override
	public void serach() {
		System.out.println("인터넷을 검색합니다.");
	}
	
}

class main3 {
	public static void main(String [] args) {
		
		SmartTelevision tv = new SmartTelevision();
		tv.turnOn();
		tv.turnOff();
		
		tv.setVolume(100);
		
		tv.turnOnDmb();
		tv.serach();
		tv.turnOffDmb();
		
	}
}