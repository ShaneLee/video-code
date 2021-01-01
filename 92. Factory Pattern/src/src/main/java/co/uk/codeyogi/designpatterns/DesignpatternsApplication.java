package co.uk.codeyogi.designpatterns;

import co.uk.codeyogi.designpatterns.factory.ResourceFactory;
import co.uk.codeyogi.designpatterns.model.Resource;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignpatternsApplication {

	public static void main(String[] args) {
	    final String companySource = "internal";
	    final ResourceFactory resourceFactory = new ResourceFactory();
	    final Resource resource = resourceFactory.createResource(companySource);

		System.out.println("Billable Hours : " + resource.calculateBillableHours());
	}

}
