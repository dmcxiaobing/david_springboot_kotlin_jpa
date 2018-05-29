package com.david.web.controller

import com.david.utils.FastJsonUtil
import com.david.utils.SessionUtil
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
/**
 * @author ：David
 * @weibo ：http://weibo.com/mcxiaobing
 * @github: https://github.com/QQ986945193
 */
/**
 * 简单测试使用的方法。
 */
@RestController
@RequestMapping("/hello")
class HelloController {


    @RequestMapping("/hello")
    fun hello(): String {
        SessionUtil.setSessionAttribute("hello","hello session")
        System.out.print(SessionUtil.getSessionAttribute("hello"))
        return "hello kotlin"
    }


}