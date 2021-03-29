package stok;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class MalzemeIslemleri implements IMalzemeIslemleri2, IMalzemeIslemleri3{
    
    private Connection con = null;
     private  Statement statement = null;
    
    private PreparedStatement preparedStatement = null;
    
   
    
    
    public MalzemeIslemleri() {
    
         String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi +"?useUnicode=true&characterEncoding=utf8";
        
        try{
        
           Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver bağlandı");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı...");
        }
        
        try {
            
            con = DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);
            System.out.println("Bağlantı Başarılı...");
            
        } catch (SQLException ex) {
            System.out.println("Bağlantı başarısız...");
           
        } 
    
    }
    
    @Override
    public void malzemeEkle(String isim, String barkod, String tur, String miktar, String fiyat, String kayittarihi) {
    //malzemeEkle Metodu
        String sorgu = "Insert Into malzemeler (isim,barkod,tur,miktar,fiyat,kayittarihi) Values(?,?,?,?,?,?)";
        //veritabanı sorgusu
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, isim);
            preparedStatement.setString(2, barkod);
            preparedStatement.setString(3, tur);
            preparedStatement.setString(4, miktar);
            preparedStatement.setString(5, fiyat);
            preparedStatement.setString(6, kayittarihi);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MalzemeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void malzemeGuncelle(int id, String isim, String barkod, String tur, String miktar, String fiyat, String kayittarihi) {
    //malzemeGuncelle metodu
        String sorgu = "Update malzemeler set isim = ? , barkod = ?, tur = ? , miktar = ? , fiyat = ?, kayittarihi = ? where id = ?";
        //veri tabanı sorgusu
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, isim);
            preparedStatement.setString(2, barkod);
            preparedStatement.setString(3, tur);
            preparedStatement.setString(4, miktar);
            preparedStatement.setString(5, fiyat);
            preparedStatement.setString(6, kayittarihi);
            
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
          //alanları güncelleme işlemleri  
        } catch (SQLException ex) {
            Logger.getLogger(MalzemeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   
    
     
    
    @Override
     public ArrayList<Malzeme> malzemeGetir() {
  //Malzeme getir metodu Veri tabanında malzemeleri programa çeker
  
        ArrayList<Malzeme> cikti = new ArrayList<Malzeme>();
         
        try {
            statement = con.createStatement();
            String sorgu = "Select * From malzemeler";
            ResultSet rs = statement.executeQuery(sorgu);
            //veri tabanı bağlantıları
            while(rs.next()) {
            
                int id = rs.getInt("id");
                String isim = rs.getString("isim");
                String barkod = rs.getString("barkod");
                String tur = rs.getString("tur");
                String miktar = rs.getString("miktar");
                String fiyat = rs.getString("fiyat");
                String kayittarihi = rs.getString("kayittarihi");
                
                //Yapıcı metot ile değişkenlere ilk değer ataması
                //Ayrıca Malzeme clası yapıcı metoduyla veri tabanındakı verilerle
                //Arraylistten türetilen cikti listesi doldurulurr add metoduyla
                cikti.add(new Malzeme(id, isim, barkod, tur, miktar, fiyat, kayittarihi));
               
            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(MalzemeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
    
    }
    
    
    @Override
     public void dinamikAra(String ara) {
    //Arama işlemi için tanımlı metot
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(StokEkran.model1);
        StokEkran.Malzeme_tablosu.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(ara));
        
        
    }
    
     
     public class Sil {
     //Inner Class tanımlaması ve içine yazılan metot
          public void malzemeSil(int id) {
    
        String sorgu = "Delete from malzemeler where id = ?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
             preparedStatement.setInt(1, id);
             preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MalzemeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
          
          
         
     }
     
     
   
    
}
