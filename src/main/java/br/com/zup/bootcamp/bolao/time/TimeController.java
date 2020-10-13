package br.com.zup.bootcamp.bolao.time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(TimeController.class);

    @Transactional
    @PostMapping
    public ResponseEntity<?> criarTime(@RequestBody @Valid NovoTimeRequest novoTimeRequest,
                                       UriComponentsBuilder uriComponentsBuilder){

        Time time = novoTimeRequest.toModel();
        manager.persist(time);
        logger.info("Salvo time {}", time);
        return ResponseEntity
                .created(uriComponentsBuilder.path("/times/{id}").buildAndExpand(time.getId()).toUri()).build();

    }

}
