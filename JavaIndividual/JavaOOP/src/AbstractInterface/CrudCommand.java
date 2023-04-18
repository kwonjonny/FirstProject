package AbstractInterface;

import java.util.Scanner;

interface CrudCommand {
	public abstract void creat();
	public abstract void read();
	public abstract void update();
	public abstract void delete();
}

class DataBase implements CrudCommand {
	
	
	@Override
	public void creat() {
		System.out.println("데이터 생성");
	}

	@Override
	public void read() {
		System.out.println("데이터 불러오기");
	}

	@Override
	public void update() {
		System.out.println("데이터 업데이트");
	}

	@Override
	public void delete() {
		System.out.println("데이터 삭제");
	}

	
}

class main123{
	public static void main(String [] args) {
		DataBase crud = new DataBase();
		crud.creat();
		crud.read();
		crud.update();
		crud.delete();		
	}
}