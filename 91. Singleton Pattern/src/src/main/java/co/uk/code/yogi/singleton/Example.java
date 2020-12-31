package co.uk.code.yogi.singleton;

import co.uk.code.yogi.singleton.model.DataProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class Example
{
   private final DataProvider dataProvider;

   public void setState(final String state)
   {
      dataProvider.setState(state);
   }

   public String getState()
   {
      return dataProvider.getState();
   }

}
