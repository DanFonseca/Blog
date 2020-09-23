package br.com.daniel.spring.blog.model

import com.fasterxml.jackson.annotation.JsonFormat
import org.jetbrains.annotations.NotNull
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "TB_POST")
data class Post(
        @NotNull
        val title: String,

        @NotNull
        val author: String,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        val date: LocalDate,

        @NotNull
        @Lob
        val text: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
}