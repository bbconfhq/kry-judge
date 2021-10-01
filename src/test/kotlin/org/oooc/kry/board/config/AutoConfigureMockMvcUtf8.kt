package org.oooc.kry.board.config

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.web.filter.CharacterEncodingFilter

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@AutoConfigureMockMvc
@Import(AutoConfigureMockMvcUtf8.Config::class)
annotation class AutoConfigureMockMvcUtf8 {
    class Config {
        @Bean
        fun characterEncodingFilter(): CharacterEncodingFilter = CharacterEncodingFilter("UTF-8", true)
    }
}