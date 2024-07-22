package Controller;

import DAO.AbstractDAO;
import DAO.PaymentDAO;
import Entity.Payment;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PaymentController extends BaseController<Payment> implements Serializable {

    @EJB
    private PaymentDAO paymentDao;
    private Payment entity;
    private List<Payment> paymentList;

    
    private int page = 1;
    private int pageSize = 10;
    private int pageCount;
    
    public PaymentController() {
        super(Payment.class);
    }

    
    public void next() {
        if (this.page == getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }

    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }

    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(getPaymentDao().Count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void clearForm() {
        this.entity = new Payment();
    }

    public void updateForm(Payment pay) {
        this.entity = pay;
    }

    public PaymentDAO getPaymentDao() {
         if (this.paymentDao == null) {
            this.paymentDao = new PaymentDAO();
        }
        return paymentDao;
    }

    public void setPaymentDao(PaymentDAO paymentDao) {
        this.paymentDao = paymentDao;
    }

    public Payment getEntity() {
        if (entity == null) {
            entity = new Payment();
        }
        return entity;
    }

    public void setEntity(Payment entity) {
        this.entity = entity;
    }

    public List<Payment> getPaymentList() {
        this.paymentList = this.getPaymentDao().GetList();
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
    
    @Override
    public Payment GetEntityById(int id) {
        if (paymentDao == null) {
            paymentDao = new PaymentDAO();
        }
        paymentDao.GetById(id);
        return null;
    }

    @Override
    public List<Payment> GetEntityList() {
        return getPaymentDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getPaymentDao().Update(entity);
        this.entity = new Payment();
    }

    @Override
    public void DeleteEntity() {
        getPaymentDao().Delete(entity);
        this.entity = new Payment();
    }

    @Override
    public void AddEntity() {
        getPaymentDao().Create(this.entity);
        this.entity = new Payment();
    }

}
