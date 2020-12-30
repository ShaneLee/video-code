package co.uk.codeyogi.cucumber.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class Meme
{
    @Id
    @NonNull
    private String memeId;

    private String meme;

    private Integer dankness;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS+00:00", shape = JsonFormat.Shape.STRING)
    private LocalDateTime timestamp;

    public Meme(final Meme meme)
    {
        this.meme = meme.getMeme();
        this.dankness = meme.getDankness();
        this.timestamp = LocalDateTime.now();
    }

    public Meme(final String meme,
                final Integer dankness)
    {
        this.meme = meme;
        this.dankness = dankness;
        this.timestamp = LocalDateTime.now();
    }
}
