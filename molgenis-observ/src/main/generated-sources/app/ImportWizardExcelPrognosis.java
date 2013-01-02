
/* Date:        October 11, 2012
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
import org.molgenis.pheno.Species;
import org.molgenis.pheno.excel.SpeciesExcelReader;
import org.molgenis.pheno.AlternateId;
import org.molgenis.pheno.excel.AlternateIdExcelReader;
import org.molgenis.pheno.ObservationElement;
import org.molgenis.pheno.excel.ObservationElementExcelReader;
import org.molgenis.pheno.ObservationTarget;
import org.molgenis.pheno.excel.ObservationTargetExcelReader;
import org.molgenis.pheno.ObservableFeature;
import org.molgenis.pheno.excel.ObservableFeatureExcelReader;
import org.molgenis.pheno.Measurement;
import org.molgenis.pheno.excel.MeasurementExcelReader;
import org.molgenis.pheno.Category;
import org.molgenis.pheno.excel.CategoryExcelReader;
import org.molgenis.pheno.Individual;
import org.molgenis.pheno.excel.IndividualExcelReader;
import org.molgenis.pheno.Location;
import org.molgenis.pheno.excel.LocationExcelReader;
import org.molgenis.pheno.Panel;
import org.molgenis.pheno.excel.PanelExcelReader;
import org.molgenis.pheno.ObservedValue;
import org.molgenis.pheno.excel.ObservedValueExcelReader;
import org.molgenis.organization.Investigation;
import org.molgenis.organization.excel.InvestigationExcelReader;
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
import org.molgenis.protocol.Protocol;
import org.molgenis.protocol.excel.ProtocolExcelReader;
import org.molgenis.protocol.ProtocolApplication;
import org.molgenis.protocol.excel.ProtocolApplicationExcelReader;
import org.molgenis.protocol.ProtocolDocument;
import org.molgenis.protocol.excel.ProtocolDocumentExcelReader;
import org.molgenis.protocol.Workflow;
import org.molgenis.protocol.excel.WorkflowExcelReader;
import org.molgenis.protocol.WorkflowElement;
import org.molgenis.protocol.excel.WorkflowElementExcelReader;
import org.molgenis.protocol.WorkflowElementParameter;
import org.molgenis.protocol.excel.WorkflowElementParameterExcelReader;
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
import org.molgenis.pheno.ObservationElement_Ontolo12449;
import org.molgenis.pheno.excel.ObservationElement_Ontolo12449ExcelReader;
import org.molgenis.pheno.ObservationElement_AlternateId;
import org.molgenis.pheno.excel.ObservationElement_AlternateIdExcelReader;
import org.molgenis.pheno.Measurement_Categories;
import org.molgenis.pheno.excel.Measurement_CategoriesExcelReader;
import org.molgenis.pheno.Panel_Individuals;
import org.molgenis.pheno.excel.Panel_IndividualsExcelReader;
import org.molgenis.pheno.Panel_FounderPanels;
import org.molgenis.pheno.excel.Panel_FounderPanelsExcelReader;
import org.molgenis.organization.Investigation_Contacts;
import org.molgenis.organization.excel.Investigation_ContactsExcelReader;
import org.molgenis.protocol.Protocol_OntologyReference;
import org.molgenis.protocol.excel.Protocol_OntologyReferenceExcelReader;
import org.molgenis.protocol.Protocol_Features;
import org.molgenis.protocol.excel.Protocol_FeaturesExcelReader;
import org.molgenis.protocol.Protocol_Subprotocols;
import org.molgenis.protocol.excel.Protocol_SubprotocolsExcelReader;
import org.molgenis.protocol.ProtocolApplication_Ontol11768;
import org.molgenis.protocol.excel.ProtocolApplication_Ontol11768ExcelReader;
import org.molgenis.protocol.ProtocolApplication_Performer;
import org.molgenis.protocol.excel.ProtocolApplication_PerformerExcelReader;
import org.molgenis.protocol.WorkflowElement_PreviousSteps;
import org.molgenis.protocol.excel.WorkflowElement_PreviousStepsExcelReader;

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

			if (lowercasedSheetNames.contains("ontology")) {
				String originalSheetname = lowerToOriginalName.get("ontology");
				Sheet sheet = workbook.getSheet(originalSheetname);
				OntologyExcelReader excelReader = new OntologyExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Ontology entity = new Ontology();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("species")) {
				String originalSheetname = lowerToOriginalName.get("species");
				Sheet sheet = workbook.getSheet(originalSheetname);
				SpeciesExcelReader excelReader = new SpeciesExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Species entity = new Species();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("alternateid")) {
				String originalSheetname = lowerToOriginalName.get("alternateid");
				Sheet sheet = workbook.getSheet(originalSheetname);
				AlternateIdExcelReader excelReader = new AlternateIdExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				AlternateId entity = new AlternateId();
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
			if (lowercasedSheetNames.contains("person")) {
				String originalSheetname = lowerToOriginalName.get("person");
				Sheet sheet = workbook.getSheet(originalSheetname);
				PersonExcelReader excelReader = new PersonExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Person entity = new Person();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("investigation")) {
				String originalSheetname = lowerToOriginalName.get("investigation");
				Sheet sheet = workbook.getSheet(originalSheetname);
				InvestigationExcelReader excelReader = new InvestigationExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Investigation entity = new Investigation();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("observationelement")) {
				String originalSheetname = lowerToOriginalName.get("observationelement");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ObservationElementExcelReader excelReader = new ObservationElementExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				ObservationElement entity = new ObservationElement();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("observationtarget")) {
				String originalSheetname = lowerToOriginalName.get("observationtarget");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ObservationTargetExcelReader excelReader = new ObservationTargetExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				ObservationTarget entity = new ObservationTarget();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("observablefeature")) {
				String originalSheetname = lowerToOriginalName.get("observablefeature");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ObservableFeatureExcelReader excelReader = new ObservableFeatureExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				ObservableFeature entity = new ObservableFeature();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("category")) {
				String originalSheetname = lowerToOriginalName.get("category");
				Sheet sheet = workbook.getSheet(originalSheetname);
				CategoryExcelReader excelReader = new CategoryExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Category entity = new Category();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("measurement")) {
				String originalSheetname = lowerToOriginalName.get("measurement");
				Sheet sheet = workbook.getSheet(originalSheetname);
				MeasurementExcelReader excelReader = new MeasurementExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Measurement entity = new Measurement();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("individual")) {
				String originalSheetname = lowerToOriginalName.get("individual");
				Sheet sheet = workbook.getSheet(originalSheetname);
				IndividualExcelReader excelReader = new IndividualExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Individual entity = new Individual();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("location")) {
				String originalSheetname = lowerToOriginalName.get("location");
				Sheet sheet = workbook.getSheet(originalSheetname);
				LocationExcelReader excelReader = new LocationExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Location entity = new Location();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("panel")) {
				String originalSheetname = lowerToOriginalName.get("panel");
				Sheet sheet = workbook.getSheet(originalSheetname);
				PanelExcelReader excelReader = new PanelExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Panel entity = new Panel();
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
			if (lowercasedSheetNames.contains("protocol")) {
				String originalSheetname = lowerToOriginalName.get("protocol");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ProtocolExcelReader excelReader = new ProtocolExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Protocol entity = new Protocol();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("workflow")) {
				String originalSheetname = lowerToOriginalName.get("workflow");
				Sheet sheet = workbook.getSheet(originalSheetname);
				WorkflowExcelReader excelReader = new WorkflowExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Workflow entity = new Workflow();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("protocolapplication")) {
				String originalSheetname = lowerToOriginalName.get("protocolapplication");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ProtocolApplicationExcelReader excelReader = new ProtocolApplicationExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				ProtocolApplication entity = new ProtocolApplication();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("observedvalue")) {
				String originalSheetname = lowerToOriginalName.get("observedvalue");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ObservedValueExcelReader excelReader = new ObservedValueExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				ObservedValue entity = new ObservedValue();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("protocoldocument")) {
				String originalSheetname = lowerToOriginalName.get("protocoldocument");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ProtocolDocumentExcelReader excelReader = new ProtocolDocumentExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				ProtocolDocument entity = new ProtocolDocument();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("workflowelement")) {
				String originalSheetname = lowerToOriginalName.get("workflowelement");
				Sheet sheet = workbook.getSheet(originalSheetname);
				WorkflowElementExcelReader excelReader = new WorkflowElementExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				WorkflowElement entity = new WorkflowElement();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("workflowelementparameter")) {
				String originalSheetname = lowerToOriginalName.get("workflowelementparameter");
				Sheet sheet = workbook.getSheet(originalSheetname);
				WorkflowElementParameterExcelReader excelReader = new WorkflowElementParameterExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				WorkflowElementParameter entity = new WorkflowElementParameter();
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
			if (lowercasedSheetNames.contains("molgenispermission")) {
				String originalSheetname = lowerToOriginalName.get("molgenispermission");
				Sheet sheet = workbook.getSheet(originalSheetname);
				MolgenisPermissionExcelReader excelReader = new MolgenisPermissionExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				MolgenisPermission entity = new MolgenisPermission();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("observationelement_ontolo12449")) {
				String originalSheetname = lowerToOriginalName.get("observationelement_ontolo12449");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ObservationElement_Ontolo12449ExcelReader excelReader = new ObservationElement_Ontolo12449ExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				ObservationElement_Ontolo12449 entity = new ObservationElement_Ontolo12449();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("observationelement_alternateid")) {
				String originalSheetname = lowerToOriginalName.get("observationelement_alternateid");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ObservationElement_AlternateIdExcelReader excelReader = new ObservationElement_AlternateIdExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				ObservationElement_AlternateId entity = new ObservationElement_AlternateId();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("measurement_categories")) {
				String originalSheetname = lowerToOriginalName.get("measurement_categories");
				Sheet sheet = workbook.getSheet(originalSheetname);
				Measurement_CategoriesExcelReader excelReader = new Measurement_CategoriesExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Measurement_Categories entity = new Measurement_Categories();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("panel_individuals")) {
				String originalSheetname = lowerToOriginalName.get("panel_individuals");
				Sheet sheet = workbook.getSheet(originalSheetname);
				Panel_IndividualsExcelReader excelReader = new Panel_IndividualsExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Panel_Individuals entity = new Panel_Individuals();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("panel_founderpanels")) {
				String originalSheetname = lowerToOriginalName.get("panel_founderpanels");
				Sheet sheet = workbook.getSheet(originalSheetname);
				Panel_FounderPanelsExcelReader excelReader = new Panel_FounderPanelsExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Panel_FounderPanels entity = new Panel_FounderPanels();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("investigation_contacts")) {
				String originalSheetname = lowerToOriginalName.get("investigation_contacts");
				Sheet sheet = workbook.getSheet(originalSheetname);
				Investigation_ContactsExcelReader excelReader = new Investigation_ContactsExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Investigation_Contacts entity = new Investigation_Contacts();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("protocol_ontologyreference")) {
				String originalSheetname = lowerToOriginalName.get("protocol_ontologyreference");
				Sheet sheet = workbook.getSheet(originalSheetname);
				Protocol_OntologyReferenceExcelReader excelReader = new Protocol_OntologyReferenceExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Protocol_OntologyReference entity = new Protocol_OntologyReference();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("protocol_features")) {
				String originalSheetname = lowerToOriginalName.get("protocol_features");
				Sheet sheet = workbook.getSheet(originalSheetname);
				Protocol_FeaturesExcelReader excelReader = new Protocol_FeaturesExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Protocol_Features entity = new Protocol_Features();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("protocol_subprotocols")) {
				String originalSheetname = lowerToOriginalName.get("protocol_subprotocols");
				Sheet sheet = workbook.getSheet(originalSheetname);
				Protocol_SubprotocolsExcelReader excelReader = new Protocol_SubprotocolsExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				Protocol_Subprotocols entity = new Protocol_Subprotocols();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("protocolapplication_ontol11768")) {
				String originalSheetname = lowerToOriginalName.get("protocolapplication_ontol11768");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ProtocolApplication_Ontol11768ExcelReader excelReader = new ProtocolApplication_Ontol11768ExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				ProtocolApplication_Ontol11768 entity = new ProtocolApplication_Ontol11768();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("protocolapplication_performer")) {
				String originalSheetname = lowerToOriginalName.get("protocolapplication_performer");
				Sheet sheet = workbook.getSheet(originalSheetname);
				ProtocolApplication_PerformerExcelReader excelReader = new ProtocolApplication_PerformerExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				ProtocolApplication_Performer entity = new ProtocolApplication_Performer();
				headersToMaps(originalSheetname, allHeaders, entity.getFields());
			}
			if (lowercasedSheetNames.contains("workflowelement_previoussteps")) {
				String originalSheetname = lowerToOriginalName.get("workflowelement_previoussteps");
				Sheet sheet = workbook.getSheet(originalSheetname);
				WorkflowElement_PreviousStepsExcelReader excelReader = new WorkflowElement_PreviousStepsExcelReader();
				List<String> allHeaders = excelReader.getNonEmptyHeaders(sheet);
				WorkflowElement_PreviousSteps entity = new WorkflowElement_PreviousSteps();
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