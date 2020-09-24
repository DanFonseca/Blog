package br.com.daniel.spring.blog.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "TB_POST")
data class Post(

        @field:NotBlank
        val title: String,

        @field:NotBlank
        val author: String,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        var date: LocalDate?,

        @Lob
        @field:NotBlank
        val text: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
}