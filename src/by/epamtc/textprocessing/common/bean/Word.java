package by.epamtc.textprocessing.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Word implements TextBlockComponent, Serializable {
    private static final TextBlockComponentType type = TextBlockComponentType.WORD;
    private String data;
    private List<String> wordLetters;

    public Word(String data) {
        this.data = data;
        wordLetters = new ArrayList<>();
    }

    public String getData() {
        return data;
    }

    public void addWordLetter(String wordLetter) {
        wordLetters.add(wordLetter);
    }

    public List<String> getWordLetter() {
        return wordLetters;
    }

    public TextBlockComponentType getType() {
        return type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((wordLetters == null) ? 0 : wordLetters.hashCode());
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
        Word other = (Word) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (wordLetters == null) {
            if (other.wordLetters != null)
                return false;
        } else if (!wordLetters.equals(other.wordLetters))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Word: " + data;
    }


}
