package com.jigeun.hellospring

import com.jigeun.hellospring.aop.TimeTraceAop
import com.jigeun.hellospring.repository.*
import com.jigeun.hellospring.service.MemberService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.sql.DataSource

@Configuration
class SpringConfig(
//                    private val dataSource: DataSource,
//                    @PersistenceContext private val em : EntityManager,
                    private val memberRepository : MemberRepository
                    ) {

//    @Bean
//    fun timeTraceAop() : TimeTraceAop{
//        return TimeTraceAop()
//    }

    @Bean
    fun memberService() : MemberService{
        return MemberService(memberRepository)
    }

    @Bean
    fun memberRepository() : MemberRepository {
//        return MemoryMemberRepository()
//        return JdbcMemberRepository(dataSource)
//        return JdbcTemplateMemberRepository(dataSource)
//        return JpaMemberRepository(em)
        return memberRepository //Jpa Repository
    }


}