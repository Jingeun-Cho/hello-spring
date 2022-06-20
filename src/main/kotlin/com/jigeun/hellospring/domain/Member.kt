package com.jigeun.hellospring.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.*

@Entity
data class Member(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = 0,

//    @Column(name="name")
    var name : String = ""
)
