package com.dhkpo.springmvc.basic.requestmapping

import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MappingController {

    private val log = LoggerFactory.getLogger(this.javaClass)

    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId") String userId -> @PathVariable userId
     */
    @GetMapping("/mapping/{userId}")
    fun mappingPath(@PathVariable("userId") data: String): String {
        log.info("mappingPath userId = {}", data)
        return "ok"
    }

    @GetMapping("/mapping-param", params = ["mode=debug"])
    fun mappingParam(): String {
        log.info("mappingParam")
        return "ok"
    }

    @GetMapping("/mapping-header", headers = ["mode=debug"])
    fun mappingHeader(): String {
        log.info("mappingHeader")
        return "ok"
    }

    @PostMapping("/mapping-consume", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun mappingConsumes(): String {
        log.info("mappingConsumes")
        return "ok"
    }

    @PostMapping("/mapping-produce", produces = [MediaType.TEXT_PLAIN_VALUE])
    fun mappingProduces(): String {
        log.info("mappingProduces")
        return "ok"
    }
}
