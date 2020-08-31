package by.epamtc.textprocessing.server.dao.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import by.epamtc.textprocessing.common.bean.PunctuationMark;
import by.epamtc.textprocessing.common.bean.Sentence;
import by.epamtc.textprocessing.common.bean.TextBlockComponent;
import by.epamtc.textprocessing.common.bean.TextBlockComponentType;
import by.epamtc.textprocessing.common.bean.Word;
import by.epamtc.textprocessing.server.dao.reader.PropertyReader;

public class TextBlockParser {
	private static final TextBlockParser INSTANCE = new TextBlockParser();

	private TextBlockParser() {
	}

	public static TextBlockParser getInstance() {
		return INSTANCE;
	}

	private SentenceParser sentenceParser = SentenceParser.getInstance();

	private static String parserBySentenceRegex = PropertyReader.getInstance().parseBySentenceRegex();
	
	private static Pattern pattern = Pattern.compile(parserBySentenceRegex);

	public List<Sentence> parse(String textBlock) {
		List<Sentence> tetxBlockSentences = new ArrayList<>();
		Matcher matcher = pattern.matcher(textBlock);
		String unnecessaryHyphenation = "[\n]{1,}";
		Sentence sentence;

		while (matcher.find()) {
			sentence = new Sentence(matcher.group().replaceAll(unnecessaryHyphenation, ""));

			List<TextBlockComponent> textBlockComponents = sentenceParser.parse(sentence.getSentence());
			for (TextBlockComponent textComponent : textBlockComponents) {
				if (textComponent.getType() == TextBlockComponentType.WORD) {
					sentence.setWord((Word) textComponent);
				} else {
					sentence.setPunctuationMark((PunctuationMark) textComponent);
				}
			}
			tetxBlockSentences.add(sentence);
		}
		return tetxBlockSentences;
	}
}
