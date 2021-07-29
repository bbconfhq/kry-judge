package org.oooc.kry.user.domain.entity

import org.oooc.kry.global.entity.BaseEntity
import java.time.OffsetDateTime
import java.time.ZoneOffset
import javax.persistence.*

@Entity
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true, length = 30)
    val name: String = "",

    @Column(nullable = false, length = 512)
    val pw: String = "",

    @Column(nullable = false, unique= true, length = 30)
    val nick: String = "",

    @Column(nullable = false, unique= true, length = 191)
    val email: String = "",

    @Column(nullable = false, length = 512)
    val bio: String = "",

    @Column(nullable = false)
    val created: OffsetDateTime = OffsetDateTime.now(ZoneOffset.of("+09:00")),

    @OneToMany(mappedBy = "user")
    val userPermgroups: List<UserPermgroup> = emptyList(),

    @OneToMany(mappedBy = "user")
    val userPermissions: List<UserPermission> = emptyList(),

    // TODO: 2021/07/10 join problem entity
//     @OneToMany(mappedBy = "user")
//     val problems: List<Problem> = emptyList(),

    // TODO: 2021/07/10 join article entity
//    @OneToMany(mappedBy = "user")
//    val articles: List<Article> = emptyList(),

    // TODO: 2021/07/10 join article_vote entity
//    @OneToMany(mappedBy = "user")
//    val articleVotes: List<ArticleVote> = emptyList(),

    // TODO: 2021/07/10 join comment entity
//    @OneToMany(mappedBy = "user")
//    val comments: List<Comment> = emptyList(),

    // TODO: 2021/07/10 join comment vote entity
//    @OneToMany(mappedBy = "user")
//    val commentVotes: List<CommentVote> = emptyList(),
): BaseEntity()