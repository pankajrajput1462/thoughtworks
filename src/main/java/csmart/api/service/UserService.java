package csmart.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import csmart.api.db.UserRepo;
import csmart.api.model.User;

@Component
public class UserService {

	private static final String USER_RAGISTERED_SUCCESSFULLY = "User Ragistered Successfully";
	private static final String USER_UNAVAILABLE = "User Unavailable";
	private static final String USER_AVAILABLE = "User Available";
	@Autowired
	UserRepo userRepo;
	
	public RestResponse deleteUserAccount(String email) {
		User validateUser = validateUser(email);
		if (validateUser!=null) {
			if (validateUser.equals(USER_AVAILABLE)) {
				return new RestResponse(USER_AVAILABLE);
			} 
		}
		userRepo.deleteAccount(email);
		return new RestResponse("User Deleted Succesfully");
	}

	public RestResponse userUpdate(User user, String emailId) {

		User validateUser = validateUser(user.getEmailid());
		if (validateUser!=null) {
			if (validateUser.equals(USER_AVAILABLE)) {
				return new RestResponse(USER_AVAILABLE);
			} 
		}
		// TODO Auto-generated method stub
		String userUpdate = userRepo.userUpdate(validateUser,emailId);
		return new RestResponse(userUpdate);
				
	}

	public RestResponse ragisterUser(User user) {
		if (user!=null) {
			
			User validateUser = validateUser(user.getEmailid());
			if (validateUser!=null) {
				if (validateUser.equals(USER_AVAILABLE)) {
					return new RestResponse(USER_AVAILABLE);
				} 
			}
			if (isAreaValidForRagistartion(user)) {
				userRepo.createUser(user);
			}
		}
		
		return new RestResponse(USER_RAGISTERED_SUCCESSFULLY);
	}
	
	private boolean isAreaValidForRagistartion(User user) {
		
		return false;
	}

	public User validateUser(String emailid) {
		User user = userRepo.getUser(emailid);
		if (user != null) {
			return user;
		}
		return user;

	}

}
