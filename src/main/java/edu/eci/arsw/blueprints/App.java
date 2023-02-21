package edu.eci.arsw.blueprints;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String args[]) throws BlueprintNotFoundException, BlueprintPersistenceException {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bluePrintService = ac.getBean(BlueprintsServices.class);
        Point[] puntos = new Point[]{new Point(15,7)};
        Blueprint blueprint = new Blueprint("Wilnita", "Delramas", puntos);
        bluePrintService.addNewBlueprint(blueprint);
        System.out.println(bluePrintService.getBlueprintsByAuthor("Wilnita"));

        }
}
