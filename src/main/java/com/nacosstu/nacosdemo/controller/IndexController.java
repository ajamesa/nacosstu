package com.nacosstu.nacosdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author James Chen
 * @date 04/11/19
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void redirctSwagger(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getRequestURL().toString() + "swagger-ui.html";
        response.sendRedirect(url);
    }
}
