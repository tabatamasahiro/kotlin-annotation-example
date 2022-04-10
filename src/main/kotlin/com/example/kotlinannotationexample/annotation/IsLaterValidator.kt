package com.example.kotlinannotationexample.annotation

import org.springframework.beans.BeanWrapperImpl
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class IsLaterValidator : ConstraintValidator<
        IsLater,//annotaion
        Any  //相関チェックで複数パラメータを扱う場合Anyっぽい。
        > {

    lateinit var bName: String
    lateinit var cName: String
    lateinit var message: String

    override fun initialize(constraintAnnotation: IsLater?) {
        this.bName = constraintAnnotation?.b.toString()
        this.cName = constraintAnnotation?.c.toString()
        this.message = constraintAnnotation?.message.toString()
    }


    override fun isValid(value: Any?, context: ConstraintValidatorContext?): Boolean {

        println("----->>>>>")

        // null なら何もしない
        if (value == null) {
            return true
        }

        var beanWrapperImpl = BeanWrapperImpl(value)

        println("bName=$bName, cName=$cName, message=$message")

        var b = beanWrapperImpl.getPropertyValue(bName) as String
        var c = beanWrapperImpl.getPropertyValue(cName) as String

        println("b=$b, c=$c")

        context?.disableDefaultConstraintViolation()

        context?.buildConstraintViolationWithTemplate(
            message
        )?.addPropertyNode("B")?.addConstraintViolation()

        return false    //falseでMessageが表示される
    }
}