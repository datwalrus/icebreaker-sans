import java.io._;
import scala.xml.XML;

/* This project contains all methods needed to parse an xml file to gather 
 * temperature data.
 *
 * This parser will read a multitude of weather reports daily to generate
 * a readout of new high temperatures, alongwith the old reported highs.
 * // to be implemented later
 *
 * Any temperature over 100 degrees will be recorded, regardless of record.
 *
 */

class XmlParseClient(location: Array[String],
                     temperature: Array[Double]) {
    // Parse information into instance variables user iteration numbers.
    def parseInfo(fileName: String, iter: Int) {
        // take filename as argument and load
        val xml = XML.loadFile(fileName)

        // find location and temperature elements
        val loc = (xml \\ "channel" \\ "item" \ "condition" \ "@location")
        val temp = (xml \\ "channel" \\ "item" \ "condition" \ "@temp")
        location(iter) = loc.toString
        temperature(iter) = temp.toString.toDouble
    }
    
    // Determine which temperatures are worth keeping, and their indexes.
    def findTemperatures(iter: Int) {
        var indices = Seq.empty[Int]
        for (i <- 0 to (iter - 1)) {
            // check value for over or equal to 100.0
            if (temperature(i) >= 100.0) {
                // if valid, save index
                indices :+= i
            }
        }
        
    }
    
    // Print data to file in format: <Location>: <Temperature> deg F
    /*
    def printInfo() {
    }
    
    */
}
