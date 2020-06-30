package smtd;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Kryesore extends Application {
	String Emri;
	String Mbiemri;
	String Fakulteti;
	String Departamenti;
	String ID;
	String VitiRegjistrimit;
	String VitiLindjes;
	String VendiLindjes;
	String MbaroiStudimet;
	String Titulli;
	String NotaMesatare;
	int ECTSTotal;
	
	private TableView tabela = new TableView();
	
	public Kryesore(String rezultati) {
		this.ID = rezultati;
	}
	public void aplikimi()
	{
		Document document = new Document();

		try
		{
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C://Users//OS//Desktop/"+Emri+"_"+Mbiemri+".pdf"));
	        document.open();
	        PdfPTable table = new PdfPTable(2);
	        table.setTotalWidth(new float[]{ 240, 260 });
	        table.setLockedWidth(true);
	        PdfContentByte cb = writer.getDirectContent();
	        
	        Font fontsize = FontFactory.getFont(FontFactory.HELVETICA,10);

	        PdfPCell cell = new PdfPCell();
	        cell.setFixedHeight(35);
	        cell.setBorder(Rectangle.NO_BORDER);
	        cell.setColspan(2);
	        table.addCell(cell);
	        // first row
	        cell = new PdfPCell(new Paragraph("Republika e Kosoves",fontsize));
	        cell.setFixedHeight(25);
	        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	        cell.setBorder(Rectangle.NO_BORDER);
	        table.addCell(cell);
	        cell = new PdfPCell(new Paragraph("Republic of Kosovo",fontsize));
	        cell.setFixedHeight(25);
	        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	        cell.setIndent(20);
	        cell.setBorder(Rectangle.NO_BORDER);
	        table.addCell(cell);
	        
