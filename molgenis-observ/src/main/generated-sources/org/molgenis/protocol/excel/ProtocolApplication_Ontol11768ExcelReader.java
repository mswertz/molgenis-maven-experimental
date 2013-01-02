
/* File:        observ/model/ProtocolApplication_ontol11768.java
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

import org.molgenis.protocol.ProtocolApplication_Ontol11768;
import org.molgenis.protocol.csv.ProtocolApplication_Ontol11768CsvReader;

/**
 * Reads ProtocolApplication_Ontol11768 from Excel file.
 */
public class ProtocolApplication_Ontol11768ExcelReader
{
	public static final transient Logger logger = Logger.getLogger(ProtocolApplication_Ontol11768ExcelReader.class);
			
	/**
	 * Imports ProtocolApplication_Ontol11768 from a workbook sheet.
	 */
	public int importSheet(final Database db, Sheet sheet, final Tuple defaults, final DatabaseAction dbAction, final String missingValue) throws DatabaseException, IOException, Exception 
	{
		File tmpProtocolApplication_Ontol11768 = new File(System.getProperty("java.io.tmpdir") + File.separator + "tmpProtocolApplication_Ontol11768.txt");
		if(tmpProtocolApplication_Ontol11768.exists()){
			boolean deleteSuccess = tmpProtocolApplication_Ontol11768.delete();
			if(!deleteSuccess){
				throw new Exception("Deletion of tmp file 'tmpProtocolApplication_Ontol11768.txt' failed, cannot proceed.");
			}
		}
		boolean createSuccess = tmpProtocolApplication_Ontol11768.createNewFile();
		if(!createSuccess){
			throw new Exception("Creation of tmp file 'tmpProtocolApplication_Ontol11768.txt' failed, cannot proceed.");
		}
		boolean fileHasHeaders = writeSheetToFile(sheet, tmpProtocolApplication_Ontol11768);
		if(fileHasHeaders){
			int count = new ProtocolApplication_Ontol11768CsvReader().importCsv(db, tmpProtocolApplication_Ontol11768, defaults, dbAction, missingValue);
			tmpProtocolApplication_Ontol11768.delete();
			return count;
		}else{
			tmpProtocolApplication_Ontol11768.delete();
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