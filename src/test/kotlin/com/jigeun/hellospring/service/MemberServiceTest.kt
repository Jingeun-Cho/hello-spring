package com.jigeun.hellospring.service

import com.jigeun.hellospring.domain.Member
import com.jigeun.hellospring.repository.MemberRepository
import com.jigeun.hellospring.repository.MemoryMemberRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.fail

internal class MemberServiceTest {

    private lateinit var memberRepository : MemoryMemberRepository
    private lateinit var memberService : MemberService


    @BeforeEach
    fun beforeEach(){
        memberRepository = MemoryMemberRepository()
        memberService = MemberService(memberRepository)
    }
    @AfterEach
    fun afterEach(){
        memberRepository.clearStore()
    }

    @Test
    fun join() {
        //Given
        val member = Member()
        member.name = "spring"
        //When
        val saveId : Long = memberService.join(member)
        //Then
        val result = memberService.findOne(member.id)
        Assertions.assertThat(member.name).isEqualTo(result?.name)


    }

    @Test
    fun duplicateTest(){
        //Given
        val member1 = Member()
        member1.name = "spring"
        val member2 = Member()
        member2.name = "spring"
        //When
        val join = memberService.join(member1)
//        try {
//            memberService.join(member2)
//        }
//        catch (error : IllegalStateException){
//            println(error.message)
//        }
        val message =  assertThrows<IllegalStateException>{
            memberService.join(member2)
        }

        //Then
        println(message)
//        val result = memberService.findOne(member1.id)
//        Assertions.assertThat(member.name).isEqualTo(result?.name)
    }

    @Test
    fun findMembers() {
    }

    @Test
    fun findOne() {
    }
}