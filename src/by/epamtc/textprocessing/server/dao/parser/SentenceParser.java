package by.epamtc.textprocessing.server.dao.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epamtc.textprocessing.common.bean.PunctuationMark;
import by.epamtc.textprocessing.common.bean.TextBlockComponent;
import by.epamtc.textprocessing.common.bean.Word;
import by.epamtc.textprocessing.server.dao.reader.PropertyReader;

public class SentenceParser {
	private static final SentenceParser INSTANCE = new SentenceParser();

	private SentenceParser() {
	}

	public static SentenceParser getInstance() {
		return INSTANCE;
	}

	private static String parserByWordsRegex = PropertyReader.getInstance().parseSentenceByWordsRegex();
	private static String parserByPunctuationMarkRegex = PropertyReader.getInstance()
			.parseSentenceByPunctuationMarksRegex();
	private static String parserBySentenceElementsRegex = (parserByWordsRegex + "|" + parserByPunctuationMarkRegex);

	private static Pattern pattern = Pattern.compile(parserBySentenceElementsRegex);

	public List<TextBlockComponent> parse(String sentence) {
		List<TextBlockComponent> sentenceComponents = new ArrayList<>();

		Matcher matcher = pattern.matcher(sentence);

		while (matcher.find()) {
			String word = matcher.group("word");
			String punctuationMark = matcher.group("punctuationMark");

			if (word != null) {
				sentenceComponents.add(new Word(matcher.group()));
			}

			if ((punctuationMark != null) && (!punctuationMark.equals(" "))) {
				sentenceComponents.add(new PunctuationMark(matcher.group()));
			}
		}
		return sentenceComponents;
	}
}
