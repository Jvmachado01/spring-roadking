package vitor.joao.road_king;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*  @RestController: contém as anotações @Controller e@ResponseBody
    @Controller: reprenseta uma class com endpoint (URLs que serão expostas pela API) e
a class indica que o valor retornado pelos métodos devem ser vinculadas ao corpo da responsta.
*/
@RestController
@RequestMapping({"/contacts"}) // http://localhost:8080/contacts
public class ContactController {
    private ContactRepository repository;

    ContactController(ContactRepository contactRepository) {
        this.repository = contactRepository;
    }

    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse((ResponseEntity.notFound().build()));
    }

    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        return repository.save(contact);
    }

    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Contact contact) {
        return repository.findById(id)
                .map(record -> {
                    record.setName(contact.getName());
                    record.setEmail(contact.getEmail());
                    record.setPhone(contact.getPhone());
                    Contact updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }


}
