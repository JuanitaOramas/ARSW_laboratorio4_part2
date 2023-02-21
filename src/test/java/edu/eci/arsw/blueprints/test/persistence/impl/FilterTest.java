package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.Filter;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import edu.eci.arsw.blueprints.persistence.impl.RedundancyFilter;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.junit.Test;
import static org.junit.Assert.*;

public class FilterTest {

    @Test
    public void shouldApplyRedundancyFilter() throws BlueprintPersistenceException, BlueprintNotFoundException {

        Point[] pts0=new Point[]{new Point(40, 40),new Point(15, 15),new Point(15, 15), new Point(40, 40),  new Point(50, 05)};


        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);
        Filter f = new RedundancyFilter();
//        BlueprintsServices bps = new BlueprintsServices();
//        bps.addNewBlueprint(bp0);
//        Blueprint result = bps.getBlueprint(bp0.getAuthor(), bp0.getName());
        Blueprint result = f.applyFilter(bp0);
        int sizeResult = result.getPoints().size();

        assertEquals(3,sizeResult);

    }

//    @Test
//    public void shouldApplySubsamplingFilter() throws BlueprintPersistenceException, BlueprintNotFoundException {
//        InMemoryBlueprintPersistence bpp =new InMemoryBlueprintPersistence();
//
//        Point[] pts0=new Point[]{new Point(40, 40),new Point(15, 15)};
//        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);
//
//        bpp.saveBlueprint(bp0);
//
//        Point[] pts=new Point[]{new Point(0, 0),new Point(10, 10)};
//        Blueprint bp=new Blueprint("john", "thepaint",pts);
//
//        bpp.saveBlueprint(bp);
//
//        assertNotNull("Loading a previously stored blueprint returned null.",bpp.getBlueprint(bp.getAuthor(), bp.getName()));
//
//        assertEquals("Loading a previously stored blueprint returned a different blueprint.",bpp.getBlueprint(bp.getAuthor(), bp.getName()), bp);
//
//    }
}
