/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Document;
import jakarta.ejb.Stateless;
import java.io.Serializable;

/**
 *
 * @author alper
 */
@Stateless
public class DocumentDAO extends AbstractDAO<Document> implements Serializable {
   public DocumentDAO() {
        super(Document.class);
    }
}
