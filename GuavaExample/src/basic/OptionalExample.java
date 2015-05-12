package basic;

import com.google.common.base.Optional;

public class OptionalExample {
	public static void main(String[] args) {
		Optional<Integer> possible = Optional.of(5);
		System.out.println(possible.isPresent());
		System.out.println(possible.get());
	}
}
