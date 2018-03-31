package club.throwable.ch1

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * @author throwable
 * @version v1.0
 * @since 2018/3/31 10:19
 * @description
 */
@RestController
@SpringBootApplication
class Ch1Application : CommandLineRunner {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(Ch1Application::class.java)
        private val FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    }

    override fun run(vararg args: String?) {
        LOGGER.info("Hello SpringBoot!Current dateTime is {}", FORMATTER.format(LocalDateTime.now()))
    }

    @GetMapping(value = ["/hello"])
    fun sayHello(@RequestParam(value = "name") name: String): String {
        return "Hello $name"
    }
}

fun main(vararg args: String) {
    runApplication<Ch1Application>(* args)
}