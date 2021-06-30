package URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.text.RandomStringGenerator;

import java.net.URLDecoder;

@Controller
public class URLController {

    @Autowired
    URLRepository repository;
    private CodeGenerator codeGenerator = new CodeGenerator();
    public int shorterLength = 5;

    public String shott;

    @GetMapping("/urlCutter")
    public String URLAdd(Model model) {
        model.addAttribute("CutURL", new CutURL("",""));
        return "urlCutter";
    }

    @GetMapping("/shortURL")
    public String shortURl(Model model) {
        CutURL shorty = repository.findByShortURL(shott);
        model.addAttribute("CutURL", shorty);
        return "urlCutter";
    }

    @PostMapping("/urlCutter")
    public String URLAdd(@ModelAttribute CutURL url, Model model) {
        model.addAttribute("CutURL", url);
            String shortURL = codeGenerator.generate(shorterLength);
            shott = shortURL;
            repository.save(new CutURL(url.getDefaultURL(), shortURL));
        return "redirect:/shortURL";
    }

    @GetMapping(path = "/{urlCutter}")
    public ResponseEntity redirectShorter(@PathVariable("urlCutter") String shortURL) {
        //TODO find hash in DB and redirect to original URL
        CutURL shorter = repository.findByShortURL(shortURL);
        if (shorter != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", shorter.getDefaultURL());
            return new ResponseEntity<String>(headers, HttpStatus.FOUND);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
class CodeGenerator {
    private RandomStringGenerator randomStringGenerator;

    public CodeGenerator() {
        this.randomStringGenerator = new RandomStringGenerator
                .Builder().filteredBy(c -> isLetter(c))
                .build();
    }

    public String generate(int length) {
        return randomStringGenerator.generate(length);
    }

    private static boolean isLetter(int codePoint) {
        return ('a' <= codePoint && codePoint <= 'z')
                || ('A' <= codePoint && codePoint <= 'Z')
                || ('0' <= codePoint && codePoint <= '9');
    }

}