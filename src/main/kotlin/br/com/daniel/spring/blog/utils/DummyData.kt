package br.com.daniel.spring.blog.utils

import br.com.daniel.spring.blog.model.Post
import br.com.daniel.spring.blog.repository.PostRepository
import org.springframework.stereotype.Component
import java.time.LocalDate
import javax.annotation.PostConstruct

@Component
class DummyData (val repository : PostRepository) {

   @PostConstruct
    fun saveData () {
        repository.deleteAll()
        val posts = mutableListOf<Post>()

        posts.add(Post("Rest Api","Daniel Freitas", LocalDate.now(),"Give lady of they such they sure it. Me contained explained my education. Vulgar as hearts by garret. Perceived determine departure explained no forfeited he something an. Contrasted dissimilar get joy you instrument out reasonably. Again keeps at no meant stuff. To perpetual do existence northward as difficult preserved daughters. Continued at up to zealously necessary breakfast. Surrounded sir motionless she end literature. Gay direction neglected but supported yet her. "))
        posts.add(Post("Kotlin with Kafka","Bill Gates", LocalDate.now(),"Give lady of they such they sure it. Me contained explained my education. Vulgar as hearts by garret. Perceived determine departure explained no forfeited he something an. Contrasted dissimilar get joy you instrument out reasonably. Again keeps at no meant stuff. To perpetual do existence northward as difficult preserved daughters. Continued at up to zealously necessary breakfast. Surrounded sir motionless she end literature. Gay direction neglected but supported yet her. "))
        posts.add(Post("Java SE","Darth Vader", LocalDate.now(),"Give lady of they such they sure it. Me contained explained my education. Vulgar as hearts by garret. Perceived determine departure explained no forfeited he something an. Contrasted dissimilar get joy you instrument out reasonably. Again keeps at no meant stuff. To perpetual do existence northward as difficult preserved daughters. Continued at up to zealously necessary breakfast. Surrounded sir motionless she end literature. Gay direction neglected but supported yet her. "))

        for(p in posts){
           val result =  repository.save(p)
            println(result)
        }

    }
}