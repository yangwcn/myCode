package valid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import valid.condition.OneThing;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Controller
@RequestMapping("/valid")
@Validated
public class ValidParamController {
    @RequestMapping("/valid")
    @ResponseBody
    public Object save(@Valid @RequestBody OneThing oneThing, BindingResult bindResult){
        if(bindResult.hasErrors()) {
            return bindResult.getFieldError().getDefaultMessage();
        }
        return oneThing.toString();
    }

    @RequestMapping("/validated")
    @ResponseBody
    public Object save(
            @NotNull Integer testInt){
        return testInt.toString() + "test";
    }
}
