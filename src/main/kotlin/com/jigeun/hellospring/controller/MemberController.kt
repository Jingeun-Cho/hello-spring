package com.jigeun.hellospring.controller

import com.jigeun.hellospring.domain.Member
import com.jigeun.hellospring.model.MemberForm
import com.jigeun.hellospring.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class MemberController(memberService: MemberService)  {
    private final var memberService : MemberService = memberService

    @PostMapping("/members/new")
    fun create(form : MemberForm) : String{
        val member : Member = Member()
        member.name = form.name
        memberService.join(member)

        return "redirect:/"
    }

    @GetMapping("/members")

    fun list(model : Model) : String{
        val members = memberService.findMembers()
        model.addAttribute("members", members)
        return "members/memberList"
    }
}