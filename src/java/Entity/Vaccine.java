package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "vaccine")
public class Vaccine extends BaseEntity {
    
    @Column(name = "type")
    private String type;

    public Vaccine() {
    }

    public Vaccine(String type, int id, String name) {
        super(id, name);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vaccine{" + "type=" + type + '}';
    }
}
