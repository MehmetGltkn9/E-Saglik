package DAO;

import Entity.Payment;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;

@Local
@Stateless
public class PaymentDAO extends AbstractDAO<Payment> implements Serializable {

    public PaymentDAO() {
        super(Payment.class);
    }

}
