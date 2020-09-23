package br.com.daniel.spring.blog.service.serviceImpl

import br.com.daniel.spring.blog.model.Post
import br.com.daniel.spring.blog.repository.PostRepository
import br.com.daniel.spring.blog.service.BlogService
import org.springframework.stereotype.Service

@Service
class BlogServiceImpl (
        private val repository : PostRepository
) : BlogService {


    override fun findAll(): List<Post> {
        return repository.findAll();
    }

    override fun findById(id: Long): Post {
        return repository.findById(id).get()
    }

    override fun save(post: Post): Post {
        return repository.save(post)
    }
}