package cha_lecattendencepublisher;

public class LecAttendencePublisherIml implements LecAttendencePublisher{

	String[] lecturer = {
			"lec1", "lec2", "lec3", 
			"lec4", "lec5", "lec6",
	};
	
	@Override
	public boolean LecAttendencePublisher(String lec) {
		// TODO Auto-generated method stub
		
		lec = lec.toLowerCase();
		
		for(int i=0; i< lecturer.length;i++) {
			
			if(lecturer[i].equals(lec)) {
				return true;
			}
			
		}
		
		return false;
	}

}
