package org.oooc.kry.user.web.exception

import org.oooc.kry.global.KryException
import org.springframework.context.MessageSourceResolvable

class UserNotFoundException(val name: String): KryException("User(name: $name) not found.") {
    override fun getCodes(): Array<out String> = arrayOf("error.UserNotFound")
    override fun getArguments(): Array<out Any> = arrayOf(name)
}
