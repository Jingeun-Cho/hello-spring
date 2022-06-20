package com.jigeun.hellospring.repository

import com.jigeun.hellospring.domain.Member
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
import javax.sql.DataSource

class JdbcMemberRepository(private val dataSource: DataSource) : MemberRepository {


    override fun save(member: Member): Member {

        val sql = "insert into member(name) values(?)"
        val conn : Connection
        val preparedStatement : PreparedStatement
        var rs : ResultSet


        try {
            conn = dataSource.connection
            preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
            preparedStatement.setString(1, member.name)
            preparedStatement.executeUpdate()

            rs = preparedStatement.generatedKeys
            if(rs.next()){
                member.id = rs.getLong(1)
            }
            else{
                throw SQLException("id 조회 실패")
            }
            return member
        }
        catch (e: Exception){
            throw java.lang.IllegalStateException(e)
        }
        finally {

        }

    }

    override fun findById(id: Long): Member? {
        TODO("Not yet implemented")
    }

    override fun findByName(name: String): Member? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Member> {
        TODO("Not yet implemented")
    }
}