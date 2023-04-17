package com.dhkpo.springmvc.basic.request

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class RequestParamController {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @RequestMapping("/request-param-v1")
    fun requestParamV1(request: HttpServletRequest, response: HttpServletResponse) {
        val username: String = request.getParameter("username")
        val age: Int = request.getParameter("age").toInt()

        log.info("username={}, age={}", username, age)

        response.writer.write("ok")
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    fun requestParamV2(
        @RequestParam("username") memberName: String,
        @RequestParam("age") memberAge: Int
    ): String {
        log.info("username={}, age={}", memberName, memberAge)
        return "ok"
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    fun requestParamV3(
        @RequestParam username: String,
        @RequestParam age: Int
    ): String {
        log.info("username={}, age={}", username, age)
        return "ok"
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    fun requestParamV4(
        username: String,
        age: Int
    ): String {
        log.info("username={}, age={}", username, age)
        return "ok"
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    fun requestParamRequired(
        @RequestParam username: String,
        @RequestParam age: Int?
    ): String {
        log.info("username={}, age={}", username, age)
        return "ok"
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    fun requestParamDefault(
        @RequestParam(defaultValue = "guest") username: String,
        @RequestParam(defaultValue = "-1") age: Int
    ): String {
        log.info("username={}, age={}", username, age)
        return "ok"
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    fun requestParamMap(@RequestParam paramMap: Map<String, Any>): String {
        log.info("username={}, age={}", paramMap["username"], paramMap["age"])
        return "ok"
    }
}
