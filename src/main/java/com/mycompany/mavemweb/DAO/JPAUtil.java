/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavemweb.DAO;

import java.io.Serializable;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel
 */
public class JPAUtil implements Serializable {
    private static EntityManagerFactory emf;
        
    public static EntityManagerFactory getEMF() {
    
        if (emf == null){
            emf = Persistence.createEntityManagerFactory("com.mycompany_MavemWEB_war_1.0-SNAPSHOTPU", PersistenceProperties.get());
        }
        return emf;
    }
}
