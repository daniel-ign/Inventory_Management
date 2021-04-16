package com.ignjatov.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Inventory.findAll",query = "SELECT i FROM Inventory i")
@NamedQuery(name = "Inventory.getById",query = "SELECT i FROM Inventory i WHERE i.id = :ID")
@NamedQuery(name = "Inventory.getByName",query = "SELECT i from Inventory i where i.name = :name")
public class Inventory implements Comparable<Inventory>, Serializable{
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true)
    private String name;
    private String sport;
    private int quantity;
    private double pricePerUnit;
    private Date dateAdded;
    private Date dateUpdated;

    @PrePersist
    void createdAt(){
        this.dateAdded = new Date();
    }
    @PreUpdate
    void updatedAt(){
        this.dateUpdated = new Date();
    }


    public Inventory(String name, String sport, int quantity, double pricePerUnit) {
        this.name = name;
        this.sport = sport;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "name='" + name + '\'' +
                ", sport='" + sport + '\'' +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                ", dateAdded=" + dateAdded +
                ", dateUpdated=" + dateUpdated +
                '}';
    }

    @Override
    public int compareTo(Inventory o) {
        return name.compareTo(o.name);
    }
}
