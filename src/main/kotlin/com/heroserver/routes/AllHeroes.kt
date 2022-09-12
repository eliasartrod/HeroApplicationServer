package com.heroserver.routes

import com.heroserver.models.ApiResponse
import com.heroserver.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException


fun Route.getAllHeroes() {
    //Injecting HeroRepository which is the implementation
    val heroRepository: HeroRepository by inject()

    get("/boruto/heroes") {
        //Asset a query parameter
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            //Require only numbers between 1-5
            require(page in 1..5)

            val apiResponse = heroRepository.getAllHeroes(page = page)
            call.respond(
                message = apiResponse,
                status = HttpStatusCode.OK
                )
        } catch (e: NumberFormatException) {
            //If Client tries to access a page not listed on "required"
            call.respond(
                message = ApiResponse(success = false, message = "Only Numbers Are Allowed!"),
                status = HttpStatusCode.BadRequest
            )
        } catch (e: IllegalArgumentException) {
            //If Client tries to access a page with no heroes
            call.respond(
                message = ApiResponse(success = false, message = "No Heroes Exists on Page!"),
                status = HttpStatusCode.NotFound
            )
        }
    }

}