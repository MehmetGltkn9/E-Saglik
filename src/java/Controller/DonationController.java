package Controller;

import DAO.DonationDAO;
import Entity.Donation;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class DonationController extends BaseController<Donation> implements Serializable {

    @EJB
    private DonationDAO donationDao;
    private Donation entity;
    private List<Donation> donationList;

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public DonationController() {
        super(Donation.class);
    }

    public DonationDAO getDonationDao() {
        if (this.donationDao == null) {
            this.donationDao = new DonationDAO();
        }
        return donationDao;
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
        this.pageCount = (int) Math.ceil(getDonationDao().Count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void clearForm() {
        this.entity = new Donation();
    }

    public void updateForm(Donation don) {
        this.entity = don;
    }
    public void setDonationDao(DonationDAO donationDao) {
        this.donationDao = donationDao;
    }

    public Donation getEntity() {
        if (entity == null) {
            entity = new Donation();
        }
        return entity;
    }

    public void setEntity(Donation entity) {
        this.entity = entity;
    }

    public List<Donation> getDonationList() {
        this.donationList = this.getDonationDao().GetList();
        return donationList;
    }

    public void setDonationList(List<Donation> donationList) {
        this.donationList = donationList;
    }

    @Override
    public void AddEntity() {
        getDonationDao().Create(this.entity);
        this.entity = new Donation();

    }

    @Override
    public Donation GetEntityById(int id) {
        if (donationDao == null) {
            donationDao = new DonationDAO();
        }
        donationDao.GetById(id);
        return null;
    }

    @Override
    public List<Donation> GetEntityList() {
        return getDonationDao().GetList();
    }

    @Override
    public void UpdateEntity() {
        getDonationDao().Update(entity);
        this.entity = new Donation();
    }

    @Override
    public void DeleteEntity() {
        getDonationDao().Delete(entity);
        this.entity = new Donation();
    }

}
