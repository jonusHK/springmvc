package com.dhkpo.springmvc.basic.response

import com.dhkpo.springmvc.basic.HelloData
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

//@Controller
//@ResponseBody
@RestController
class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    fun responseBodyV1(response: HttpServletResponse) {
        response.writer.write("ok")
    }

    @GetMapping("/response-body-string-v2")
    fun responseBodyV2(): ResponseEntity<String> {
        return ResponseEntity("ok", HttpStatus.OK)
    }

//    @ResponseBody
    @GetMapping("/response-body-string-v3")
    fun responseBodyV3(): String {
        return "ok"
    }

//    @ResponseBody
    @GetMapping("/response-body-string-v4")
    fun responseBodyV4(): ResponseEntity<HelloData> {
        val helloData = HelloData(username = "userA", age = 20)
        return ResponseEntity(helloData, HttpStatus.OK)
    }

    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
    @GetMapping("/response-body-string-v5")
    fun responseBodyV5(): HelloData {
        return HelloData(username = "userA", age = 20)
    }
}
