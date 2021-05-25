/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tarefa")
public class TarefaEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_tarefa_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_tarefa_id')")
    private Long id;

    @Column(name = "nome", nullable = false, length = 75)
    private String nome;

    @Column(name = "data_hora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    @Column(name = "duracao", nullable = false)
    private String duracao;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_local_id", columnDefinition = "bigint")
    private LocalEntity local;

    @ManyToMany
    @JoinTable(
        name="tarefa_convidado",
        joinColumns = @JoinColumn( name="fk_tarefa_id"),
        inverseJoinColumns = @JoinColumn( name="fk_convidado_id")
    )
    private List<ConvidadoEntity> convidados;

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

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public LocalEntity getLocal() {
        return local;
    }

    public void setLocal(LocalEntity local) {
        this.local = local;
    }

    public List<ConvidadoEntity> getConvidados() {
        return convidados;
    }

    public void setConvidados(List<ConvidadoEntity> convidados) {
        this.convidados = convidados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TarefaEntity that = (TarefaEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(dataHora, that.dataHora) && Objects.equals(duracao, that.duracao) && Objects.equals(local, that.local) && Objects.equals(convidados, that.convidados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataHora, duracao, local, convidados);
    }

    @Override
    public String toString() {
        return "TarefaEntity{"
                + "id=" + id
                + ", nome='" + nome + '\''
                + ", dataHora=" + dataHora
                + ", duracao=" + duracao
                + ", local=" + local.getNome()
                + '}';
    }
}
