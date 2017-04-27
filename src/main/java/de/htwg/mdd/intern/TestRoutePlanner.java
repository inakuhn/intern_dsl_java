package de.htwg.mdd.intern;
import de.htwg.mdd.intern.home.map.TownMap;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.*;

import static de.htwg.mdd.intern.home.map.HomeMapBuilder.start;


/**
 * Created by Ina Kuhn on 07.04.2017.
 */
public class TestRoutePlanner {
    private TestRoutePlanner(){}
    public static void main(String[] args) {
        TownMap townMap =  start().startMap("Ina's Neighbourhood").numberOfStreets(5,1).finishMap();

        VelocityEngine ve = new VelocityEngine();
        ve.init();
        VelocityContext context = new VelocityContext();
        context.put("townMap", townMap);
        Template t = ve.getTemplate( "./src/main/resources/neighbourhood.vm" );
        StringWriter writer = new StringWriter();
        t.merge( context, writer );
        String wi =  writer.toString();
        System.out.println(wi);
        try {
            PrintStream out = new PrintStream(new FileOutputStream("filename.html"));
            out.print(wi);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
