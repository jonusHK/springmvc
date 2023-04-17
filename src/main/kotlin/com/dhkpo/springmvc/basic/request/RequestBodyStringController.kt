package com.dhkpo.springmvc.basic.request

import jakarta.servlet.ServletInputStream
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.io.IOException
import java.io.InputStream
import java.io.Writer
import java.nio.charset.StandardCharsets
import org.slf4j.LoggerFactory
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Controller
import org.springframework.util.StreamUtils
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import kotlin.jvm.Throws

@Controller
class RequestBodyStringController {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/request-body-string-v1")
    fun requestBodyString(request: HttpServletRequest, response: HttpServletResponse) {
        val inputStream = request.inputStream
        val messageBody: String = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8)
        log.info("messageBody={}", messageBody)
        response.writer.write("ok")
    }

    @PostMapping("/request-body-string-v2")
    fun requestBodyStringV2(inputStream: InputStream, responseWriter: Writer) {
        val messageBody: String = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8)
        log.info("messageBody={}", messageBody)
        responseWriter.write("ok")
    }

    @PostMapping("/request-body-string-v3")
    @Throws(IOException::class)
    fun requestBodyStringV3(httpEntity: HttpEntity<String>): HttpEntity<String> {
        val messageBody: String? = httpEntity.body
        log.info("messageBody={}", messageBody)
        return HttpEntity("ok")
    }

    @ResponseBody
    @PostMapping("/request-body-string-v4")
    @Throws(IOException::class)
    fun requestBodyStringV4(@RequestBody messageBody: String): String {
        log.info("messageBody={}", messageBody)
        return "ok"
    }
}
