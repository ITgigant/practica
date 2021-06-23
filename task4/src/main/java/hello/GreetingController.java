package hello;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

class FormEntity{
    String userName;
    public FormEntity(){
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}

@Controller
public class GreetingController {
    @RequestMapping("/hello")
    public String echo(Model model){
        return "hello";
    }
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello (Model model){
        model.addAttribute("message","Hello, Аноним");
        return "hello";
    }
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String helloWithName (@ModelAttribute FormEntity form, Model model){
        model.addAttribute("message","Hello, " + form.userName);
        return "hello";
    }

}