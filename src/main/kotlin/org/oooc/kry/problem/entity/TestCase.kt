package org.oooc.kry.problem.entity

import javax.persistence.*

@Entity
class TestCase(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id")
    val problem: Problem = Problem(),

    @Column(nullable = false, columnDefinition = "text")
    val input: String = "",

    @Column(nullable = false, columnDefinition = "text")
    val output: String = ""
)
