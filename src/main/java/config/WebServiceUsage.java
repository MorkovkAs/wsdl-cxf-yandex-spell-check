package config;

import net.yandex.speller.services.spellservice.*;

import java.util.List;

public class WebServiceUsage {
    public static void main(String[] args) {
        SpellService service = new SpellService();
        SpellServiceSoap port = service.getSpellServiceSoap();
        CheckTextRequest request = new CheckTextRequest();
        request.setLang("en");
        request.setText("My fist wsdl program");
        CheckTextResponse checkTextResponse = port.checkText(request);
        List<SpellError> errorList = checkTextResponse.getSpellResult().getError();
        System.out.println(errorList.size());
        for (SpellError error : errorList) {
            System.out.println(error.getWord());
        }
    }
}