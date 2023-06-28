package jpamvcexam.mainview;

import jpamvcexam.controller.StudentController;

import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentController sc = new StudentController();

        sys: while (true) {//라벨달기
            System.out.println("처리하려는 기능을 선택하세요.");
            System.out.println("1. 학생 정보 출력");
            System.out.println("2. 학생 정보 입력");
            System.out.println("3. 학생 정보 삭제");
            System.out.println("4. 학생 정보 수정");
            System.out.println("5. 학생 점수 확인");
            System.out.println("6. 종료");
            System.out.println("입력 : ");

            int num = scanner.nextInt();
            scanner.nextLine();

            switch (num) {
                case 1:
                    sc.printAll();
                    break;
                case 2:
                    System.out.println("등록할 학생의 이름을 입력하세요.");
                    String name = scanner.nextLine();
                    System.out.println("학생의 점수를 입력하세요.");
                    int score = Integer.parseInt(scanner.nextLine());
                    sc.insert(name, score);
                    break;
                case 3:
                    System.out.println("삭제하고 싶은 학생의 이름을 입력하세요.");
                    String deleteName = scanner.nextLine();
                    sc.delete(deleteName);
                    break;
                case 4 :
                    System.out.println("수정하려는 학생의 이름을 입력하세요.");
                    String updateName = scanner.nextLine();
                    System.out.println("점수를 다시 입력해주세요");
                    int updateScore = Integer.parseInt(scanner.nextLine());
                    sc.update(updateName,updateScore);
                    break;
                case 5:
                    System.out.println("점수 확인하고 싶은 학생을 입력하세요.");
                    String searchName = scanner.nextLine();

                    sc.printScore(searchName);
                    break;
                case 6:
                    break sys;
            }
        }
        sc.close();
        scanner.close();
    }
}