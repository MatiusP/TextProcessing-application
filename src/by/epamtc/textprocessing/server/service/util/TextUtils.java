package by.epamtc.textprocessing.server.service.util;

import java.util.ArrayList;
import java.util.List;

import by.epamtc.textprocessing.common.bean.Sentence;
import by.epamtc.textprocessing.common.bean.Text;
import by.epamtc.textprocessing.common.bean.TextBlock;
import by.epamtc.textprocessing.common.bean.TextComponent;
import by.epamtc.textprocessing.common.bean.TextComponentType;

public class TextUtils {
	private static final TextUtils INSTANCE = new TextUtils();

	private TextUtils() {
	}

	public static TextUtils getInstance() {
		return INSTANCE;
	}

	private List<TextComponent> getTextComponentsList(Text text) {
		return text.getTextComponents();
	}

	public List<TextBlock> getTextBlocksList(Text text) {
		List<TextComponent> textComponentsList = getTextComponentsList(text);
		List<TextBlock> textBlocksList = new ArrayList<>();

		for (TextComponent component : textComponentsList) {
			if (component.getType() == TextComponentType.TEXT_BLOCK) {
				textBlocksList.add((TextBlock) component);
			}
		}
		return textBlocksList;
	}

	public List<Sentence> getSentencesList(Text text) {
		List<TextBlock> textBlocksList = getTextBlocksList(text);
		List<Sentence> sentencesList = new ArrayList<>();

		for (TextBlock block : textBlocksList) {
			sentencesList.addAll(block.getSentences());
		}
		return sentencesList;
	}
}
