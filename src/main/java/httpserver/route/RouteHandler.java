package httpserver.route;

import httpserver.http.request.Request;
import httpserver.http.response.Response;
import httpserver.route.requestmethod.MethodHandlerFactory;

public class RouteHandler {

    public Response getResponse(Request request) {
        var clientRequestMethod = request.getRequestMethod();
        var methodHandler = MethodHandlerFactory.getHandler(clientRequestMethod);

        return methodHandler.getResponse(request);
    }
}
