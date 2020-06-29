package smtd;

import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.scene.control.TextField;

public class DataAdmin {
	private String Stud_ID;
//	private String Emri;
//	private String Mbiemri;
	private String Lenda;
	private int ECTS;
	private int Nota;
	public DataAdmin(String Stud_ID, String Lenda, int ECTS, int Nota)
	{
		this.Stud_ID = Stud_ID;
//		this.Emri = Emri;
//		this.Mbiemri = Mbiemri;
		this.Lenda = Lenda;
		this.ECTS = ECTS;
		this.Nota = Nota;
	}
	public String getStud_ID() {
		return Stud_ID;
	}
	public void setStud_ID(String stud_ID) {
		Stud_ID = stud_ID;
	}
//	public String getEmri() {
//		return Emri;
//	}
//	public void setEmri(String emri) {
//		Emri = emri;
//	}
//	public String getMbiemri() {
//		return Mbiemri;
//	}
//	public void setMbiemri(String mbiemri) {
//		Mbiemri = mbiemri;
//	}
	public String getLenda() {
		return Lenda;
	}
	public void setLenda(String lenda) {
		Lenda = lenda;
	}
	public int getECTS() {
		return ECTS;
	}
	public void setECTS(int ECTS) {
		ECTS = ECTS;
	}
	public int getNota() {
		return Nota;
	}
	public void setNota(int nota) {
		Nota = nota;
	}
	
	public static boolean updateNota(String Stud_ID, String Lenda, int Nota) {
		String query = "UPDATE Notat SET Nota=? WHERE Stud_ID=? AND Lenda=?";
		
		try {
			PreparedStatement preparedStatement = Databaza.getConnection().prepareStatement(query);
			
			preparedStatement.setInt(1, Nota);
			preparedStatement.setString(2, Stud_ID);
			preparedStatement.setString(3, Lenda);
			
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	
}
