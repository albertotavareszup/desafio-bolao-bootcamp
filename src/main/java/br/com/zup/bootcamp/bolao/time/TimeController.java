package br.com.zup.bootcamp.bolao.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private EntityManager manager;

    @Transactional
    @PostMapping
    public ResponseEntity<?> criarTime(@RequestBody @Valid NovoTimeRequest novoTimeRequest, UriComponentsBuilder uriComponentsBuilder){

        Time time = novoTimeRequest.toModel();
        manager.persist(time);
        return ResponseEntity
                .created(uriComponentsBuilder.buildAndExpand("/times/{id}",time.getId()).toUri()).build();

    }

}
