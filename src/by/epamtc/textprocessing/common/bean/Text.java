package by.epamtc.textprocessing.common.bean;

import java.util.ArrayList;
import java.util.List;

public class Text {
	private List<TextComponent> textComponents;

	public Text() {
		textComponents = new ArrayList<>();
	}

	public List<TextComponent> getTextComponents() {
		return textComponents;
	}

	public void addTextComponent(TextComponent textComponent) {
		textComponents.add(textComponent);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((textComponents == null) ? 0 : textComponents.hashCode());
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
		Text other = (Text) obj;
		if (textComponents == null) {
			if (other.textComponents != null)
				return false;
		} else if (!textComponents.equals(other.textComponents))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Text: " + textComponents;
	}
	
	
}
