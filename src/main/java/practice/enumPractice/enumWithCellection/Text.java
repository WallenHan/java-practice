package practice.enumPractice.enumWithCellection;

import java.util.EnumSet;
import java.util.Set;

public class Text {
    public enum  Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH;
    }

    // 写方法的签名时采用接口类型 那么在调用方可以采用不同的实现类来调用
    public void applyStyle(Set<Style> styles) {

    }

    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyle(EnumSet.of(Style.BOLD, Style.STRIKETHROUGH, Style.UNDERLINE));
    }
}
