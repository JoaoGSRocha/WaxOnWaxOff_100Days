package com.joaogsrocha._SpringREST.payroll;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class SkinController {
    private final SkinRepository repository;

    SkinController(SkinRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("api/skin")
    List<Skin> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("api/skin")
    Skin newSkin(@RequestBody Skin newSkin) {
        return repository.save(newSkin);
    }

    // Single item

    @GetMapping("api/skin/{id}")
    Skin one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new SkinNotFoundException(id));
    }

    @PutMapping("api/skin/{id}")
    Skin replaceSkin(@RequestBody Skin newSkin, @PathVariable Long id) {
        return repository.findById(id)
            .map(skin -> {
                skin.setName(newSkin.getName());
                skin.setCondition(newSkin.getCondition());
                return repository.save(skin);
            })
            .orElseGet(() -> {
            newSkin.setId(id);
            return repository.save(newSkin);
            });
    }

    @DeleteMapping("api/skin/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
                }
}
