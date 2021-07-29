package org.oooc.kry.global.exception

import org.springframework.context.MessageSourceResolvable

abstract class KryException : RuntimeException, MessageSourceResolvable {
    constructor(message: String) : super(message) { }
    constructor(message: String, cause: Throwable) : super(message, cause) { }

    override fun getArguments(): Array<out Any>? = arrayOf()
    override fun getDefaultMessage(): String?  = message
}