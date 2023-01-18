package com.example.blog

import com.example.blog.api.ArticleRepository
import com.example.blog.api.UserRepository
import com.example.blog.model.Article
import com.example.blog.model.User
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(userRepository: UserRepository, articleRepository: ArticleRepository) = ApplicationRunner {
        val johnDoe = userRepository.save(User("jdoe", "John", "Doe"))
        articleRepository.save(
            Article(
                title = "Lorem ipsum",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = johnDoe
            )
        )
    }

}