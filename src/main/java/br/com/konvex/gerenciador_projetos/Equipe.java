package br.com.konvex.gerenciador_projetos;

import java.util.ArrayList;
import java.util.List;

public class Equipe {

    private Long id;
    private String lider;
    private List<String> membros = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    public List<String> getMembros() {
        return membros;
    }

    public void setMembros(List<String> membros) {
        this.membros = membros;
    }
}