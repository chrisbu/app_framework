package com.chr12bu.app_framework.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This is an example arbitrary model
 * @author chrisbu
 *
 */
@Document(collection="somemodel")
public class SomeModel {
	
	@Id
	public String id;
	
	public String name;
	public String rootWebsiteUrl;
	
	public SomeModel() {
		
	}
	
	public SomeModel(String name, String url) {
		this.name = name;			
		this.rootWebsiteUrl = url;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRootWebsiteUrl() {
		return rootWebsiteUrl;
	}

	public void setRootWebsiteUrl(String rootWebsiteUrl) {
		this.rootWebsiteUrl = rootWebsiteUrl;
	}

	@Override
	public String toString() {
		return String.format("SomeModel[name=%s, id=%s]", name, id);
	}
}
