/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


public class Vacina {
    private int id;
    private String nome_vacina;
    private int dosagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_vacina() {
        return nome_vacina;
    }

    public void setNome_vacina(String nome_vacina) {
        this.nome_vacina = nome_vacina;
    }

    public int getDosagem() {
        return dosagem;
    }

    public void setDosagem(int dosagem) {
        this.dosagem = dosagem;
    }

    public String getInfo_vacina() {
        return info_vacina;
    }

    public void setInfo_vacina(String info_vacina) {
        this.info_vacina = info_vacina;
    }
    private String info_vacina;
    
}

    