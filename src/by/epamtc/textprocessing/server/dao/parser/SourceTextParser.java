package by.epamtc.textprocessing.server.dao.parser;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epamtc.textprocessing.common.bean.CodeBlock;
import by.epamtc.textprocessing.common.bean.Sentence;
import by.epamtc.textprocessing.common.bean.Text;
import by.epamtc.textprocessing.common.bean.TextBlock;
import by.epamtc.textprocessing.common.bean.TextComponent;
import by.epamtc.textprocessing.common.bean.TextComponentType;
import by.epamtc.textprocessing.server.dao.reader.DataReader;
import by.epamtc.textprocessing.server.dao.reader.PropertyReader;

public class SourceTextParser {
	private static final SourceTextParser INSTANCE = new SourceTextParser();

	private SourceTextParser() {
	}

	public static SourceTextParser getInstance() {
		return INSTANCE;
	}

	private TextBlockParser textBlockParser = TextBlockParser.getInstance();

	private static String textBlockRegex = PropertyReader.getInstance().parseByTextBlockRegex();
	private static String codeBlockRegex = PropertyReader.getInstance().parseByCodeBlockRegex();
	private static String parserTextByBlocksRegex = (textBlockRegex + "|" + codeBlockRegex);

	private static Pattern pattern = Pattern.compile(parserTextByBlocksRegex);

	public Text parse(String sourceText) {
		Matcher matcher = pattern.matcher(sourceText);

		Text text = new Text();

		while (matcher.find()) {
			String textBlock = matcher.group("textBlock");
			String codeBlock = matcher.group("codeBlock");

			if (textBlock != null) {
				String tmp = matcher.group();
				TextBlock block = new TextBlock(tmp);
				block.addSentences(textBlockParser.parse(tmp));
				text.addTextComponent(block);
			}

			if (codeBlock != null) {
				text.addTextComponent(new CodeBlock(matcher.group()));
			}
		}
		return text;
	}
}

class Main {
	public static void main(String[] args) {

		SourceTextParser sourceTextParser = SourceTextParser.getInstance();
		DataReader dataReader = new DataReader();
		String sourceText = dataReader.readSourceFile("source.txt");

		Text text = sourceTextParser.parse(sourceText);

		List<TextComponent> textComponents = text.getTextComponents();

		for (TextComponent component : textComponents) {
			if (component.getType() == TextComponentType.TEXT_BLOCK) {
				TextBlock textBlock = (TextBlock) component;
				System.out.print(textBlock);

				List<Sentence> sentences = textBlock.getSentences();
				for (Sentence sentence : sentences) {
					System.out.println(sentence);
					System.out.println(sentence.getWords());
					System.out.println(sentence.getPunctuationMarks());
					System.out.println();
				}
				System.out.println();
			}
		}

	}

}
