package br.com.jckrknaul.SupermarketList.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;

@Entity
public class SupermarketList extends AbstractEntity{

    @NotEmpty
    private String local;
    private String data;
    private String hora;

    public SupermarketList(String local, String data, String hora) {
        this.local = local;
        this.data = data;
        this.hora = hora;
    }

    public SupermarketList() {
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
