package by.epamtc.textprocessing.common.bean;

import java.io.Serializable;

public class CodeBlock implements TextComponent, Serializable {
    private static final TextComponentType type = TextComponentType.CODE_BLOCK;
    private String codeBlock;

    public CodeBlock(String codeBlock) {
        this.codeBlock = codeBlock;
    }

    public TextComponentType getType() {
        return type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codeBlock == null) ? 0 : codeBlock.hashCode());
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
        CodeBlock other = (CodeBlock) obj;
        if (codeBlock == null) {
            if (other.codeBlock != null)
                return false;
        } else if (!codeBlock.equals(other.codeBlock))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CodeBlock:\n" + codeBlock;
    }

}
