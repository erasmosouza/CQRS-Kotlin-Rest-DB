package esp.inventory.library.test.repository


import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
class LibraryRepositoryTest {

    @Autowired
    private var repository: LibraryRepository? = null

    @Test
    fun saveTest() {
        val category = repository?.save(LibraryEntity(libraryName = "Primeira Categoria"))
        Assert.assertEquals("Primeira Categoria", category?.libraryName)
        Assert.assertNotEquals(0L, category?.id)
    }

    @Test
    fun updateTest() {
        val category = repository!!.save(LibraryEntity(libraryName = "Primeira Categoria"))
        val id = category.id
        Assert.assertEquals("Primeira Categoria", category.libraryName)
        Assert.assertNotEquals(0L, category.id)

        category.libraryName = "Primeira Categoria com Update"
        val libraryUpdated = repository!!.save(category)

        Assert.assertEquals("Primeira Categoria com Update", category.libraryName)
        Assert.assertEquals(id, libraryUpdated.id)
    }

    @Test
    fun deleteTest() {
        val category = repository!!.save(LibraryEntity(libraryName = "Primeira Categoria"))
        val id = category.id

        repository!!.deleteById(id)

        val cat = repository!!.findById(id)
        Assert.assertEquals(true, cat.isEmpty)
    }
}