package com.heroserver.plugins

import com.heroserver.routes.getAllHeroes
import com.heroserver.routes.root
import com.heroserver.routes.searchHeroes
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import javax.naming.AuthenticationException

fun Application.configureRouting() {
    routing {
        root()
        getAllHeroes()
        searchHeroes()

        static ("/images"){
            resources("images")
        }
    }
}
