package com.back.terraforms3

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {
    private val s3Client: S3Client
} {
    @GetMapping("/")
    fun main(): String {
        return "Hi"
    }

    @GetMapping("/buckets")
    fun buckets(): List<String> {
        return s3Client
            .listBuckets()
            .buckets()
            .map { it.name() }
    }
}