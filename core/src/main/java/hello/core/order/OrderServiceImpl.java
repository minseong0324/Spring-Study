package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository; //MemberRepository에서 회원 찾아야 하니까 필요
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);    //이렇게 해서 주문 생성 요청이 오면 회원 정보를 먼저 조회를 하고 그 다음에 할인정책에다가 회원을 넘기는 것이다.
        int discountPrice = discountPolicy.discount(member, itemPrice); // 그 다음에 itemPrice를 넘겼다. 최종적으로 할인된 가격을 받았다.

        return new Order(memberId, itemName, itemPrice, discountPrice); //최종 생성된 주문을 반환한다.
        //이게 설계가 잘 된 이유는 지금 OrderService 입장에서는 할인에 대해서 모른다.
        // 할인에 대한 거는 DiscountPolicy가 알아서 한다.
        // 이게 단일 책임 원칙을 잘 지킨 것이다.
        // 앞으로 할인에 대한 변경이 필요하면 할인 쪽만 고치면 된다.
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
