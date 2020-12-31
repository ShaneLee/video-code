package co.uk.code.yogi.singleton;

import co.uk.code.yogi.singleton.model.DataProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@AllArgsConstructor
@Component
public class Printer
{
    private final Example example;

    private DataProvider dataProvider;

    @PostConstruct
    void postConstruct()
    {
        dataProvider.setState("Wowwowowowowowowowo");

        System.out.println("DataProvider: " + dataProvider.getState());
        System.out.println("Example: " + example.getState());

        example.setState("From example");

        System.out.println("DataProvider: " + dataProvider.getState());
        System.out.println("Example: " + example.getState());
    }
}
