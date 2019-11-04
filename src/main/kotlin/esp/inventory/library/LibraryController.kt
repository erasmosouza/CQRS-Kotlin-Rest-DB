package esp.inventory.library

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/categories")
class LibraryController {
/*
    @PostMapping()
    fun create(@Valid @RequestBody categoryCommand: RegisterLibraryCommand): ResponseEntity<RegisterLibraryCommand> {

        if (categoryCommand.id == 0L){
            return ResponseEntity(categoryCommand, HttpStatus.CONFLICT)
        }
        return ResponseEntity(categoryCommand, HttpStatus.CREATED)
    }
*/
}