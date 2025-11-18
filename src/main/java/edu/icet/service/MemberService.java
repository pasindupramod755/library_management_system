package edu.icet.service;

import edu.icet.model.dto.Member;
import edu.icet.repository.MemberRepository;

import java.util.List;

public class MemberService {
    MemberRepository memberRepository = new MemberRepository();

    public void addMember(Member member) {
        memberRepository.addMember(member);
    }

    public Member getMember(String id) {
        return memberRepository.getMember(id);
    }

    public void deleteMember(String id) {
        memberRepository.deleteMember(id);
    }

    public void updateMember(Member member) {
        memberRepository.updateMember(member);
    }

    public List<Member> getAll() {
        return memberRepository.getAll();
    }
}
