package com.back.terraforms3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TerraformS3Application

fun main(args: Array<String>) {
    runApplication<TerraformS3Application>(*args)
}
