package controllers;

import play.mvc.*;

public class Application extends Controller {
  
    public static Result index() {
        if (!request().accepts("application/json")) {
            return status(NOT_ACCEPTABLE);
        }
        return ok("Your new application is ready.");
    }
  
}
