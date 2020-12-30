package co.uk.codeyogi.cucumber.demo.web;

import co.uk.codeyogi.cucumber.demo.model.Meme;
import co.uk.codeyogi.cucumber.demo.service.MemeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/memes")
@AllArgsConstructor
public class MemeController
{
    private final MemeService memeService;

    @GetMapping("/all")
    public String getAllMemes() throws JsonProcessingException
    {
        return memeService.getAllMemes();
    }

    @PostMapping("/new")
    public void newMeme(@RequestBody final Meme meme)
    {
        memeService.newMeme(meme);
    }
}
