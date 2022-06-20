package com.jigeun.hellospring.repository

import com.jigeun.hellospring.domain.Member
import org.springframework.stereotype.Repository

class MemoryMemberRepository : MemberRepository {

    private val store : MutableMap<Long, Member> = mutableMapOf()
    private var sequence : Long = 0L

    fun clearStore(){
        store.clear()
    }

    override fun save(member: Member): Member {
        member.id = ++sequence
        store[member.id] = member
        return member
    }

    override fun findById(id: Long): Member? {
        return store[id]
    }

    override fun findByName(name: String): Member? {

        return store.values.firstOrNull{ member -> member.name == name }
    }

    override fun findAll(): List<Member> {
        return ArrayList<Member>(store.values)
    }

}