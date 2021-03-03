package xyz.mooka.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MookaApplication

fun main(args: Array<String>) {
    runApplication<MookaApplication>(*args)
}
