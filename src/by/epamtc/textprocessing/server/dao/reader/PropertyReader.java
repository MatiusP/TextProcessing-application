package by.epamtc.textprocessing.server.dao.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import by.epamtc.textprocessing.server.dao.exception.DAOException;

public class PropertyReader {
	private static final String PROPERTY_FILE_NAME = "./resources/regex.properties";
	private static final PropertyReader INSTANCE = new PropertyReader();
	private static Properties property = new Properties();

	private PropertyReader() {
	}

	public static PropertyReader getInstance() {
		return INSTANCE;
	}

	private static Properties readPropertiesFile() {
		try (FileInputStream propertyReader = new FileInputStream(PROPERTY_FILE_NAME)) {
			property.load(propertyReader);
		} catch (IOException e) {
			throw new DAOException(e);
		}
		return property;
	}

	public String parseByTextBlockRegex() {
		return readPropertiesFile().getProperty("parserByTextBlockRegex");
	}

	public String parseByCodeBlockRegex() {
		return readPropertiesFile().getProperty("parserByCodeBlockRegex");
	}

	public String parseBySentenceRegex() {
		return readPropertiesFile().getProperty("parserBySentenceRegex");
	}

	public String parseSentenceByWordsRegex() {
		return readPropertiesFile().getProperty("parserSentenceByWordsRegex");
	}

	public String parseSentenceByPunctuationMarksRegex() {
		return readPropertiesFile().getProperty("parserSentenceByPunctuationMarksRegex");
	}
}
