package org.Assignment04_2;

/**
 * 일반 동아리원을 표현하는 Member 클래스
 */
public class Member {
    // 학생의 학번을 저장하는 변수
    private String studentID;
    // 학생의 이름을 저장하는 변수
    private String name;

    /**
     * Member 클래스의 생성자
     * @param studentID 학생의 학번
     * @param name 학생의 이름
     */
    public Member(String studentID, String name) {
        this.studentID = studentID; // 생성자에서 학번을 초기화합니다.
        this.name = name;           // 생성자에서 이름을 초기화합니다.
    }

    /**
     * Member 정보를 문자열로 반환하는 메소드
     * @return 학번과 이름 정보를 포함하는 문자열
     */
    @Override
    public String toString() {
        // toString 메서드를 오버라이드하여 학번과 이름을 문자열로 반환합니다.
        return "Student ID: " + studentID + "\nName: " + name;
    }

    /**
     * 다른 객체와 이 Member 객체가 동일한지 판단하는 메소드
     * @param o 비교할 다른 객체
     * @return boolean 값으로 같은지 여부를 반환 (true: 같음, false: 다름)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // 자기 자신과 비교할 경우 항상 true
        if (!(o instanceof Member)) return false; // 비교할 객체가 Member 클래스의 인스턴스가 아니면 false
        Member member = (Member) o;  // 비교할 객체를 Member로 캐스팅
        // studentID가 null이 아닐 때는 equals를 사용하여 비교하고, null일 때는 객체의 studentID도 null인지 체크
        return studentID != null ? studentID.equals(member.studentID) : member.studentID == null;
    }

    /**
     * 객체의 해시코드를 반환하는 메소드
     * @return 객체의 해시코드값
     */
    @Override
    public int hashCode() {
        // studentID의 해시코드를 반환, studentID가 null일 경우 0 반환
        return studentID != null ? studentID.hashCode() : 0;
    }

    /**
     * 이름을 반환하는 메소드
     * @return 이름을 반환합니다.
     */
    public String getName() {
        return name;
    }

    public String getStudentID() {
        return studentID;
    }
}
