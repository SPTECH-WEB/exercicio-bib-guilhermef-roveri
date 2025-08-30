package com.school.sptech;

public class Biblioteca {

    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;


    public Biblioteca(String nome, Double multaDiaria){
        qtdLivros = 0;
        ativa = true;
        this.multaDiaria = multaDiaria;
        this.nome = nome;

    }


    public String getNome(){
        return nome;
    }

    public Double getMultaDiaria(){
        return multaDiaria;
    }

    public Integer getQtdLivros() {
        return qtdLivros;
    }

    public Boolean getAtiva(){
        return ativa;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void registrarLivro(Integer quantidade){
        if(quantidade != null && quantidade > 0 && ativa == true){
            qtdLivros += quantidade;
        }
    }

    public Integer emprestar(Integer quantidade){
        if(quantidade != null && quantidade > 0 && quantidade <= qtdLivros && ativa == true) {
            qtdLivros -= quantidade;
            return quantidade;
        }else{
            return null;
        }

    }

    public Integer devolver(Integer quantidade){
        if(quantidade != null && quantidade > 0){
            qtdLivros += quantidade;
        }
        return quantidade;
    }

    public Integer desativar(){
        if(ativa == false){
            return null;
        }else{
            ativa = false;
            Integer livrosExistentes = qtdLivros;
            qtdLivros = 0;

            return livrosExistentes;
        }
    }

    public void transferir(Biblioteca destino, Integer quantidade){
        Boolean b1 = this.ativa;
        Boolean b2 = destino.getAtiva();

        if(b1 == true && b2 == true){
            if(quantidade != null && quantidade <= qtdLivros){
                this.qtdLivros -= quantidade;
                destino.qtdLivros += quantidade;
            }



        }
    }

    public Boolean reajustarMulta(Double percentual){
        if(percentual != null && percentual > 0){
            multaDiaria = multaDiaria  * (1.0 + percentual);
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        Biblioteca b1 = new Biblioteca("Central", 2.5);
        b1.registrarLivro(10);
        b1.emprestar(4);

        System.out.println(b1.reajustarMulta(2.5));

        System.out.println(b1.getQtdLivros());
    }

}
