package pl.simplecoding.firetalk

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @Author Artur Czopek
 * @Link https://simplecoding.pl/firetalk
 */

@SpringBootApplication
class FiretalkApplication

fun main(args: Array<String>) {
    runApplication<FiretalkApplication>(*args)
}
