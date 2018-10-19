package pl.simplecoding.firetalk

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.boot.CommandLineRunner
import org.springframework.data.repository.CrudRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "USERS")
data class User(
        @Id @Column var id: Long = 0,
        @Column var name: String = "",
        @Column @JsonIgnore var password: String = "",
        @Column @JsonIgnore var enabled: Boolean = true,
        @Column @JsonIgnore var authorityId: Long = 0,
        @Column var receivedGreen: Int = 0,
        @Column var receivedRed: Int = 0,
        @Column var toGiveGreen: Int = 10,
        @Column var toGiveRed: Int = 10
)

interface UserRepository : CrudRepository<User, Long> {

    override fun findAll(): List<User>

    fun findOneByName(name: String): User?
}


@Service
class UserInsertRunner(
        private val userRepository: UserRepository,
        private val authorityRepository: AuthorityRepository,
        private val bCryptPasswordEncoder: BCryptPasswordEncoder
): CommandLineRunner {
    override fun run(vararg args: String?) {

        (1..20).forEach {
            val id = it.toLong()
            val name = "user$id"

            val authority = Authority(id, name, "user")
            authorityRepository.save(authority)

            val user = User(
                    name = name,
                    password = bCryptPasswordEncoder.encode(name),
                    id = id,
                    authorityId = id
            )

            userRepository.save(user)
        }
    }
}
