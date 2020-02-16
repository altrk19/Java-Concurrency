package com.thread.http.utils;

import java.io.InputStream;

public class ResourceLoader {
	
	private static final String RESOURCE_FOLDER_BASSE = "/resources";

	public InputStream getResource(String uri) {
		return ResourceLoader.class.getResourceAsStream(RESOURCE_FOLDER_BASSE + uri);
	}
}
