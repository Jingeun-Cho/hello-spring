package com.jigeun.hellospring.repository

import com.jigeun.hellospring.domain.Member
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import javax.sql.DataSource

class JdbcTemplateMemberRepository(private val dataSource : DataSource ) : MemberRepository  {

    private final val jdbcTemplate = JdbcTemplate(this.dataSource)


    override fun save(member: Member): Member {
        val jdbcInsert = SimpleJdbcInsert(jdbcTemplate)
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id")
        val parameters = hashMapOf<String,  Any>()
        parameters["name"] = member.name
        val key = jdbcInsert.executeAndReturnKey(MapSqlParameterSource(parameters))
        member.id = key.toLong()
        return member
    }

    override fun findById(id: Long): Member? {
        return jdbcTemplate.query ("select * from member where id = ?", rowMapper(), id).singleOrNull()
    }

    override fun findByName(name: String): Member? {
        return jdbcTemplate.query ("select * from member where name = ?", rowMapper(), name).singleOrNull()
    }

    override fun findAll(): List<Member> {
        return jdbcTemplate.query ("select * form member", rowMapper())
    }

    private fun rowMapper() : RowMapper<Member>{
        return RowMapper { rs, _ ->
            val member = Member()
            member.id = rs.getLong("id")
            member.name = rs.getString("name")
            return@RowMapper member
        }
    }
}