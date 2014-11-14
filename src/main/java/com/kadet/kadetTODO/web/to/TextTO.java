package com.kadet.kadetTODO.web.to;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * @author Alex Soroka
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.ANY, fieldVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.ANY)
public class TextTO {

    public TextTO (String text) {
        this.text = text;
    }

    private String text;

    public String getText () {
        return text;
    }

    public void setText (String text) {
        this.text = text;
    }
}
