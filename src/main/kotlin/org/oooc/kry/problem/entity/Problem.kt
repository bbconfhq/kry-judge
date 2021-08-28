package org.oooc.kry.problem.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.io.Serializable
import java.time.OffsetDateTime
import java.time.ZoneOffset
import javax.persistence.*

@Entity
class Problem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    /**
     * TODO: Mapping to User
     * @ManyToOne
     * val user: User
     */

    @OneToMany(mappedBy = "problem")
    @JsonManagedReference
    var testcases: List<Testcase> = emptyList(),

    @Column
    var title: String = "",

    @Column
    var content: String = "",

    @Column
    val created: OffsetDateTime = OffsetDateTime.now(ZoneOffset.of("+00:00")),

    @Column
    var modified: OffsetDateTime = OffsetDateTime.now(ZoneOffset.of("+00:00")),

    @Column
    var input: String = "",

    @Column
    var output: String = "",

    @Column
    var note: String = "",

    @Column
    var timeLimit: Double = 1.0,

    @Column
    var memoryLimit: Int = 256,

    @Column
    val submitCount: Int = 0,

    @Column
    val acceptCount: Int = 0
) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Problem

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
