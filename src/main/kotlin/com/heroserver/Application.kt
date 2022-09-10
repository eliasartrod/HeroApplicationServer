package com.heroserver

import com.heroserver.plugins.configureMonitoring
import com.heroserver.plugins.configureRouting
import com.heroserver.plugins.configureSerialization

import io.ktor.server.application.*


fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureSerialization()
    configureMonitoring()
    configureRouting()
}
