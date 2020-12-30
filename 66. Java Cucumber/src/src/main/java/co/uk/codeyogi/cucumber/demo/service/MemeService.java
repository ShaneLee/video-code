package co.uk.codeyogi.cucumber.demo.service;

import co.uk.codeyogi.cucumber.demo.model.Meme;
import co.uk.codeyogi.cucumber.demo.repository.MemeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MemeService
{
    private final MemeRepository memeRepository;

    private final ObjectMapper objectMapper;

    public String getAllMemes() throws JsonProcessingException
    {
        return objectMapper.writeValueAsString(memeRepository.findAll());
    }

    public void newMeme(final Meme meme)
    {
        memeRepository.save(new Meme(meme));
    }

}
