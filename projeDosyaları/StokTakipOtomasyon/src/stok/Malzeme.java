package stok;


public class Malzeme {
    
    private int id;
    private String isim;
    private String barkod;
    private String tur;
    private String miktar;
    private String fiyat;
    private String kayittarihi;

    //malzeme sınıfı Constructor
    public Malzeme(int id, String isim, String barkod, String tur, String miktar, String fiyat, String kayittarihi) {
        this.id = id;
        this.isim = isim;
        this.barkod = barkod;
        this.tur = tur;
        this.miktar = miktar;
        this.fiyat = fiyat;
        this.kayittarihi = kayittarihi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getBarkod() {
        return barkod;
    }

    public void setBarkod(String barkod) {
        this.barkod = barkod;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getMiktar() {
        return miktar;
    }

    public void setMiktar(String miktar) {
        this.miktar = miktar;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    public String getKayittarihi() {
        return kayittarihi;
    }

    public void setKayittarihi(String kayittarihi) {
        this.kayittarihi = kayittarihi;
    }

    

   
}
