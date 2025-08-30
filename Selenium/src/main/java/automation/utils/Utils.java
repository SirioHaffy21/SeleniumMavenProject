package automation.utils;

import java.util.Random;

public class Utils {
	private static String baseEmail = "baseEmail";

	public static String generateRandomString(int length) {
		// Define the character set to be used for the random string
		String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder email = new StringBuilder(); // Use StringBuilder for efficient string construction
		Random random = new Random(); // Create a Random object

		// Loop to append random characters until the desired length is reached
		for (int i = 0; i < length; i++) {
			// Get a random index within the character set
			int index = random.nextInt(characterSet.length());
			// Append the character at the random index to the StringBuilder
			email.append(characterSet.charAt(index));
		}
		// Convert the StringBuilder content to a String and return it
		return baseEmail + email.toString() + "@gmail.com";
	}

	public static String generateRandomCode(int length) {
		// Define the character set to be used for the random string
		String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder result = new StringBuilder(); // Use StringBuilder for efficient string construction
		Random random = new Random(); // Create a Random object

		// Loop to append random characters until the desired length is reached
		for (int i = 0; i < length; i++) {
			// Get a random index within the character set
			int index = random.nextInt(characterSet.length());
			// Append the character at the random index to the StringBuilder
			result.append(characterSet.charAt(index));
		}
		// Convert the StringBuilder content to a String and return it
		return result.toString();
	}
}
