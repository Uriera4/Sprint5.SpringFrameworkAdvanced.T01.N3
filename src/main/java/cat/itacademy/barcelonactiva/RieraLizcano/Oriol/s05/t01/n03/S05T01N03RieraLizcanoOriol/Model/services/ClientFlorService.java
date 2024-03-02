package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n03.S05T01N03RieraLizcanoOriol.Model.services;

import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n03.S05T01N03RieraLizcanoOriol.Model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n03.S05T01N03RieraLizcanoOriol.Model.dto.FlorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientFlorService {

    private FlorEntity convertToFlorEntity (FlorDTO florDTO){
        FlorEntity flor = new FlorEntity(florDTO.getNomFlor(), florDTO.getPaisFlor());
        flor.setPk_FlorID(florDTO.getPk_FlorID());
        return flor;
    }
    private FlorDTO convertToFlorDTO (FlorEntity flor){
        FlorDTO florDTO = null;
        if (flor!=null) florDTO = createFlorDTO(flor);
        return florDTO;
    }
    private FlorDTO createFlorDTO (FlorEntity flor){
        return new FlorDTO(flor.getPk_FlorID(), flor.getNomFlor(), flor.getPaisFlor());
    }

    private final WebClient.Builder webClientBuilder;
    @Autowired
    public ClientFlorService(WebClient.Builder webClientBuilder){
        this.webClientBuilder = webClientBuilder.baseUrl("http://localhost:9001/flor");
    }

    public Mono<FlorDTO> createFlor (FlorDTO florDTO){
        FlorEntity flor = convertToFlorEntity(florDTO);
        return webClientBuilder.build().post().uri("/add").body(Mono.just(flor), FlorEntity.class).retrieve().bodyToMono(FlorDTO.class);
    }
    public Mono<FlorDTO> updateFlor (FlorDTO florDTO){
        FlorEntity flor = convertToFlorEntity(florDTO);
        return webClientBuilder.build().put().uri("/update").body(Mono.just(flor), FlorEntity.class).retrieve().bodyToMono(FlorDTO.class);
    }
    public Mono<Void> deleteFlor (Integer id){
        return webClientBuilder.build().delete().uri("/delete/{id}", id).retrieve().toBodilessEntity().then();
    }
    public Mono<FlorDTO> getOne (Integer id){
        return webClientBuilder.build().get().uri("/getOne/{id}", id).retrieve().bodyToMono(FlorDTO.class);
    }
    public Flux<FlorDTO> getAll (){
        return webClientBuilder.build().get().uri("/getAll").retrieve().bodyToFlux(FlorDTO.class);
    }

}
