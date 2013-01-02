
/* File:        observ/model/Protocol_subprotocols.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.excel.ExcelReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.protocol.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;

import org.apache.log4j.Logger;
import org.molgenis.framework.db.Database;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.Database.DatabaseAction;
import org.molgenis.util.CsvWriter;
import org.molgenis.util.SimpleTuple;
import org.molgenis.util.Tuple;

import org.molgenis.protocol.Protocol_Subprotocols;
import org.molgenis.protocol.csv.Protocol_SubprotocolsCsvReader;

/**
 * Reads Protocol_Subprotocols from Excel file.
 */
public class Protocol_SubprotocolsExcelReader
{
	public static final transient Logger logger = Logger.getLogger(Protocol_SubprotocolsExcelReader.class);
			
	/**
	 * Imports Protocol_Subprotocols from a workbook sheet.
	 */
	public int importSheet(final Database db, Sheet sheet, final Tuple defaults, final DatabaseAction dbAction, final String missingValue) throws DatabaseException, IOException, Exception 
	{
		File tmpProtocol_Subprotocols = new File(System.getProperty("java.io.tmpdir") + File.separator + "tmpProtocol_Subprotocols.txt");
		if(tmpProtocol_Subprotocols.exists()){
			boolean deleteSuccess = tmpProtocol_Subprotocols.delete();
			if(!deleteSuccess){
				throw new Exception("Deletion of tmp file 'tmpProtocol_Subprotocols.txt' failed, cannot proceed.");
			}
		}
		boolean createSuccess = tmpProtocol_Subprotocols.createNewFile();
		if(!createSuccess){
			throw new Exception("Creation of tmp file 'tmpProtocol_Subprotocols.txt' failed, cannot proceed.");
		}
		boolean fileHasHeaders = writeSheetToFile(sheet, tmpProtocol_Subprotocols);
		if(fileHasHeaders){
			int count = new Protocol_SubprotocolsCsvReader().importCsv(db, tmpProtocol_Subprotocols, defaults, dbAction, missingValue);
			tmpProtocol_Subprotocols.delete();
			return count;
		}else{
			tmpProtocol_Subprotocols.delete();
			return 0;
		}
	}
	
	public List<String> getNonEmptyHeaders(Sheet sheet){
		List<String> headers = new ArrayList<String>();
		Cell[] headerCells = sheet.getRow(0); //assume headers are on first line
		for(int i = 0; i < headerCells.length; i++){
			if(!headerCells[i].getContents().equals("")){
				headers.add(headerCells[i].getContents());
			}
		}
		return headers;
	}
	
	private boolean writeSheetToFile(Sheet sheet, File file) throws FileNotFoundException{
		List<String> headers = new ArrayList<String>();
		Cell[] headerCells = sheet.getRow(0); //assume headers are on first line
		if(headerCells.length == 0){
			return false;
		}
		ArrayList<Integer> namelessHeaderLocations = new ArrayList<Integer>(); //allow for empty columns, also column order does not matter
		for(int i = 0; i < headerCells.length; i++){
			if(!headerCells[i].getContents().equals("")){
				headers.add(headerCells[i].getContents());
			}else{
				headers.add("nameless"+i);
				namelessHeaderLocations.add(i);
			}
		}
		PrintWriter pw = new PrintWriter(file);
		CsvWriter cw = new CsvWriter(pw, headers);
		cw.setMissingValue("");
		cw.writeHeader();
		for(int rowIndex = 1; rowIndex < sheet.getRows(); rowIndex++){
			Tuple t = new SimpleTuple();
			int colIndex = 0;
			for(Cell c : sheet.getRow(rowIndex)){
				if(!namelessHeaderLocations.contains(colIndex) && colIndex < headers.size() && c.getContents() != null){
					t.set(headers.get(colIndex), c.getContents());
				}
				colIndex++;
			}
			cw.writeRow(t);
		}
		cw.close();
		return true;
	}
}