package by.epamtc.textprocessing.common.bean;

import java.io.Serializable;

public class PunctuationMark implements TextBlockComponent, Serializable {
    private static final TextBlockComponentType type = TextBlockComponentType.PUNCTUATION_MARK;
    private String punctuationMark;

    public PunctuationMark(String punctuationMark) {
        this.punctuationMark = punctuationMark;
    }

    public String getPunctuationMark() {
        return punctuationMark;
    }

    public TextBlockComponentType getType() {
        return type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((punctuationMark == null) ? 0 : punctuationMark.hashCode());
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
        PunctuationMark other = (PunctuationMark) obj;
        if (punctuationMark == null) {
            if (other.punctuationMark != null)
                return false;
        } else if (!punctuationMark.equals(other.punctuationMark))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PunctuationMark: " + punctuationMark;
    }

}
