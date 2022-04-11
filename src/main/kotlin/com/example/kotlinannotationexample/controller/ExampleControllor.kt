package com.example.kotlinannotationexample.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import javax.validation.Valid

@Controller
class ExampleControllor {

    @GetMapping("/efg")
    fun get1(): String {
        return "hello"
    }

    @GetMapping("/abc")
    fun getMain(
        @ModelAttribute("abcBody") //引数に th:object にMappingする文字列であること
        @Validated abcBody: ABCBody,
        result: BindingResult,
        model: Model
    ): String {

        println("----------------start")

        println(abcBody.toString())

        if (result.hasErrors()) {
            for (fieldError in result.getFieldErrors()) {
                println(">>" + fieldError.toString())
            }

            for (allError in result.allErrors) {
                println(allError.toString())
                println("**" + allError.defaultMessage)
            }
        }

        return "hello"
    }
}