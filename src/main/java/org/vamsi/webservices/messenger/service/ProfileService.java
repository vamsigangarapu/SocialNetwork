/**
 * 
 */
package org.vamsi.webservices.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.vamsi.webservices.messenger.database.DatabaseClass;
import org.vamsi.webservices.messenger.model.Profile;

/**
 * @author vamsi
 *
 */
public class ProfileService {

	public Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	/**
	 * @param profiles
	 */
	public ProfileService() {
		profiles.put("vamsi", new Profile(1L, "vamsi", "Vamsi", "Krishna"));
	}

	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile deleteProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
