package esp.inventory.library.test.repository

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private var repository: BookRepository? = null

    @Autowired
    private var libraryRepository: LibraryRepository? = null

    @Test
    fun saveTest() {
        val library: LibraryEntity = libraryRepository!!.save(
            LibraryEntity(
                libraryName = "Primeira Categoria"
            )
        )
        Assert.assertNotEquals(0L, library.id)

        val book: BookEntity = repository!!.save(
            BookEntity(
                title = "Meu Livro",
                author = "Erasmo Pinheiro",
                description = "Descrição do meu primeiro livro",
                library = library
            )
        )
        Assert.assertNotEquals(0L, book.id)
    }

    @Test
    fun updateTest() {
        val library = libraryRepository!!.save(LibraryEntity(libraryName = "Primeira Categoria"))

        Assert.assertNotEquals(0L, library.id)

        val book: BookEntity = repository!!.save(
            BookEntity(
                title = "Meu Livro",
                author = "Erasmo Pinheiro",
                description = "Descrição do meu primeiro livro",
                library = library
            )
        )
        val id = book.id
        Assert.assertNotEquals(0L, id)

        book.title = "Meu Livro Updated"
        val bookUpdated = repository!!.save(book)

        Assert.assertEquals("Meu Livro Updated", bookUpdated.title)
        Assert.assertEquals(id, bookUpdated.id)
    }

    @Test
    fun deleteTest() {
        val library = libraryRepository!!.save(LibraryEntity(libraryName = "Primeira Categoria"))
        val book: BookEntity = repository!!.save(
            BookEntity(
                title = "Meu Livro",
                author = "Erasmo Pinheiro",
                description = "Descrição do meu primeiro livro",
                library = library
            )
        )
        val id = book.id

        repository!!.deleteById(id)

        val oldBook = repository!!.findById(id)
        Assert.assertEquals(true, oldBook.isEmpty)
    }


}