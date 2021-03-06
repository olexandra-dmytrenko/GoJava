package ua.com.goit.gojava4.anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {
	public static final String SEPARATOR = " ";

	private String lineOfWords;

	public Anagram(String lineOfWords) {
		this.lineOfWords = lineOfWords;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("Input words (or 'exit'):");
			String line = reader.readLine();
			if ("exit".equalsIgnoreCase(line)) {
				break;
			}

			System.out.println(new Anagram(line).getAnagramLine());
		}

		reader.close();
	}

	public String getAnagramLine() {
		String[] words = lineOfWords.split(SEPARATOR);
		reverseEachOf(words);
		return composeLine(words);
	}

	private void reverseEachOf(String[] words) {
		for (int index = 0; index < words.length; index++) {
			String word = words[index];
			words[index] = reverse(word);
		}
	}

	private String reverse(String word) {
		StringBuilder result = new StringBuilder(word);
		result.reverse();
		return result.toString();
	}

	private String composeLine(String[] words) {
		StringBuilder result = new StringBuilder();
		for (String word : words) {
			result.append(word);
			result.append(SEPARATOR);
		}
		return result.toString();
	}
}
