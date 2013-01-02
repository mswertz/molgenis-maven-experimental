/* File:        observ/model/JDBCDatabase
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * 
 * generator:   org.molgenis.generators.db.JDBCDatabaseGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */

package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import java.sql.Connection;
import org.molgenis.MolgenisOptions;
import org.molgenis.framework.db.DatabaseException;
import org.molgenis.framework.db.jdbc.DataSourceWrapper;
import org.molgenis.framework.db.jdbc.SimpleDataSourceWrapper;
import org.molgenis.model.elements.Model;
import org.apache.commons.dbcp.BasicDataSource;


public class JDBCDatabase extends org.molgenis.framework.db.jdbc.JDBCDatabase
{
	private JDBCMetaDatabase metaData = null;
	

	public JDBCDatabase(Connection conn) throws DatabaseException
	{
		super(conn);
		this.setup();
		
	}

	public JDBCDatabase(DataSource data_src, File file_source) throws DatabaseException
	{
		this(new SimpleDataSourceWrapper(data_src), file_source);
	}

	public JDBCDatabase(DataSourceWrapper data_src, File file_src) throws DatabaseException
	{
		super(data_src, file_src);
		this.setup();
		
	}

	public JDBCDatabase(Properties p) throws DatabaseException
	{
		super(p);
		this.setup();
		
	}
	
	public JDBCDatabase(MolgenisOptions options) throws DatabaseException
	{
		super(options);
		this.setup();
		
	}
	
	@Deprecated
	public JDBCDatabase() throws DatabaseException
	{
		super((DataSource)JDBCDatabase.createDataSource(), new File("attachedfiles/"));
		this.setup();
		
	}

	@Deprecated
	private static DataSource createDataSource() {
		BasicDataSource data_src = new BasicDataSource();
		data_src.setDriverClassName("com.mysql.jdbc.Driver");
		data_src.setUsername("molgenis");
		data_src.setPassword("molgenis");
		data_src.setUrl("jdbc:mysql://localhost/animaldb_pheno?innodb_autoinc_lock_mode=2"); // a path within the src folder?
		data_src.setMaxIdle(10);
		data_src.setMaxWait(1000);
		return (DataSource)data_src;	
	}

	public JDBCDatabase(String propertiesFilePath) throws FileNotFoundException, IOException, DatabaseException
	{
		super(propertiesFilePath);
		this.setup();
		
	}
	
