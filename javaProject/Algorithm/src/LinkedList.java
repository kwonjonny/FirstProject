// 문제: 정수를 저장하는 링크드리스트를 구현하세요. 
// 링크드리스트는 다음과 같은 연산을 지원해야 합니다.

//void add(int value): 링크드리스트의 끝에 정수 value를 추가합니다.

//int get(int index): 링크드리스트의 index번째 위치에 있는 정수를 반환합니다. 
//인덱스는 0부터 시작합니다. 만약 인덱스가 유효하지 않으면 -1을 반환합니다.

//void remove(int index): 링크드리스트의 index번째 위치에 있는 정수를 삭제합니다. 
//만약 인덱스가 유효하지 않으면 아무런 작업도 수행하지 않습니다.

class Node {
	 int data;	// 링크드리스트의 노드를 표현, 정수값을 저장하는 data
	 Node next; // data필드와 노드를 가리키는 next 필드 
	    
	 // Node라는 생성자 안에 data라는 매개변수 
	 // next는 초기화 해주지 않는다 
	 public Node(int data) {
	     this.data = data;
	     this.next = null;
	 }
}

// 다음으로 LinkedList 클래스를 작성해야 합니다. 
// 이 클래스는 링크드리스트를 표현하며, Node 객체들의 연결리스트 형태로 구현됩니다.
// 또한 위에서 언급한 세 가지 연산을 지원해야 합니다.
public class LinkedList{
	
	// head라는 인스턴스 변수 
    Node head;
    
    // 생성자 head의 인스턴스 변수는 초기화 값 없음 
    public LinkedList() {
        this.head = null;
    }
  
    // int value 라고 생성 하는 이유는 
	// 링크드 리스트에 새로운 값을 추가할 때마다
	// 새로운 노드 객체가 생성되어 링크드 리스트의 끝에 추가되기 때문
	// 새로운 노드의 객체를 생성하지 않고 기존의 노드 객체를 사용하게 되면 
	// 링크들 리스트의 마지막 노드와 새로 추가되는 값을 연결할수 없어 구조가 망가진다
	// 따라서 링크드 리스트에 새로운 값을 추가할때마다 새로운 노드 객체를 생성해야 한다 
	// 이 객체는 새로운 값을 저정하고 이전의 마지막 노드와 새로운 노드의 연결을 도와준다 
    // if 연결리스트가 비어있는경우 head가 null값으로 head 를 새로운 newNode로 설정하는 역할
    // 이 조건문은 새로운 노드를 리스트의 첫 번째 노드로 추가하는 경우이다
    // else head가 null이 아니라면(연결리스트가 비어있지 않다면) 현재 노드를 가르키는 cur변수에 
    // head를 할당한다 그리고 while을 이용해 cur.next가 null이 아닐때까지 (cur이 마지막 노드를 가르키게
    // 될 때까지) cur을 cur.next로 이동시키며 마지막 노드를 찾는다 마지막 노드를 찾으면 그 다음에 노드를
    // 새로운 노드에 연결하기 위해 cur.next에 newNdoe를 할당 
    public void add(int value) {	
        Node newNode = new Node(value);
        
        if (head == null) {
            head = newNode;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }
   
    
    public int get(int index) {
        if (head == null) {
            return -1;
        }
        
        Node cur = head;
        int curIndex = 0;
        while (cur != null) {
            if (curIndex == index) {
                return cur.data;
            }
            cur = cur.next;
            curIndex++;
        }
        
        return -1;
    }
    
    
    public void remove(int index) {
        if (head == null) {
            return;
        }
        
        if (index == 0) {
            head = head.next;
        } else {
            Node cur = head;
            int curIndex = 0;
            while (cur.next != null && curIndex < index - 1) {
                cur = cur.next;
                curIndex++;
            }
            
            if (cur.next != null) {
                cur.next = cur.next.next;
            }
        }
    }

    	
    public void printList() {
    	if (head == null) {
    		System.out.println("Empty list");
    	} else {
    		Node cur = head;
    		while (cur != null) {
    			System.out.print(cur.data + " -> ");
    			cur = cur.next;
    		}
    		System.out.println("null");
    	}
    }
}


class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("index 0: " + list.get(0)); // 1
        System.out.println("index 2: " + list.get(2)); // 3
        System.out.println("index 6: " + list.get(6)); // -1

        list.remove(2);
        list.remove(3);

        list.printList(); // 1 -> 2 -> 4 -> null
    }
}
