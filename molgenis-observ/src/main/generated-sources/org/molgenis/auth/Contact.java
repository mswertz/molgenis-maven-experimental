
/* File:        observ/model/Contact.java
 * Copyright:   GBIC 2000-2012, all rights reserved
 * Date:        October 11, 2012
 * Generator:   org.molgenis.generators.DataTypeGen 4.0.0-testing
 *
 * THIS FILE HAS BEEN GENERATED, PLEASE DO NOT EDIT!
 */
 

package org.molgenis.auth;

/**
 * Contact:  A contact is either a person or an organization. Copied
				from FuGE::Contact.
.
 * @version October 11, 2012 
 * @author MOLGENIS generator
 */
public interface Contact extends  org.molgenis.core.Identifiable
{
	public Integer getId();
	public void setId(Integer id);
	public String getAddress();
	public void setAddress(String address);
	public String getPhone();
	public void setPhone(String phone);
	public String getEmail();
	public void setEmail(String email);
	public String getFax();
	public void setFax(String fax);
	public String getTollFreePhone();
	public void setTollFreePhone(String tollFreePhone);
	public String getCity();
	public void setCity(String city);
	public String getCountry();
	public void setCountry(String country);
}

