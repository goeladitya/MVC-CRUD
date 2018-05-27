package com.bmpl.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.bmpl.crud.dto.ProductDTO;

public class ProductDAO {
	private Connection getConnection() throws ClassNotFoundException, SQLException{
		ResourceBundle rb= ResourceBundle.getBundle("config");
		Class.forName(rb.getString("drivername"));
		Connection con= DriverManager.getConnection(rb.getString("dburl"),rb.getString("userid"),rb.getString("password"));
		return con;
	}
	
	public void deleteData(String del) throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		String delDataFromSQL= "delete from product where id=?";
		try{
			con= this.getConnection();
			pstmt= con.prepareStatement(delDataFromSQL);
			pstmt.setString(1, del);
		    pstmt.executeUpdate();
		}
		finally{
			
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
	}
	
	public void addProducts(String name, String desc, String price, String id) 
			throws SQLException, ClassNotFoundException{
		Connection con = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
		String addDataInSQL= "insert into product values (?,?,?,?)";
		try{
			con= this.getConnection();
			pstmt= con.prepareStatement(addDataInSQL);
			pstmt.setString(1, name);
			pstmt.setString(2, desc);
			pstmt.setString(3, price);
			pstmt.setString(4, id);
		    pstmt.executeUpdate();
		}
		finally{
			/*if(rs!=null){	
				rs.close();
				
			}*/
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
	}
	
	public ArrayList<ProductDTO> getProducts() throws SQLException, ClassNotFoundException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ProductDTO> productList = new ArrayList<>();
		final String SQL = "select name, descr, price, id from product";
		try{
			con = this.getConnection();
			pstmt = con.prepareStatement(SQL);
			//pstmt.setDouble(1, price);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ProductDTO prod = new ProductDTO(rs.getString("name"), rs.getString("descr"), rs.getString("price"),rs.getString("id"));
				productList.add(prod);
			}
		}
		finally{
			if(rs!=null){	
				rs.close();
				
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return productList;
	}

}
