package br.senac.rn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private int id;
    private String nome;
    private String objeto;

    public Categoria() {
    }

    public Categoria(int id, String nome, String objeto) {
        this.id = id;
        this.nome = nome;
        this.objeto = objeto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", nome=" + nome + ", objeto=" + objeto + '}';
    }
    
    
    
}
