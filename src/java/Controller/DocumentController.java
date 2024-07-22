/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DocumentDAO;
import Entity.Document;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;

/**
 *
 * @author alper
 */
@Named
@SessionScoped
public class DocumentController extends BaseController<Document> implements Serializable {

    private Document document;
    private List<Document> DocumentList;
    private DocumentDAO documentDAO;

    private Part d;

    private final String uploadTo = "/Users/alper/upload/";

    public DocumentController(Class<Document> entityClass) {
        super(entityClass);
    }

    public void upload() {
        try {
            InputStream input = d.getInputStream();
            File f = new File(uploadTo + d.getSubmittedFileName());
            Files.copy(input, f.toPath());

            document = this.getDocument();
            document.setFilePath(f.getParent());
            document.setName(f.getName());

            this.getDocumentDAO().Create(document);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public String getUploadTo() {
        return uploadTo;
    }

    public Document getDocument() {
        if (this.document == null) {
            this.document = new Document();
        }
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Document> getDocumentList() {
        return DocumentList;
    }

    public void setDocumentList(List<Document> DocumentList) {
        this.DocumentList = DocumentList;
    }

    public DocumentDAO getDocumentDAO() {
        if (this.documentDAO == null) {
            this.documentDAO = new DocumentDAO();
        }
        return documentDAO;
    }

    public void setDocumentDAO(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    public Part getD() {
        return d;
    }

    public void setD(Part d) {
        this.d = d;
    }

    @Override
    public void AddEntity() {
        if (documentDAO == null) {
            documentDAO = new DocumentDAO();
        }
        documentDAO.Create(document);
    }

    @Override
    public Document GetEntityById(int id) {
        if (documentDAO == null) {
            documentDAO = new DocumentDAO();
        }
        documentDAO.GetById(id);
        return null;
    }

    @Override
    public List<Document> GetEntityList() {
        return getDocumentDAO().GetList();
    }

    @Override
    public void UpdateEntity() {
        if (documentDAO == null) {
            documentDAO = new DocumentDAO();
        }
        documentDAO.Update(document);
    }

    @Override
    public void DeleteEntity() {
        if (documentDAO == null) {
            documentDAO = new DocumentDAO();
        }
        documentDAO.Delete(document);
    }

}
