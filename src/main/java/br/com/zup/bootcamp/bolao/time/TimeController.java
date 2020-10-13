package br.com.zup.bootcamp.bolao.time;

import jdk.jfr.internal.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/times")
public class TimeController {


    @PostMapping
    public ResponseEntity<?> criarTime(@RequestBody @Valid NovoTimeRequest novoTimeRequest, UriComponentsBuilder uriComponentsBuilder){

        Time time = novoTimeRequest.toModel();

        return ResponseEntity
                .created()

    }

}
