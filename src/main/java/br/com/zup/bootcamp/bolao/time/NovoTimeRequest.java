package br.com.zup.bootcamp.bolao.time;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class NovoTimeRequest {

    @NotBlank(message = "nome não pode ser vazio")
    private String nome;

    @Past(message = "data de fundação deve ser no passado")
    private LocalDate dataDeFundacao;

    public String getNome() {
        return nome;
    }

    public LocalDate getDataDeFundacao() {
        return dataDeFundacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataDeFundacao(LocalDate dataDeFundacao) {
        this.dataDeFundacao = dataDeFundacao;
    }

    public Time toModel(){
        return new Time(nome, dataDeFundacao);
    }

}
