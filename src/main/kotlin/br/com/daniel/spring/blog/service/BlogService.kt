package br.com.daniel.spring.blog.service

import br.com.daniel.spring.blog.model.Post

interface BlogService {
    fun findAll(): List<Post>
    fun findById(id: Long): Post
    fun save (post: Post) : Post
}