/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewwindowdriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sean
 */
public class AssetDB implements DataReadWrite {
    
    private String url;
    private Connection conn;
    
    public AssetDB(String url) {
        this.url = url;
        
        
    }
    
    private Connection connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void initialize() {
        String sql = "CREATE TABLE IF NOT EXISTS asset (\n"
                + " id integer PRIMARY KEY, \n"
                + " name text NOT NULL, \n"
                + " use integer NOT NULL, \n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Asset getData(String assetName) {
        String sql = "SELECT id, name, use FROM asset";
        Asset asset = new Asset();
        
        try (Connection conn = this.connect(); 
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                
                if (assetName.compareTo(rs.getString("name")) == 0) {
                    asset.setName(rs.getString("name"));
                    if (rs.getInt("use") == 1) {
                    asset.setUse(true);
                    }
                    else {
                        asset.setUse(false);
                    }
                       
                    
                    
                    rs.close();
                    conn.close();
                }  
            }    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return asset;
    }
    
    
    
}
