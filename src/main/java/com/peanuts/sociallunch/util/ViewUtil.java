package com.peanuts.sociallunch.util;

import spark.ModelAndView;
import spark.Request;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.Map;

public class ViewUtil {

    public static String render(Request request, Map params, String templatePath) {
        //params.put("user", getSessionCurrentUser(request));
        //params.put("webpath", Path.class);*/ // Access application URLs from templates
        return new ThymeleafTemplateEngine().render(new ModelAndView(params, templatePath));
    }

}
