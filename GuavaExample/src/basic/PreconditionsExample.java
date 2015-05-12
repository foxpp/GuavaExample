package basic;

import static com.google.common.base.Preconditions.*;

public class PreconditionsExample {
	static void checkArgumentTest(int a ){
		checkArgument(a > 0);
		checkArgument(a > 0," a  <= 0");
		checkArgument(a > 10, "%s is less than 10", a);
	}
	
	
	static void checkNotNullTest(String aString){
		checkNotNull(aString);
		checkNotNull(aString, " string must be not null!");
		checkNotNull(aString, " must be not null", aString);
	}
	
	static void checkStateTest(Integer aInt){
		checkState(aInt.equals(102),"must be 102");
	}
	public static void main(String[] args) {
		//checkArgumentTest(5);
		//checkNotNullTest(null);
		//checkNotNullTest(null);
		//checkStateTest(102);
	}
}
