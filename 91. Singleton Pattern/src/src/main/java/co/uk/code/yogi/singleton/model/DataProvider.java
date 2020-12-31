package co.uk.code.yogi.singleton.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@NoArgsConstructor
@Getter
@Setter
@Repository
public class DataProvider
{
    private String state;
}
