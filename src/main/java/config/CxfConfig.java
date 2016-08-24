package config;

import net.yandex.speller.services.spellservice.SpellServiceSoap;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.camel.component.cxf.DataFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:META-INF/cxf/cxf.xml"})
public class CxfConfig {

    @Value("http://speller.yandex.net/services/spellservice")
    private String spellCheckURL;

    @Bean
    public CxfEndpoint spellCheckEndpoint() {
        CxfEndpoint cxfEndpoint = new CxfEndpoint();
        cxfEndpoint.setAddress(spellCheckURL);
        cxfEndpoint.setServiceClass(SpellServiceSoap.class);
        cxfEndpoint.setDataFormat(DataFormat.POJO);
        cxfEndpoint.setLoggingFeatureEnabled(true);
        return cxfEndpoint;
    }
}
