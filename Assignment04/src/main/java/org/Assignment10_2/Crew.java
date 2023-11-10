package org.Assignment04_2;

/**
 * 집행부를 표현하는 Crew 클래스
 * Member 클래스를 상속받아 구현
 */
public class Crew extends Member {
    // 집행부의 담당 분야 (예: president, secretary 등)을 저장하는 변수
    private String department;

    /**
     * Crew 클래스의 생성자
     * @param studentID 학생의 학번
     * @param name 학생의 이름
     * @param department 학과
     */
    public Crew(String studentID, String name, String department) {
        // 부모 클래스인 Member의 생성자를 호출
        super(studentID, name);
        this.department = department;
    }

    /**
     * Crew 정보와 Member 정보를 함께 문자열로 반환하는 메소드
     * @return 학번, 이름, 학과 정보를 포함하는 문자열
     */
    @Override
    public String toString() {
        return super.toString() + "\nDepartment: " + department;
    }
}

