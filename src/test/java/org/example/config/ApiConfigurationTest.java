package org.example.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.example.config.ApiName.DETERMINATION_API;
import static org.example.config.ApiName.ID_CLAIM_API;
import static org.example.config.ApiName.MEMBER_SEARCH_API;
import static org.example.config.ApiName.POTENTIAL_CUSTOMER_API;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(initializers = ConfigDataApplicationContextInitializer.class)
@EnableConfigurationProperties(value = ApiConfiguration.class)
@SpringBootTest
class ApiConfigurationTest {
    private final ApiConfiguration apiConfiguration;

    @Autowired
    public ApiConfigurationTest(ApiConfiguration apiConfiguration) {
        this.apiConfiguration = apiConfiguration;
    }

    @Test
    public void testApiMap_determination() {
        assertNotNull(apiConfiguration.getApiKey());
        assertNotNull(apiConfiguration.getApiMap());
        ApiConfiguration.Api api = apiConfiguration.getApiMap().get(DETERMINATION_API);
        assertNotNull(api);
        assertNotNull(api.getConjur());
        assertNotNull(api.getDomain());
        assertNotNull(api.getUri());
        assertNotNull(api.getGlooEnvCookie());
    }

    @Test
    public void testApiMap_idClaim() {
        assertNotNull(apiConfiguration.getApiKey());
        assertNotNull(apiConfiguration.getApiMap());
        ApiConfiguration.Api api = apiConfiguration.getApiMap().get(ID_CLAIM_API);
        assertNotNull(api);
        assertNull(api.getConjur());
        assertNotNull(api.getDomain());
        assertNotNull(api.getUri());
        assertNull(api.getGlooEnvCookie());
    }

    @Test
    public void testApiMap_memberSearch() {
        assertNotNull(apiConfiguration.getApiKey());
        assertNotNull(apiConfiguration.getApiMap());
        ApiConfiguration.Api api = apiConfiguration.getApiMap().get(MEMBER_SEARCH_API);
        assertNotNull(api);
        assertNotNull(api.getConjur());
        assertNotNull(api.getDomain());
        assertNotNull(api.getUri());
        assertNotNull(api.getGlooEnvCookie());
    }

    @Test
    public void testApiMap_pctc() {
        assertNotNull(apiConfiguration.getApiKey());
        assertNotNull(apiConfiguration.getApiMap());
        ApiConfiguration.Api api = apiConfiguration.getApiMap().get(POTENTIAL_CUSTOMER_API);
        assertNotNull(api);
        assertNotNull(api.getConjur());
        assertNotNull(api.getDomain());
        assertNotNull(api.getUri());
        assertNotNull(api.getGlooEnvCookie());
    }
}