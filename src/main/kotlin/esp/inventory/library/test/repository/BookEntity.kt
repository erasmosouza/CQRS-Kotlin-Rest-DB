package esp.inventory.library.test.repository

import javax.persistence.*

@Entity(name = "Book")
class BookEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var title: String = "",

    var author: String = "",

    var description: String = "",

    @ManyToOne(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.MERGE))
    @JoinColumn(name = "library_id")
    var library: LibraryEntity = LibraryEntity()
)