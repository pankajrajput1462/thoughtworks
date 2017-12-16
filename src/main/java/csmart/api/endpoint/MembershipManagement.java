package csmart.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import csmart.api.model.Book;
import csmart.api.model.User;
import csmart.api.service.BookService;
import csmart.api.service.RestResponse;
import csmart.api.service.UserService;

@RestController
public class MembershipManagement {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;

	@PostMapping(path = "/user-registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE )
	public RestResponse userRagistration(@RequestBody User user) {
		return userService.ragisterUser(user);

	}

	@GetMapping(path = "/user-validation",  produces =MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User userValidation(@RequestParam(name="emailId", required=false) String emailid) {
		return userService.validateUser(emailid);

	}

	@PostMapping(path = "/user-update", consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RestResponse userUpdate(@RequestBody User user,@RequestParam(name="emailId") String emailId) {
		return userService.userUpdate(user,emailId);

	}

	@DeleteMapping(path = "/user-delete", produces =MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public RestResponse userDelete(@RequestParam(name = "emailId", required = true) String emailId) {
		return userService.deleteUserAccount(emailId);

	}

	@PostMapping(path = "/user-account-activate", consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String userAccountActivate(@RequestParam(name = "userId", required = true) String userId,
			@RequestParam(name = "mobileNo", required = true) String mobileNo,
			@RequestParam(name="emailId",required=true) String emailId) {
		return bookService.accountActivate(userId,mobileNo,emailId);

	}

	@PostMapping(path = "/user-account-deactivate", consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String userAccountDeactivate(@RequestParam(name = "userId", required = true) String userId,
			@RequestParam(name = "mobileNo", required = true) String mobileNo,
			@RequestParam(name="emailId",required=true) String emailId) {
		return bookService.accountDeActivate(userId,mobileNo,emailId);

	}

	@PostMapping(path = "/user-subscription",consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String userSubscription(@RequestParam(name = "userId", required = true) String userId,
			@RequestParam(name = "mobileNo", required = false) String mobileNo,
			@RequestParam(name="emailId",required=false) String emailId) {
		return bookService.subscription(userId,mobileNo,emailId);

	}

	@PostMapping(path = "/user-unsubscription", consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String userUsubscription(@RequestParam(name = "userId", required = true) String userId,
			@RequestParam(name = "mobileNo", required = false) String mobileNo,
			@RequestParam(name="emailId",required=false) String emailId) {
		return bookService.unsubscription(userId, mobileNo, emailId);

	}
	
	@PostMapping(path = "/user-booksinfo", consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Book userBookInfo(@RequestParam(name = "bookName", required = true) String bookName,
			@RequestParam(name = "bookId", required = false) String bookId,
			@RequestParam(name="autherName",required=false) String autherName) {
		return bookService.getBookInfo(bookId,bookName,autherName);

	}

}
