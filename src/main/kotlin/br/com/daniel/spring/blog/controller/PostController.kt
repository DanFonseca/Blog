package br.com.daniel.spring.blog.controller

import br.com.daniel.spring.blog.model.Post
import br.com.daniel.spring.blog.service.BlogService
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.servlet.view.RedirectView
import java.time.LocalDate
import javax.validation.Valid

@RestController
@RequestMapping("/posts")
class PostController(val blogService: BlogService) {

    @GetMapping()
    fun getPosts(): ModelAndView {
        val mv = ModelAndView("posts")
        val posts = blogService.findAll()
        return mv.addObject("posts", posts)
    }

    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: Long): ModelAndView {
        val post = blogService.findById(id)

        val mv = ModelAndView("post")
        return mv.addObject("post", post)
    }

    @GetMapping("/newpost")
    fun getPostForm(): ModelAndView {
        return ModelAndView("postForm")
    }

    @PostMapping("/newpost")
    fun savePost(@Valid post: Post, result: BindingResult, attributes: RedirectAttributes): RedirectView {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagemDeErro", "Verifique se os campos obrigatórios foram preenchidos!");
            return RedirectView("/posts/newpost")
        }
        post.date = LocalDate.now()
        blogService.save(post);
        return RedirectView("/posts");
    }
}