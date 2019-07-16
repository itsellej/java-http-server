package httpserver.http.route.requestmethod;

import httpserver.http.request.RequestFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeadMethodHandlerTest {
    @Test
    void returnsStatusCode200WhenPathIsSimpleGet() {
        var rawRequest = "HEAD /get_with_body HTTP/1.1";
        var request = RequestFactory.build(rawRequest);
        var headMethodHandler = new HeadMethodHandler();
        var response = headMethodHandler.getResponse(request);
        assertEquals("HTTP/1.1 200 OK", response);
    }

    @Test
    void returnsStatusCode200WhenTheRequestPathIsNotDefined() {
        var rawRequest = "HEAD /get_with_body_please HTTP/1.1";
        var request = RequestFactory.build(rawRequest);
        var headMethodHandler = new HeadMethodHandler();
        var response = headMethodHandler.getResponse(request);
        assertEquals("HTTP/1.1 404 NOT FOUND", response);
    }
}
