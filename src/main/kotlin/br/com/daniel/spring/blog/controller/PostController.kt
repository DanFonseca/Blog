package br.com.daniel.spring.blog.controller

import br.com.daniel.spring.blog.service.BlogService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
@RequestMapping("/posts")
class PostController (val blogService: BlogService) {

    @GetMapping()
    fun getPosts () : ModelAndView {
        val mv = ModelAndView("posts")
        val posts = blogService.findAll()
        return mv.addObject("posts", posts)
    }

    @GetMapping("/{id}")
    fun getPostById (@PathVariable id : Long) : ModelAndView {
        val post = blogService.findById(id)

        val mv = ModelAndView("post")
        return mv.addObject("post", post)
    }
}