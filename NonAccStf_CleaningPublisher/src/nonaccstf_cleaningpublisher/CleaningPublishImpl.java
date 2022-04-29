package nonaccstf_cleaningpublisher;

public class CleaningPublishImpl implements CleaningPublish{
	
	String[] Cleaning_Place= {
			"place1", "place2", "place3", "place4",
			"place5", "place6", "place7", "place8",
			"place9", "place10", "place11", "place12",
			"place13", "place14", "place15", "place16",
			"place17", "place18", "place19", "place20",
	};

	@Override
	public boolean cleaningPublish(String place) {
		// TODO Auto-generated method stub
		place= place.toLowerCase();
				
		for(int i=0; i<Cleaning_Place.length; i++)
		{
			if(Cleaning_Place[i].equals(place))
			{
				return true;
			}
		}		
		return false;		
	}	
}
