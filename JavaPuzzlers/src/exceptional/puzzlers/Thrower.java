package exceptional.puzzlers;

public class Thrower {
	public static void main(String[] args) {
		sneakyThrow(new Exception("This is a checked exception"));
	}

	/*
	 * Provide a body for this method to make it throw the specified exception.
	 * You must not use any deprecated methods.
	 */
	public static void sneakyThrow(Throwable t) {
		//parametrizedThrow(t); // in runtime throws t without cast, because generics are eraser
		Thrower.<RuntimeException> parametrizedThrow(t); // in runtime throws t without cast, because generics are eraser
		//Thrower.<Error> parametrizedThrow(t); // in runtime throws t without cast, because generics are eraser
		//Thrower.<Exception> parametrizedThrow(t); // missing throws clause
		//Thrower.<ExtendedThrowable> parametrizedThrow(t); // missing throws clause
	}

	@SuppressWarnings("unchecked")
	private static <T extends Throwable> void parametrizedThrow(Throwable t) throws T {
		throw (T) t;
	}

	@SuppressWarnings({ "unused", "serial" })
	private static class ExtendedThrowable extends Throwable {
	}
}