package aula18_maven.mesa.model;

import java.util.Date;

public class Paciente {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String rg;
    private Date dataCadastro;
    private Integer idEndereco;

    public Paciente(Integer id, String nome, String sobrenome, String rg, Date dataCadastro, Integer idEndereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.dataCadastro = dataCadastro;
        this.idEndereco = idEndereco;
    }

    public Paciente(String nome, String sobrenome, String rg, Date dataCadastro, Integer idEndereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.dataCadastro = dataCadastro;
        this.idEndereco = idEndereco;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", rg='" + rg + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", idEndereco=" + idEndereco +
                '}';
    }
}
