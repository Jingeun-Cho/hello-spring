package com.jigeun.hellospring.service

import com.jigeun.hellospring.domain.Member
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
internal class MemberServiceIntegrationTest( @Autowired private val memberService: MemberService ) {

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