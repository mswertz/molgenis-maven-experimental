
/* File:        observ/model/ObservationElement_AlternateId.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.excel.ExcelReaderGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package org.molgenis.pheno.excel;

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

import org.molgenis.pheno.ObservationElement_AlternateId;
import org.molgenis.pheno.csv.ObservationElement_AlternateIdCsvReader;

/**
 * Reads ObservationElement_AlternateId from Excel file.
 */
public class ObservationElement_AlternateIdExcelReader
{
	public static final transient Logger logger = Logger.getLogger(ObservationElement_AlternateIdExcelReader.class);
			
	/**
	 * Imports ObservationElement_AlternateId from a workbook sheet.
	 */
	public int importSheet(final Database db, Sheet sheet, final Tuple defaults, final DatabaseAction dbAction, final String missingValue) throws DatabaseException, IOException, Exception 
	{
		File tmpObservationElement_AlternateId = new File(System.getProperty("java.io.tmpdir") + File.separator + "tmpObservationElement_AlternateId.txt");
		if(tmpObservationElement_AlternateId.exists()){
			boolean deleteSuccess = tmpObservationElement_AlternateId.delete();
			if(!deleteSuccess){
				throw new Exception("Deletion of tmp file 'tmpObservationElement_AlternateId.txt' failed, cannot proceed.");
			}
		}
		boolean createSuccess = tmpObservationElement_AlternateId.createNewFile();
		if(!createSuccess){
			throw new Exception("Creation of tmp file 'tmpObservationElement_AlternateId.txt' failed, cannot proceed.");
		}
		boolean fileHasHeaders = writeSheetToFile(sheet, tmpObservationElement_AlternateId);
		if(fileHasHeaders){
			int count = new ObservationElement_AlternateIdCsvReader().importCsv(db, tmpObservationElement_AlternateId, defaults, dbAction, missingValue);
			tmpObservationElement_AlternateId.delete();
			return count;
		}else{
			tmpObservationElement_AlternateId.delete();
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