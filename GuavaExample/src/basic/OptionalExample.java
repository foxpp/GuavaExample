package basic;

import com.google.common.base.Optional;

public class OptionalExample {
	
	public static void crash(){
		Optional<Integer> crashMan = Optional.of(null);	
	}
	
	public static void ofTest(Integer aInt){
		Optional<Integer> checkMan = Optional.of(aInt);
		System.out.println(checkMan.get());
	}
	public static void main(String[] args) {
		
	}
}
