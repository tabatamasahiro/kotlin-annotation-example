package com.example.kotlinannotationexample.controller

import com.example.kotlinannotationexample.annotation.CanSpritBySpace
import com.example.kotlinannotationexample.annotation.IsLater
import javax.validation.constraints.Size


@IsLater(b = "B", c = "C", message = "nooooooooooosoo!!!!")
data class ABCBody(
    @CanSpritBySpace(message = "分割できない")
//    @Size(min=3, max=6, message = "hoge!!!")
    val A: String?,
    val B: String?,
    val C: String?
)
