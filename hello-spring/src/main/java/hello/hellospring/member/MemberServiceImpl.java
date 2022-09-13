package hello.hellospring.member;


public class MemberServiceImpl implements MemberService{

//    <DIP OCP 위반의 예>
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //MemberRepository 에 무엇이 들어갈지 생성자를 통해서 만든다.
    //추상화에만 의존했기 때문에 MemberRepository 에 무엇이 들어가는지는 전혀 모르고 그것은 AppConfig 가 해준다.

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
