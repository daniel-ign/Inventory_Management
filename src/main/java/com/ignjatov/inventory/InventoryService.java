package com.ignjatov.inventory;

import com.ignjatov.entity.Inventory;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Remote(InventoryInterface.class)
public class InventoryService implements InventoryInterface{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Inventory> getInventoryList() {
        List<Inventory> inventoryList = em.createNamedQuery("Inventory.findAll",Inventory.class).getResultList();
        Collections.sort(inventoryList);
        return inventoryList;
    }

    @Override
    public void addToList(Inventory inventory) {
        em.persist(inventory);
    }

    @Override
    public void addQuantity(Inventory inventory, int amount) {
        Inventory correspondingInventory = em.createNamedQuery("Inventory.getByName",Inventory.class)
                .setParameter("name",inventory.getName()).getSingleResult();
        correspondingInventory.setQuantity(correspondingInventory.getQuantity()+amount);
    }


    @Override
    public String getName(){
       return Inventory.class.getName();
    }

}
