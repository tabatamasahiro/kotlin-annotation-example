package com.example.kotlinannotationexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinAnnotationExampleApplication

fun main(args: Array<String>) {
    runApplication<KotlinAnnotationExampleApplication>(*args)
}
