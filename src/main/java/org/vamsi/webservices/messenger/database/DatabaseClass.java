/**
 * 
 */
package org.vamsi.webservices.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.vamsi.webservices.messenger.model.Message;
import org.vamsi.webservices.messenger.model.Profile;

/**
 * @author vamsi
 *
 */
public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	/**
	 * @return the messages
	 */
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	/**
	 * @return the profile
	 */
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
	

}
