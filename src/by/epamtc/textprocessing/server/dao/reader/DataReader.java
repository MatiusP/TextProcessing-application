package by.epamtc.textprocessing.server.dao.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import by.epamtc.textprocessing.server.dao.exception.DAOException;

public class DataReader {
	private static final String FILE_PATH = "./resources/";

	public String readSourceFile(String fileName) throws DAOException {
		String sourceFileName = FILE_PATH + fileName;

		StringBuilder textFromDataSource = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(sourceFileName))) {
			String line;

			while ((line = reader.readLine()) != null) {
				textFromDataSource.append(line).append("\n");
			}
		} catch (IOException e) {
			throw new DAOException(e);
		}
		return textFromDataSource.toString();
	}
}
