package com.example.kotlinannotationexample.controller

import com.example.kotlinannotationexample.annotation.CanSpritBySpace
import com.example.kotlinannotationexample.annotation.IsLater
import javax.validation.constraints.AssertFalse
import javax.validation.constraints.AssertTrue
import javax.validation.constraints.Size


@IsLater(b = "B", c = "C", message = "nooooooooooosoo!!!!")
data class ABCBody(
    @CanSpritBySpace(message = "分割できない")
    @field:Size(min = 3, max = 4, message = "hoge!!!")
    val A: String?,
    val B: String?,
    val C: String?,
    val D: String?,
    val E: String?
) {

    /**
     * is から始めるメソッド名とする必要がある。
     * そうしなければ呼ばれない.
     *
     * 画面でErrorMessageを拾う時は[is]を除外し
     * 先頭小文字にした文字列がThymeleafで変数として扱うことが可能。
     * こんな感じ。
     * <div th:if="${#fields.hasErrors('goodMorning')}"
     * th:errors="*{goodMorning}"></div><br>
     */
    @AssertTrue(message = "nobiTaaaa!!!")
    fun isGoodMorning(): Boolean {

        println("#############")
        println("D=$D, E=$E")
        println("#############")

        return false
    }

}
