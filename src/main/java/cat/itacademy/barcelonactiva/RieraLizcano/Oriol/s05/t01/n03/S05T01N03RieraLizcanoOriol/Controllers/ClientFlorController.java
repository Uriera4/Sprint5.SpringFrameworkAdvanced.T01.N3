package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n03.S05T01N03RieraLizcanoOriol.Controllers;

import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n03.S05T01N03RieraLizcanoOriol.Model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n03.S05T01N03RieraLizcanoOriol.Model.services.ClientFlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/flor")
public class ClientFlorController {

    @Autowired
    private ClientFlorService clientFlorService;

    @PostMapping("/clientFlorsAdd")
    public Mono<FlorDTO> createFlor (@RequestBody FlorDTO florDTO){
        return clientFlorService.createFlor(florDTO);
    }
    @PutMapping("/clientFlorsUpdate")
    public Mono<FlorDTO> updateFlor (@RequestBody FlorDTO florDTO){
        return clientFlorService.updateFlor(florDTO);
    }
    @DeleteMapping("/clientFlorsDelete/{id}")
    public Mono<Void> deleteFlor (@PathVariable("id") Integer id){
        return clientFlorService.deleteFlor(id);
    }
    @GetMapping("/clientFlorsGetOne/{id}")
    public Mono<FlorDTO> getFlor (@PathVariable("id") Integer id){
        return clientFlorService.getOne(id);
    }
    @GetMapping("/clientFlorsAll")
    public Flux<FlorDTO> getFlors (){
        return clientFlorService.getAll();
    }

}
