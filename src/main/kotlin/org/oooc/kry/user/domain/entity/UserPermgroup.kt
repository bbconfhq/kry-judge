package org.oooc.kry.user.domain.entity

import org.oooc.kry.global.entity.BaseEntity
import java.io.Serializable
import javax.persistence.*

class UserPermgroupId(
    val user: User = User(),
    val permgroup: Permgroup = Permgroup()
) : Serializable

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
): BaseEntity()