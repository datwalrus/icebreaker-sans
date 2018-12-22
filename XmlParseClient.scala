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

class XmlParseClient(var location: Array(String), var temperature: Array(Double)) {
    // Parse information into instance variables user iteration numbers.
    def parseInfo(val fileName: String, val iter: Int) {
        // take filename as argument and load
        val xml = XML.loadFile(fileName)

        // find location and temperature elements
        val loc = 
            (xml \\ "channel" \\ "item" \ "condition" \ "@location") location
        val temp =
            (xml \\ "channel" \\ "item" \ "condition" \ "@temp") temp
        location(iter) = loc
        temperature(iter) = temp
    }
    
    // Determine which temperatures are worth keeping, and their indexes.
    def findTemperatures() {
        
    }
    
    // Print data to file in format: <Location>: <Temperature> deg F
    /*
    def printInfo() {
        // use array math to 
    }
    
    */
}
