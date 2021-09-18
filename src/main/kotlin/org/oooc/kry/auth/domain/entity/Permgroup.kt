package org.oooc.kry.auth.domain.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.io.Serializable
import javax.persistence.*

@Entity
class Permgroup (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true, length = 191)
    var name: String = "",
): Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Permgroup

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}