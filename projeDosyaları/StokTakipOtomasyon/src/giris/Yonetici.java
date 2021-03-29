package giris;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import personel.Database;
import personel.PersonelIslemleri;


public class Yonetici {
    
     private Connection con = null;
     private  Statement statement = null;
    
    private PreparedStatement preparedStatement = null;
    
    
    
    public Yonetici() {
    
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
    
    
    public boolean girisYap(String kullanici_adi, String parola ) {
    
       
       
        try {
            String sorgu = "Select * From myadmin where username = ? and password = ?";
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, kullanici_adi);
            preparedStatement.setString(2, parola);
            
            ResultSet rs = preparedStatement.executeQuery();
            
               return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonelIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Başarısız kontrol...");
            return false;
        }
       
    }
    
    
}
