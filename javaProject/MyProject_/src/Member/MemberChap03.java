package Member;

import java.time.LocalDate; // 현재 날짜
import java.util.Scanner;

public class MemberChap03 {

    private String name;                // 이름
    private int birthYear;              // 생년월일
    private int age;                    // 나이
    private boolean hasInsurance;       // 보험가입 여부
    private boolean hasRecentCheckup;   // 최근 검강검진 여부

    // Getter Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
        setAge(LocalDate.now().getYear() - birthYear + 1);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    public boolean getHasRecentCheckup() {
        return hasRecentCheckup;
    }

    public void setHasRecentCheckup(boolean hasRecentCheckup) {
        this.hasRecentCheckup = hasRecentCheckup;
    }

    public MemberChap03(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        setAge(LocalDate.now().getYear() - birthYear + 1);
    }

    public void checkVaccination() {
        if (age < 15 || age >= 65) {
            System.out.println("무료 예방 접종이 가능합니다.");
        } else {
            System.out.println("무료 접종 대상이 아닙니다.");
        }
    }

    public void checkHealthExam() {
        if (age >= 20) {
            int currentYear = LocalDate.now().getYear();
            if ((currentYear - birthYear) % 2 == 0) {
                System.out.println("건강검진 대상입니다.");
                if (age >= 40) {
                    System.out.println("암 검사도 무료로 받을 수 있습니다.");
                }
            } else {
                System.out.println("검진 대상이 아닙니다.");
            }
        } else {
            System.out.println("성인이 아니므로 검진 대상이 아닙니다.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();

        System.out.print("출생년도를 입력하세요(8자): ");
        int birthYear = scanner.nextInt();

        System.out.print("나이를 입력하세요: ");
        int age = scanner.nextInt();

        MemberChap03 member = new MemberChap03(name, birthYear);
        member.setAge(age);
        member.setHasInsurance(true);
        member.setHasRecentCheckup(true);

        member.checkVaccination();
        member.checkHealthExam();
    }
}