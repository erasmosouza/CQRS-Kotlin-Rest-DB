package esp.inventory.library

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private var repository: CategoryRepository? = null

    @Test
    fun saveTest() {
        val category = repository?.save(CategoryEntity(categoryName = "Primeira Categoria"))
        Assert.assertEquals("Primeira Categoria", category?.categoryName)
        Assert.assertNotEquals(0L, category?.id)
    }

    @Test
    fun updateTest(){
        val category = repository!!.save(CategoryEntity(categoryName = "Primeira Categoria"))
        val id = category.id
        Assert.assertEquals("Primeira Categoria", category.categoryName)
        Assert.assertNotEquals(0L, category.id)

        category.categoryName = "Primeira Categoria com Update"
        val categoryUpdated = repository!!.save(category)

        Assert.assertEquals("Primeira Categoria com Update", category.categoryName)
        Assert.assertEquals(id, categoryUpdated.id)
    }

    @Test
    fun deleteTest(){
        val category = repository!!.save(CategoryEntity(categoryName = "Primeira Categoria"))
        val id = category.id

        repository!!.deleteById(id)

        val cat = repository!!.findById(id)
        Assert.assertEquals( true, cat.isEmpty)
    }
}