	private void setup()
	{
		this.putMapper(org.molgenis.core.Ontology.class, new decorators.NameableDecorator(new org.molgenis.core.db.OntologyMapper(this)));
		this.putMapper(org.molgenis.pheno.Species.class, new org.molgenis.pheno.db.SpeciesMapper(this));
		this.putMapper(org.molgenis.pheno.AlternateId.class, new org.molgenis.pheno.db.AlternateIdMapper(this));
		this.putMapper(org.molgenis.core.OntologyTerm.class, new decorators.NameableDecorator(new org.molgenis.core.db.OntologyTermMapper(this)));
		this.putMapper(org.molgenis.core.MolgenisFile.class, new decorators.MolgenisFileDecorator(new org.molgenis.core.db.MolgenisFileMapper(this)));
		this.putMapper(org.molgenis.core.RuntimeProperty.class, new decorators.NameableDecorator(new org.molgenis.core.db.RuntimePropertyMapper(this)));
		this.putMapper(org.molgenis.core.Publication.class, new decorators.NameableDecorator(new org.molgenis.core.db.PublicationMapper(this)));
		this.putMapper(org.molgenis.core.UseCase.class, new org.molgenis.core.db.UseCaseMapper(this));
		this.putMapper(org.molgenis.core.MolgenisEntity.class, new org.molgenis.core.db.MolgenisEntityMapper(this));
		this.putMapper(org.molgenis.auth.MolgenisRole.class, new org.molgenis.auth.db.MolgenisRoleMapper(this));
		this.putMapper(org.molgenis.auth.MolgenisGroup.class, new org.molgenis.auth.db.MolgenisGroupMapper(this));
		this.putMapper(org.molgenis.auth.Institute.class, new org.molgenis.auth.db.InstituteMapper(this));
		this.putMapper(org.molgenis.auth.Person.class, new org.molgenis.auth.db.PersonMapper(this));
		this.putMapper(org.molgenis.organization.Investigation.class, new decorators.NameableDecorator(new org.molgenis.organization.db.InvestigationMapper(this)));
		this.putMapper(org.molgenis.pheno.ObservationElement.class, new org.molgenis.pheno.db.ObservationElementMapper(this));
		this.putMapper(org.molgenis.pheno.ObservationTarget.class, new org.molgenis.pheno.db.ObservationTargetMapper(this));
		this.putMapper(org.molgenis.pheno.ObservableFeature.class, new org.molgenis.pheno.db.ObservableFeatureMapper(this));
		this.putMapper(org.molgenis.pheno.Category.class, new org.molgenis.pheno.db.CategoryMapper(this));
		this.putMapper(org.molgenis.pheno.Measurement.class, new org.molgenis.observ.decorators.MeasurementDecorator(new org.molgenis.pheno.db.MeasurementMapper(this)));
		this.putMapper(org.molgenis.pheno.Individual.class, new org.molgenis.pheno.db.IndividualMapper(this));
		this.putMapper(org.molgenis.pheno.Location.class, new org.molgenis.pheno.db.LocationMapper(this));
		this.putMapper(org.molgenis.pheno.Panel.class, new org.molgenis.pheno.db.PanelMapper(this));
		this.putMapper(org.molgenis.auth.MolgenisUser.class, new decorators.MolgenisUserDecorator(new org.molgenis.auth.db.MolgenisUserMapper(this)));
		this.putMapper(org.molgenis.protocol.Protocol.class, new decorators.NameableDecorator(new org.molgenis.protocol.db.ProtocolMapper(this)));
		this.putMapper(org.molgenis.protocol.Workflow.class, new decorators.NameableDecorator(new org.molgenis.protocol.db.WorkflowMapper(this)));
		this.putMapper(org.molgenis.protocol.ProtocolApplication.class, new decorators.NameableDecorator(new org.molgenis.protocol.db.ProtocolApplicationMapper(this)));
		this.putMapper(org.molgenis.pheno.ObservedValue.class, new org.molgenis.pheno.db.ObservedValueMapper(this));
		this.putMapper(org.molgenis.protocol.ProtocolDocument.class, new decorators.MolgenisFileDecorator(new org.molgenis.protocol.db.ProtocolDocumentMapper(this)));
		this.putMapper(org.molgenis.protocol.WorkflowElement.class, new decorators.NameableDecorator(new org.molgenis.protocol.db.WorkflowElementMapper(this)));
		this.putMapper(org.molgenis.protocol.WorkflowElementParameter.class, new org.molgenis.protocol.db.WorkflowElementParameterMapper(this));
		this.putMapper(org.molgenis.auth.MolgenisRoleGroupLink.class, new org.molgenis.auth.db.MolgenisRoleGroupLinkMapper(this));
		this.putMapper(org.molgenis.auth.MolgenisPermission.class, new org.molgenis.auth.db.MolgenisPermissionMapper(this));
		this.putMapper(org.molgenis.pheno.ObservationElement_Ontolo12449.class, new org.molgenis.pheno.db.ObservationElement_Ontolo12449Mapper(this));
		this.putMapper(org.molgenis.pheno.ObservationElement_AlternateId.class, new org.molgenis.pheno.db.ObservationElement_AlternateIdMapper(this));
		this.putMapper(org.molgenis.pheno.Measurement_Categories.class, new org.molgenis.pheno.db.Measurement_CategoriesMapper(this));
		this.putMapper(org.molgenis.pheno.Panel_Individuals.class, new org.molgenis.pheno.db.Panel_IndividualsMapper(this));
		this.putMapper(org.molgenis.pheno.Panel_FounderPanels.class, new org.molgenis.pheno.db.Panel_FounderPanelsMapper(this));
		this.putMapper(org.molgenis.organization.Investigation_Contacts.class, new org.molgenis.organization.db.Investigation_ContactsMapper(this));
		this.putMapper(org.molgenis.protocol.Protocol_OntologyReference.class, new org.molgenis.protocol.db.Protocol_OntologyReferenceMapper(this));
		this.putMapper(org.molgenis.protocol.Protocol_Features.class, new org.molgenis.protocol.db.Protocol_FeaturesMapper(this));
		this.putMapper(org.molgenis.protocol.Protocol_Subprotocols.class, new org.molgenis.protocol.db.Protocol_SubprotocolsMapper(this));
		this.putMapper(org.molgenis.protocol.ProtocolApplication_Ontol11768.class, new org.molgenis.protocol.db.ProtocolApplication_Ontol11768Mapper(this));
		this.putMapper(org.molgenis.protocol.ProtocolApplication_Performer.class, new org.molgenis.protocol.db.ProtocolApplication_PerformerMapper(this));
		this.putMapper(org.molgenis.protocol.WorkflowElement_PreviousSteps.class, new org.molgenis.protocol.db.WorkflowElement_PreviousStepsMapper(this));
	}
	
	
	
	@Override
	public Model getMetaData() throws DatabaseException
	{
		//load on demand.
		//nb: the JDBCMetaDatabase must be made much faster which is done in the generator
		//because now it is still validating which it shouldn't
		if(metaData == null)
			metaData = new JDBCMetaDatabase();
		return metaData;
	}
	
}