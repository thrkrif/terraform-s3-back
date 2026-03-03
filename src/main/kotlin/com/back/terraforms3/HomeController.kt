package com.back.terraforms3

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import software.amazon.awssdk.services.s3.S3Client

@RestController
class HomeController (
    // implementation("io.awspring.cloud:spring-cloud-aws-starter-s3:3.3.0") 를 추가했기 때문에
    // 빈이 자동으로 만들어진다. - starter가 붙어야만 빈 자동 생성
    /**
     * S3Client 를 사용하려면 로그인 필요
     * AccessToken을 yml, 환경변수, 컴퓨터에 aws 로그인 되어있는지 인증정보 (터미널에 aws configure list 입력해봐) 에서 찾는다
     * 그러니까 뭐 인증정보 있으면 자동으로 주입을 시킨다
     *
     * ⭐️ 스프링 부트에 aws AccessKey 라든가 어떤 정보도 입력하지 않았는데 주입이 되었음!!!!!
     */
    private val s3Client: S3Client
) {
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