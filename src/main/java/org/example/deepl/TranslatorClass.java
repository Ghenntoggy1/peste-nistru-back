package org.example.deepl;

import com.deepl.api.DeepLException;
import com.deepl.api.TextResult;
import com.deepl.api.Translator;

public class TranslatorClass {
    Translator translator;

    public TranslatorClass() throws Exception {
        String authKey = "48383f19-ae7b-b799-9c15-8fa8df7dfcc2:fx";
        this.translator = new Translator(authKey);
    }

    public TextResult translateText(String input) throws DeepLException, InterruptedException {
        TextResult result = this.translator.translateText(input, null, "ro");
        System.out.println(result.getText());
        return result;
    }
}
