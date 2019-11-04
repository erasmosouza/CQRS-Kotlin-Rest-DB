package esp.inventory.library

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
    @JoinColumn(name = "category_id")
    var category: CategoryEntity = CategoryEntity()
)