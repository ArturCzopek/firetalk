package pl.simplecoding.firetalk

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.repository.CrudRepository
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
