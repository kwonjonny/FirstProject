import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        MemberRepository memberRepository = new MemberRepositoryImpl();
        MemberService memberService = new MemberServiceImpl(memberRepository);
        MemberController memberController = new MemberController(memberService);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===회원 관리 프로그램===");
            System.out.println("1. 회원 등록");
            System.out.println("2. 회원 삭제");
            System.out.println("3. 회원 목록 조회");
            System.out.println("4. 종료");
            System.out.print("선택> ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("등록할 회원 id 입력: ");
                    int id = scanner.nextInt();
                    System.out.print("등록할 회원 이름 입력: ");
                    String name = scanner.next();
                    memberController.addMember(id, name);
                    break;
                case 2:
                    System.out.print("삭제할 회원 id 입력: ");
                    int deleteId = scanner.nextInt();
                    memberController.removeMember(deleteId);
                    break;
                case 3:
                    System.out.println("회원 목록 조회");
                    for (Member member : memberController.getMembers()) {
                        System.out.println(member.getId() + ": " + member.getName());
                    }
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }
}
