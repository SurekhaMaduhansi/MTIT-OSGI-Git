package std_librarypublisher;

public class LibraryPublishIml implements LibraryPublish{


	String[] Library_Books= {
			"book1", "book2", "book3", "book4",
			"book5", "book6", "book7", "book8",
			"book9", "book10", "book11", "book12",
			"book13", "book14", "book15", "book16",
			"book17", "book18", "book19", "book20",
	};
	
	@Override
	public boolean LibraryPublish(String book) {
	
		book= book.toLowerCase();
		
		for(int i=0; i<Library_Books.length; i++)
		{
			if(Library_Books[i].equals(book))
			{
				return true;
			}
		}
		
		
		return false;
			
	}	
	

}
