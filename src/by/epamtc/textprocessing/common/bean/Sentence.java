package by.epamtc.textprocessing.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextBlockComponent, Serializable {
    private static final TextBlockComponentType type = TextBlockComponentType.SENTENCE;

    private String sentence;
    private List<Word> words;
    private List<PunctuationMark> punctuationMarks;

    public Sentence(String sentence) {
        this.sentence = sentence;
        words = new ArrayList<>();
        punctuationMarks = new ArrayList<>();
    }

    public String getSentence() {
        return sentence;
    }

    public List<Word> getWords() {
        return words;
    }

    public List<PunctuationMark> getPunctuationMarks() {
        return punctuationMarks;
    }

    public void setWord(Word word) {
        words.add(word);
    }

    public void setPunctuationMark(PunctuationMark punctuationMark) {
        punctuationMarks.add(punctuationMark);
    }

    public TextBlockComponentType getType() {
        return type;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((punctuationMarks == null) ? 0 : punctuationMarks.hashCode());
        result = prime * result + ((sentence == null) ? 0 : sentence.hashCode());
        result = prime * result + ((words == null) ? 0 : words.hashCode());
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
        Sentence other = (Sentence) obj;
        if (punctuationMarks == null) {
            if (other.punctuationMarks != null)
                return false;
        } else if (!punctuationMarks.equals(other.punctuationMarks))
            return false;
        if (sentence == null) {
            if (other.sentence != null)
                return false;
        } else if (!sentence.equals(other.sentence))
            return false;
        if (words == null) {
            if (other.words != null)
                return false;
        } else if (!words.equals(other.words))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Sentence: " + sentence;
    }

}
