package components;

/**
 * Created by nazar on 10.04.17.
 */
public class Instrument {
    public Instrument(int id, String model, String category, String trademark, int company_index, String purchase_date, String sell_date, boolean functioning) {
        this.id = id;
        this.model = model;
        this.category = category;
        this.trademark = trademark;
        this.company_index = company_index;
        this.purchase_date = purchase_date;
        this.sell_date = sell_date;
        this.functioning = functioning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public int getCompany_index() {
        return company_index;
    }

    public void setCompany_index(int company_index) {
        this.company_index = company_index;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getSell_date() {
        return sell_date;
    }

    public void setSell_date(String sell_date) {
        this.sell_date = sell_date;
    }

    public boolean isFunctioning() {
        return functioning;
    }

    public void setFunctioning(boolean functioning) {
        this.functioning = functioning;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", category='" + category + '\'' +
                ", trademark='" + trademark + '\'' +
                ", company_index=" + company_index +
                ", purchase_date='" + purchase_date + '\'' +
                ", sell_date='" + sell_date + '\'' +
                ", functioning=" + functioning +
                '}';
    }

    private int id;
    private String model;
    private String category;
    private String trademark;
    private int company_index;
    private String purchase_date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instrument that = (Instrument) o;

        if (id != that.id) return false;
        if (company_index != that.company_index) return false;
        if (functioning != that.functioning) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (trademark != null ? !trademark.equals(that.trademark) : that.trademark != null) return false;
        if (purchase_date != null ? !purchase_date.equals(that.purchase_date) : that.purchase_date != null)
            return false;
        return sell_date != null ? sell_date.equals(that.sell_date) : that.sell_date == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (trademark != null ? trademark.hashCode() : 0);
        result = 31 * result + company_index;
        result = 31 * result + (purchase_date != null ? purchase_date.hashCode() : 0);
        result = 31 * result + (sell_date != null ? sell_date.hashCode() : 0);
        result = 31 * result + (functioning ? 1 : 0);
        return result;
    }

    private String sell_date;
    private boolean functioning;

}
