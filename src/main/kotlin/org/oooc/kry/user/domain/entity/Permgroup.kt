package org.oooc.kry.user.domain.entity

import javax.persistence.*

@Entity
class Permgroup (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true, length = 191)
    val name: String = "",


    @OneToMany(mappedBy = "permgroup")
    val userPermgroups: List<UserPermgroup> = emptyList(),
)