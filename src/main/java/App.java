import static spark.Spark.*;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/changeReturn", (request, response) ->  {
            Map<String, Object> model = new HashMap<>();
            ChangeMachine changeMachine = new ChangeMachine();
            float amount = Float.parseFloat(request.queryParams("amount"));
            String result = changeMachine.makeChange(amount);
            model.put("result", result);
            return new ModelAndView(model, "changeReturn.hbs");
        }, new HandlebarsTemplateEngine());
    }
}



