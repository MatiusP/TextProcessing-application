package by.epamtc.textprocessing.server.dao.impl;

import by.epamtc.textprocessing.common.bean.Text;
import by.epamtc.textprocessing.server.dao.TextDAO;
import by.epamtc.textprocessing.server.dao.parser.SourceTextParser;
import by.epamtc.textprocessing.server.dao.reader.DataReader;

public class TextDAOImpl implements TextDAO {
	private static final String FILE_NAME = "source.txt";

	@Override
	public Text getText() {
		DataReader dataReader = new DataReader();
		SourceTextParser sourceTextParser = SourceTextParser.getInstance();
		String sourceText = dataReader.readSourceFile(FILE_NAME);

		return sourceTextParser.parse(sourceText);
	}
}
