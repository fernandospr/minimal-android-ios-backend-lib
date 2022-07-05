package com.github.fernandospr.maiblib.sample

import com.github.fernandospr.maiblib.Example
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/web")
class WebController {

    @GetMapping("/hello")
    fun hello(@PathParam("who") who: String) = Example().hello(who)
}

@RestController
@RequestMapping("/api")
class ApiController {

    @GetMapping("/hello")
    fun hello(@PathParam("who") who: String) = ApiResponse(Example().hello(who))
}