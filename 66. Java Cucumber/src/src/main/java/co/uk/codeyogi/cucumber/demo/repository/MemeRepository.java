package co.uk.codeyogi.cucumber.demo.repository;

import co.uk.codeyogi.cucumber.demo.model.Meme;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemeRepository extends MongoRepository<Meme, String>
{
}
