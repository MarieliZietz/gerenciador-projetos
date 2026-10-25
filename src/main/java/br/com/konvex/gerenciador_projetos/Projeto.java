package br.com.konvex.gerenciador_projetos;

public class Projeto {

    private Long id;
    private String nome;
    private String cliente;
    private Integer dataInicio;
    private Integer dataEntrega;
    private String status;
    private Long idEquipe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Integer dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Integer getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Integer dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Long idEquipe) {
        this.idEquipe = idEquipe;
    }
}