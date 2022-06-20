package com.jigeun.hellospring.service

import com.jigeun.hellospring.domain.Member
import com.jigeun.hellospring.repository.MemberRepository
import com.jigeun.hellospring.repository.MemoryMemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Transactional
class MemberService(private val memberRepository: MemberRepository){

    /**
     *  회원 가입
     *  Created by Cho Jin Geun
     */
    fun join(member : Member) : Long{
        validateDuplicateMember(member)
        memberRepository.save(member)
        return member.id
    }

    fun findMembers() : ArrayList<Member> {
        return ArrayList(memberRepository.findAll())
    }

    fun findOne(id : Long) : Member?{
        return memberRepository.findById(id)
    }

    private fun validateDuplicateMember(member: Member) {
        memberRepository
            .findByName(member.name)?.let {
                throw IllegalStateException("이미 존재하는 회원입니다")
            }
    }


}