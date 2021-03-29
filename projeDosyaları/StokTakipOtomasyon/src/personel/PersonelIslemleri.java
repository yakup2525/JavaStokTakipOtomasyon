package personel;


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
import static personel.PersonelEkran.model;


public class PersonelIslemleri implements IpersonelIslemleri2, IpersonelIslemleri3{
    
    private Connection con = null;
     private  Statement statement = null;
    
    private PreparedStatement preparedStatement = null;
    
    @Override
    public ArrayList<Personel> personelGetir() {
    
        ArrayList<Personel> cikti = new ArrayList<Personel>();
         
        try {
            statement = con.createStatement();
            String sorgu = "Select * From personeller";
            ResultSet rs = statement.executeQuery(sorgu);
            
            while(rs.next()) {
            
                int id = rs.getInt("id");
                String ad = rs.getString("ad");
                String soyad = rs.getString("soyad");
                String dept = rs.getString("departman");
                String maas = rs.getString("maas");
                //personel clasının Yapıcı metodu
                //personel ekranında da Yapıcı metot çalıştıktan sonra getter metotlarıyla veriler alınıyor
                //
                cikti.add(new Personel(id, ad, soyad, dept, maas));
               
            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(PersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
    
    }
    
    
    public PersonelIslemleri() {
    
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
    public void personelGuncelle(int id, String ad1, String soyad1, String departman1, String maas1) {
    
        String sorgu = "Update personeller set ad = ? , soyad = ? , departman = ? , maas = ? where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1, ad1);
            preparedStatement.setString(2, soyad1);
            preparedStatement.setString(3, departman1);
            preparedStatement.setString(4, maas1);
            
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void personelSil(int id) {
    
        String sorgu = "Delete from personeller where id = ?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
             preparedStatement.setInt(1, id);
             preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
    @Override
    public void Ara(String ara) {
    
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        PersonelEkran.Personel_tablosu.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(ara));
        //Arama metodumuz gelen string değeri personelle arasında arıyor
        
    }
    
    public class Ekle {
    //Inner class EKle metodu burada tanımlanmıştır
        public void personelEkle(String ad, String soyad, String departman, String maas) {
    
        String sorgu = "Insert Into personeller (ad,soyad,departman,maas) Values(?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, soyad);
            preparedStatement.setString(3, departman);
            preparedStatement.setString(4, maas);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    }
    
}
