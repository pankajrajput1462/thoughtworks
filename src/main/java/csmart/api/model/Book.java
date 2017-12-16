package csmart.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	private int book_Id;
	private String book_Name;
	private String book_Auther;
	private String catagary;
}
