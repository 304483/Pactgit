<<<<<<< HEAD
package com.retail.pos;
=======
package com.ust.sdet.api.contracts.oms;
>>>>>>> 3532e0ef3127ff5f253decfae73d7e83e20eae1e

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.*;

import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

@Provider("oms-provider")
<<<<<<< HEAD
@PactFolder("target/pacts")
=======
@PactBroker(
        url = "http://127.0.0.1:9292"
)
>>>>>>> 3532e0ef3127ff5f253decfae73d7e83e20eae1e
public class OmsProviderVerificationTest {
    @RegisterExtension
    private static final WireMockExtension wireMock =
            WireMockExtension.newInstance()
                    .options(wireMockConfig().port(4010))
                    .build();


    @PactBrokerConsumerVersionSelectors
    public static SelectorBuilder
    consumerVersionSelectors() {
        return new SelectorBuilder()
                .mainBranch()
                .deployedOrReleased();
    }


    @BeforeEach
    void setup(PactVerificationContext context) {
        context.setTarget(new HttpTestTarget("127.0.0.1", 4010));
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void verify(PactVerificationContext context) {
        context.verifyInteraction();
    }


<<<<<<< HEAD
    @State("order 123 exists")
=======
    @State("Order 245 exists")
>>>>>>> 3532e0ef3127ff5f253decfae73d7e83e20eae1e
    void isOrderExists() {
        wireMock.stubFor(get(urlEqualTo("/order/123"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                    {"orderId": 123, "status": "CONFIRMED", "total": 42.0}
                """)));
    }

<<<<<<< HEAD
    @State("inventory available for SKU-9")
=======
    @State("Creating a new order")
>>>>>>> 3532e0ef3127ff5f253decfae73d7e83e20eae1e
    void createOrder() {
        wireMock.stubFor(post(urlEqualTo("/orders/"))
                .withHeader("Content-Type", matching("application/json(;.*)?"))
                .willReturn(aResponse()
                        .withStatus(201)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                    {"statusCode": 201, "orderId": 101, "status": "CREATED", "total": 2000}
                """)));
    }

<<<<<<< HEAD
    @State("SKU-9 has stock")
=======
    @State("SKU-9 has Stock")
>>>>>>> 3532e0ef3127ff5f253decfae73d7e83e20eae1e
    void getInventory() {
        wireMock.stubFor(get(urlEqualTo("/inventory/SKU-9"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("""
                    {"sku": "SKU-9", "qty": 5}
                """)));
    }
}