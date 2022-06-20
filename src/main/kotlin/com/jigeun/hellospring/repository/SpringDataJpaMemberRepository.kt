package com.jigeun.hellospring.repository

import com.jigeun.hellospring.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface SpringDataJpaMemberRepository : JpaRepository<Member, Long>, MemberRepository {


    //JPQL select m from Member m where m.name = ?
    override fun findByName(name: String): Member?
}