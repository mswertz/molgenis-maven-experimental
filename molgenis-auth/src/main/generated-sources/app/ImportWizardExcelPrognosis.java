
/* Date:        October 22, 2012
 * 
 * generator:   org.molgenis.generators.excel.ImportWizardExcelPrognosisGen 4.0.0-testing
 *
 * 
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package app;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import jxl.Sheet;
import jxl.Workbook;
import org.molgenis.auth.MolgenisRole;
import org.molgenis.auth.excel.MolgenisRoleExcelReader;
import org.molgenis.auth.MolgenisGroup;
import org.molgenis.auth.excel.MolgenisGroupExcelReader;
import org.molgenis.auth.MolgenisRoleGroupLink;
import org.molgenis.auth.excel.MolgenisRoleGroupLinkExcelReader;
import org.molgenis.auth.Person;
import org.molgenis.auth.excel.PersonExcelReader;
import org.molgenis.auth.Institute;
import org.molgenis.auth.excel.InstituteExcelReader;
import org.molgenis.auth.MolgenisUser;
import org.molgenis.auth.excel.MolgenisUserExcelReader;
import org.molgenis.auth.MolgenisPermission;
import org.molgenis.auth.excel.MolgenisPermissionExcelReader;
import org.molgenis.core.OntologyTerm;
import org.molgenis.core.excel.OntologyTermExcelReader;
import org.molgenis.core.Ontology;
import org.molgenis.core.excel.OntologyExcelReader;
import org.molgenis.core.MolgenisFile;
import org.molgenis.core.excel.MolgenisFileExcelReader;
import org.molgenis.core.RuntimeProperty;
import org.molgenis.core.excel.RuntimePropertyExcelReader;
import org.molgenis.core.Publication;
import org.molgenis.core.excel.PublicationExcelReader;
import org.molgenis.core.UseCase;
import org.molgenis.core.excel.UseCaseExcelReader;
import org.molgenis.core.MolgenisEntity;
import org.molgenis.core.excel.MolgenisEntityExcelReader;

public class ImportWizardExcelPrognosis {

	// map of all sheets, and whether they are importable (recognized) or not
	private Map<String, Boolean> sheetsImportable = new HashMap<String, Boolean>();

	// map of importable sheets and their importable fields
	private Map<String, List<String>> fieldsImportable = new HashMap<String, List<String>>();

	// map of importable sheets and their unknown fields
	private Map<String, List<String>> fieldsUnknown = new HashMap<String, List<String>>();

	// import order of the sheets
	private List<String> importOrder = new ArrayList<String>();

	public ImportWizardExcelPrognosis(File excelFile) throws Exception {

		Workbook workbook = Workbook.getWorkbook(excelFile);
		ArrayList<String> lowercasedSheetNames = new ArrayList<String>();
		Map<String, String> lowerToOriginalName = new HashMap<String, String>();

		try {

			for (String sheetName : workbook.getSheetNames()) {
				lowercasedSheetNames.add(sheetName.toLowerCase());
				lowerToOriginalName.put(sheetName.toLowerCase(), sheetName);
			}

			if (lowercasedSheetNames.contains("molgenisrole")) {
				String originalSheetname = lowerToOriginalName.get("molgenisrole");
				Sheet sheet = workbook.getSheet(originalSheetname);
				MolgenisRoleExcelReader excelReader = new MolgenisRoleExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				MolgenisRole entity = new MolgenisRole();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("molgenisgroup")) {
				String originalSheetname = lowerToOriginalName.get("molgenisgroup");
				Sheet sheet = workbook.getSheet(originalSheetname);
				MolgenisGroupExcelReader excelReader = new MolgenisGroupExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				MolgenisGroup entity = new MolgenisGroup();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("institute")) {
				String originalSheetname = lowerToOriginalName.get("institute");
				Sheet sheet = workbook.getSheet(originalSheetname);
				InstituteExcelReader excelReader = new InstituteExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Institute entity = new Institute();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("ontology")) {
				String originalSheetname = lowerToOriginalName.get("ontology");
				Sheet sheet = workbook.getSheet(originalSheetname);
				OntologyExcelReader excelReader = new OntologyExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Ontology entity = new Ontology();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("ontologyterm")) {
				String originalSheetname = lowerToOriginalName.get("ontologyterm");
				Sheet sheet = workbook.getSheet(originalSheetname);
				OntologyTermExcelReader excelReader = new OntologyTermExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				OntologyTerm entity = new OntologyTerm();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("person")) {
				String originalSheetname = lowerToOriginalName.get("person");
				Sheet sheet = workbook.getSheet(originalSheetname);
				PersonExcelReader excelReader = new PersonExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Person entity = new Person();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("molgenisuser")) {
				String originalSheetname = lowerToOriginalName.get("molgenisuser");
				Sheet sheet = workbook.getSheet(originalSheetname);
				MolgenisUserExcelReader excelReader = new MolgenisUserExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				MolgenisUser entity = new MolgenisUser();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("molgenisrolegrouplink")) {
				String originalSheetname = lowerToOriginalName.get("molgenisrolegrouplink");
				Sheet sheet = workbook.getSheet(originalSheetname);
				MolgenisRoleGroupLinkExcelReader excelReader = new MolgenisRoleGroupLinkExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				MolgenisRoleGroupLink entity = new MolgenisRoleGroupLink();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("molgenisfile")) {
				String originalSheetname = lowerToOriginalName.get("molgenisfile");
				Sheet sheet = workbook.getSheet(originalSheetname);
				MolgenisFileExcelReader excelReader = new MolgenisFileExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				MolgenisFile entity = new MolgenisFile();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("runtimeproperty")) {
				String originalSheetname = lowerToOriginalName.get("runtimeproperty");
				Sheet sheet = workbook.getSheet(originalSheetname);
				RuntimePropertyExcelReader excelReader = new RuntimePropertyExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				RuntimeProperty entity = new RuntimeProperty();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("publication")) {
				String originalSheetname = lowerToOriginalName.get("publication");
				Sheet sheet = workbook.getSheet(originalSheetname);
				PublicationExcelReader excelReader = new PublicationExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Publication entity = new Publication();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("usecase")) {
				String originalSheetname = lowerToOriginalName.get("usecase");
				Sheet sheet = workbook.getSheet(originalSheetname);
				UseCaseExcelReader excelReader = new UseCaseExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				UseCase entity = new UseCase();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("molgenisentity")) {
				String originalSheetname = lowerToOriginalName.get("molgenisentity");
				Sheet sheet = workbook.getSheet(originalSheetname);
				MolgenisEntityExcelReader excelReader = new MolgenisEntityExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				MolgenisEntity entity = new MolgenisEntity();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("molgenispermission")) {
				String originalSheetname = lowerToOriginalName.get("molgenispermission");
				Sheet sheet = workbook.getSheet(originalSheetname);
				MolgenisPermissionExcelReader excelReader = new MolgenisPermissionExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				MolgenisPermission entity = new MolgenisPermission();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			
			for(String sheetName : lowerToOriginalName.values()){
				if(importOrder.contains(sheetName)){
					sheetsImportable.put(sheetName, true);
				}else{
					sheetsImportable.put(sheetName, false);
				}
			}

		} catch (Exception e) {
			throw e;
		} finally {
			workbook.close();
		}
	}
	
	public void headersToMaps(String originalSheetname, List<String> allHeaders, Vector<String> fields){
		List<String> importableHeaders = new ArrayList<String>();
		List<String> unknownHeaders = new ArrayList<String>();
		for (String header : allHeaders) {
			boolean headerIsKnown = false;
			for (String field : fields) {
				if (field.toLowerCase().equals(header.toLowerCase())) {
					headerIsKnown = true;
					break;
				}
			}
			if(headerIsKnown){
				importableHeaders.add(header);
			}else{
				unknownHeaders.add(header);
			}
		}
		importOrder.add(originalSheetname);
		fieldsImportable.put(originalSheetname, importableHeaders);
		fieldsUnknown.put(originalSheetname, unknownHeaders);
	}

	public Map<String, Boolean> getSheetsImportable() {
		return sheetsImportable;
	}

	public Map<String, List<String>> getFieldsImportable() {
		return fieldsImportable;
	}

	public Map<String, List<String>> getFieldsUnknown() {
		return fieldsUnknown;
	}

	public List<String> getImportOrder() {
		return importOrder;
	}
}