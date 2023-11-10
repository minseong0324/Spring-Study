package org.Assignment04_2;

import java.util.*;

public class ClubManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("일반 동아리원 수를 입력하시오: ");
        int memberCount = sc.nextInt();

        System.out.print("집행부 수를 입력하시오: ");
        int crewCount = sc.nextInt();
        System.out.println();

        List<Member> members = new ArrayList<>();

        // 사용자로부터 집행부원 정보를 입력받아 members 리스트에 추가
        for (int i = 0; i < crewCount; i++) {
            System.out.print("Student ID: ");
            String studentID = sc.next(); // 학번 입력받음
            System.out.print("Name: ");
            String name = sc.next(); // 이름 입력받음
            System.out.print("Department: ");
            String department = sc.next(); // 학과 입력받음

            // Crew 객체를 생성하고 리스트에 추가
            // 이 때 Crew 객체는 Member 타입으로 업캐스팅되어 저장됩니다.
            members.add(new Crew(studentID, name, department));
        }

        sc.close();

        // 동아리원의 중복 여부를 체크하고 중복된 동아리원의 정보 출력
        Set<Member> uniqueMembers = new HashSet<>();
        System.out.println("---중복된 동아리원 정보---");
        for (Member member : members) {
            if (!uniqueMembers.add(member)) {
                System.out.println("중복된 학번: " + member.getStudentID() + ", 이름: " + member.getName());
            }
        }
    }
}
