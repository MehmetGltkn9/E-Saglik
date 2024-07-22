/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author alper
 */
@Entity
@Table(name = "document")
@NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
public class Document extends BaseEntity implements Serializable {

    @Column(name = "path")
    private String filePath;

    @Column(name = "type")
    private String fileType;

    public Document(String filePath, String fileType, int id, String name) {
        super(id, name);
        this.filePath = filePath;
        this.fileType = fileType;
    }

    public Document() {
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "Document{" + "filePath=" + filePath + ", fileType=" + fileType + '}';
    }

}
