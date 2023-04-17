package com.dhkpo.springmvc.basic.request

import com.dhkpo.springmvc.basic.HelloData
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.nio.charset.StandardCharsets
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.util.StreamUtils
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class RequestBodyJsonController {

    private val log = LoggerFactory.getLogger(this.javaClass)
    private val objectMapper = jacksonObjectMapper()

    @PostMapping("/request-body-json-v1")
    fun requestBodyJsonV1(request: HttpServletRequest, response: HttpServletResponse) {
        val inputStream = request.inputStream
        val messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8)

        log.info("messageBody={}", messageBody)
        val helloData = objectMapper.readValue<HelloData>(messageBody)
        log.info("username={}, age={}", helloData.username, helloData.age)

        response.writer.write("ok")
    }

    @ResponseBody
    @PostMapping("/request-body-json-v2")
    fun requestBodyJsonV2(@RequestBody messageBody: String): String {
        log.info("messageBody={}", messageBody)
        val helloData = objectMapper.readValue<HelloData>(messageBody)
        log.info("username={}, age={}", helloData.username, helloData.age)

        return "ok"
    }

    @ResponseBody
    @PostMapping("/request-body-json-v3")
    fun requestBodyJsonV3(@RequestBody helloData: HelloData): String {
        log.info("username={}, age={}", helloData.username, helloData.age)
        return "ok"
    }

    @ResponseBody
    @PostMapping("/request-body-json-v4")
    fun requestBodyJsonV4(@RequestBody helloData: HelloData): HelloData {
        log.info("username={}, age={}", helloData.username, helloData.age)
        return helloData
    }
}
