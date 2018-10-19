package pl.simplecoding.firetalk

import org.springframework.data.repository.CrudRepository
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * @Author Artur Czopek
 * @Link https://simplecoding.pl/firetalk
 */

@Entity
@Table(name = "Authorities")
data class Authority(
        @Id @Column var authorityId: Long = 0,
        @Column(name = "username") var name: String = "Name",
        @Column var authority: String = "Authority"
)

interface AuthorityRepository: CrudRepository<Authority, Long>
