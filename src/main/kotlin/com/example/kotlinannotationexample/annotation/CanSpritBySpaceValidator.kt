package com.example.kotlinannotationexample.annotation

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class CanSpritBySpaceValidator : ConstraintValidator<
        CanSpritBySpace, //作成したannotation
        String>         //annotationが処理するクラス
{

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {

        if (value == null) return true

        // 2分割できている事を確認している
        return value.split("_").size == 2
    }

}