package com.dhkpo.springmvc.basic.request

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.util.Locale
import org.slf4j.LoggerFactory
import org.springframework.http.HttpMethod
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RequestHeaderController {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @RequestMapping("/headers")
    fun headers(
        request: HttpServletRequest,
        response: HttpServletResponse,
        httpMethod: HttpMethod,
        locale: Locale,
        @RequestHeader headerMap: LinkedMultiValueMap<String, String>,
        @RequestHeader("host") host: String,
        @CookieValue(value = "myCookie", required = false) cookie: String?,
    ): String {
        log.info("request={}", request)
        log.info("response={}", response)
        log.info("httpMethod={}", httpMethod)
        log.info("locale={}", locale)
        log.info("headerMap={}", headerMap)
        log.info("header host={}", host)
        log.info("myCookie={}", cookie)

        return "ok"
    }
}
