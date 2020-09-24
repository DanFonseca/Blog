package br.com.daniel.spring.blog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@EnableWebMvc
class BlogApplication

fun main(args: Array<String>) {
	runApplication<BlogApplication>(*args)
}
