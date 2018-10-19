package pl.simplecoding.firetalk

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
        @Column var name: String = "Name",
        @Column var authority: String = "Authority"
)