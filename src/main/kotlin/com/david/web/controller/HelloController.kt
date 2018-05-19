package com.david.web.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/hello")
class HelloController {


    @RequestMapping("/hello")
    fun hello(): String {
        return "hello kotlin"
    }


}