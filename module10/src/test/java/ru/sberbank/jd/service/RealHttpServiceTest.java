package ru.sberbank.jd.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import ru.sberbank.jd.model.AppProperties;
import ru.sberbank.jd.model.MyRestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RealHttpServiceTest {

    @MockBean
    private AppProperties appProperties;

    @MockBean
    private MyRestTemplate myRestTemplate;
    @MockBean
    private RestTemplate restTemplate;
    String response;
    String result;

    @Test
    public void testCallHttpEndpoint() {
        response = "{\n"
                + "  \"args\": {}, \n"
                + "  \"headers\": {\n"
                + "    \"Accept\": \"text/plain, application/json, application/*+json, */*\", \n"
                + "    \"Host\": \"httpbin.org\", \n"
                + "    \"User-Agent\": \"Java/17.0.9\", \n"
                + "    \"X-Amzn-Trace-Id\": \"Root=1-65c619a4-7f2fbaed19d17b6563427281\"\n"
                + "  }, \n"
                + "  \"origin\": \"5.144.122.76\", \n"
                + "  \"url\": \"https://httpbin.org/get\"\n"
                + "}\n";
        String url = "https://httpbin.org/get";
        when(myRestTemplate.getRestTemplate()).thenReturn(new RestTemplate());
        when(appProperties.getServiceUrl()).thenReturn(url);
        when(restTemplate.getForObject(url, String.class)).thenReturn(response);
        RealHttpService realHttpService = new RealHttpService(appProperties, myRestTemplate);
        result = realHttpService.callHttpEndpoint();
        response = removeRootValue(response);
        result = removeRootValue(result);
        assertEquals(response, result);
    }

    public String removeRootValue(String response) {
        String pattern = "\"X-Amzn-Trace-Id\": \"Root=[^\"]*\"";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(response);

        if (matcher.find()) {
            response = response.replace(matcher.group(), "");
        }
        return response;
    }
}