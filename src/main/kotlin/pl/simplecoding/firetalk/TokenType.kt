package pl.simplecoding.firetalk

import java.lang.UnsupportedOperationException

enum class TokenType {
    GREEN, RED;

    companion object {
        @JvmStatic
        fun fromString(value: String) = when (value) {
            "green" -> GREEN
            "red" -> RED
            else -> throw UnsupportedOperationException("There is no token like $value")
        }

    }
}
