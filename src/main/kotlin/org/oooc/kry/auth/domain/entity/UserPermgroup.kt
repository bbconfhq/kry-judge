package org.oooc.kry.auth.domain.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import org.oooc.kry.user.domain.entity.User
import java.io.Serializable
import javax.persistence.*

@Entity
@IdClass(UserPermgroupId::class)
class UserPermgroup (
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User = User(),

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permgroup_id")
    val permgroup: Permgroup = Permgroup()
): Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserPermgroup

        if (user != other.user) return false
        if (permgroup!= other.permgroup) return false

        return true
    }

    override fun hashCode(): Int {
        var result = user.hashCode()
        result = 31 * result + permgroup.hashCode()
        return result
    }
}

class UserPermgroupId(
    val user: User = User(),
    val permgroup: Permgroup = Permgroup()
) : Serializable

