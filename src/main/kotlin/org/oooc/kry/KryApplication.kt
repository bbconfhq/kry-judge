package org.oooc.kry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KryApplication

fun main(args: Array<String>) {
    runApplication<KryApplication>(*args)
}
