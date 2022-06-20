package com.jigeun.hellospring.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class WebController {
    @GetMapping("/hello") // Static content
    fun hello(model : Model) : String {
         model.addAttribute("data", "hello!!")
        return "hello" //View name mapping
    }
    @GetMapping("/hello-mvc") // Template engine
    fun helloMvc(@RequestParam(value = "name" ,required = false) name: String?, model : Model): String {
        model.addAttribute("name", name)
        return "hello-template"

    }

    @GetMapping("/hello-string")
    @ResponseBody //API
    fun helloString(@RequestParam("name") name : String): String {

        return "hello $name" //hello
    }
    @GetMapping("/hello-api")
    @ResponseBody //Not use View template
    fun helloApi(@RequestParam("name") name : String) : Hello{
        val hello = Hello(name)
        return  hello
    }



    data class Hello (var name : String){

    }
}