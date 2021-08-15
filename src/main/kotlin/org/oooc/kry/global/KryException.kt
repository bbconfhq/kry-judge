package org.oooc.kry.global

import org.springframework.context.MessageSourceResolvable

abstract class KryException: RuntimeException, MessageSourceResolvable {
    constructor() : super()
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
    constructor(cause: Throwable) : super(cause)

    override fun getArguments(): Array<out Any>? = arrayOf()
    override fun getDefaultMessage(): String?  = message
}

class ResourceNotFoundException(val text: String = "Resource not found"): KryException(text) {
    override fun getCodes(): Array<out String> = arrayOf("error.ResourceNotFound")
//    override fun getArguments(): Array<out Any> = arrayOf()
}