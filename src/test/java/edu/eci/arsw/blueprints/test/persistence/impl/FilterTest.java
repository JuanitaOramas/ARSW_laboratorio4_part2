package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.Filter;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import edu.eci.arsw.blueprints.persistence.impl.RedundancyFilter;
import edu.eci.arsw.blueprints.persistence.impl.SubsamplingFilter;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.junit.Test;
import static org.junit.Assert.*;

public class FilterTest {

    @Test
    public void shouldApplyRedundancyFilter() throws BlueprintPersistenceException, BlueprintNotFoundException {
        InMemoryBlueprintPersistence bpp =new InMemoryBlueprintPersistence();

        Point[] pts0=new Point[]{new Point(40, 40),new Point(15, 15),new Point(15, 15), new Point(40, 40),  new Point(50, 05)};
        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);
        Filter f = new RedundancyFilter();
        Blueprint result = f.applyFilter(bp0);
        int sizeResult = result.getPoints().size();
        assertEquals(3,sizeResult);

    }

    @Test
    public void shouldApplySubsamplingFilter() throws BlueprintPersistenceException, BlueprintNotFoundException {
        Point[] pts0=new Point[]{new Point(40, 40),new Point(15, 15),new Point(15, 15), new Point(40, 40),  new Point(50, 5), new Point(140, 500)};

        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);
        Filter f = new SubsamplingFilter();
        Blueprint result = f.applyFilter(bp0);
        int sizeResult = result.getPoints().size();

        assertEquals(3,sizeResult);
    }
}
