package co.uk.codeyogi.designpatterns.factory;

import co.uk.codeyogi.designpatterns.model.Contractor;
import co.uk.codeyogi.designpatterns.model.Employee;
import co.uk.codeyogi.designpatterns.model.Resource;

public class ResourceFactory
{
    public Resource createResource(final String type)
    {
        if ("internal".equalsIgnoreCase(type))
        {
            return new Employee(new Object(), new Object(), new Object());
        }
        else if ("type".equalsIgnoreCase(type))
        {
//            return new Object();
        }
        else
        {
            return new Contractor(new Object(), new Object());
        }

    }
}
