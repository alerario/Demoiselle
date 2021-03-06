/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import br.data.entity.Rota;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author henrique
 */
public class CrudRota extends AbstractCrud<Rota> {
    
    private EntityManager em;

    private static final String PU = EMNames.EMN1;

    public CrudRota() {
        super(Rota.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory(PU).createEntityManager();
        }
        return em;
    }
    
    public List<Rota> selectByAeroporto(int aeroportoorigem, int aeroportodestino) { 
        try { 
            Query query = getEntityManager().createNamedQuery("Rota.findByIdAeroporto"); 
            query.setParameter("aeroportoorigem", aeroportoorigem); 
            query.setParameter("aeroportodestino", aeroportodestino); 
            return query.getResultList(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
         
        return null; 
    }
    
    @Override 
    public List<Rota> getAll() {
        List<Rota> rotas = new ArrayList<>();
        try {
            rotas = getEntityManager()
                    .createNamedQuery("Rota.findAll")
                    .getResultList(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return rotas;
    }
    
}
