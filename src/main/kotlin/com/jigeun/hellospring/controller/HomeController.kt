package com.jigeun.hellospring.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class HomeController {
    @GetMapping("/")
    fun getHome() : String{
        return "home"
    }

    @GetMapping("/members/new")
    fun createForm() : String{
        return "members/createMembersForm"
    }
}