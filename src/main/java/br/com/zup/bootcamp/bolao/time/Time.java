package br.com.zup.bootcamp.bolao.time;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(name = "time")
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "o nome do time não pode ser em branco")
    private String nome;

    @Past(message = "data de criação deve ser no passado")
    private LocalDate dataDeFundacao;

    public Time(@NotBlank(message = "o nome do time não pode ser em branco") String nome,
                @Past(message = "data de criação deve ser no passado") LocalDate dataDeFundacao) {

        this.nome = nome;
        this.dataDeFundacao = dataDeFundacao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataDeFundacao(LocalDate dataDeFundacao) {
        this.dataDeFundacao = dataDeFundacao;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataDeFundacao() {
        return dataDeFundacao;
    }

    public Long getId() {
        return this.id;
    }
}
