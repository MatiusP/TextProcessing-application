package by.epamtc.textprocessing.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TextBlock implements TextComponent, Serializable {
	private static final TextComponentType type = TextComponentType.TEXT_BLOCK;
	private String textBlock;
	private List<Sentence> sentences;

	public TextBlock(String textBlock) {
		this.textBlock = textBlock;
		sentences = new ArrayList<>();
	}

	public String getTextBlock() {
		return textBlock;
	}

	public List<Sentence> getSentences() {
		return sentences;
	}

	public TextComponentType getType() {
		return type;
	}

	public void addSentences(List<Sentence> sentences) {
		this.sentences = sentences;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sentences == null) ? 0 : sentences.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextBlock other = (TextBlock) obj;
		if (sentences == null) {
			if (other.sentences != null)
				return false;
		} else if (!sentences.equals(other.sentences))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TextBlock: " + textBlock;
	}

}
