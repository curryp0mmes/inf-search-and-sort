
/**
 * @author Alex
 */
public class Listenelement {
    
    Object obj;
    Listenelement nextElem = null;
    
    /**
     * Erzeugt ein Listenelement mit Inhalt o.
     * @param o 
     */
    public Listenelement(Object o)
    {
        obj = o;
        //nextElem = null;
    }
    
    /**
     * Setzt das Nachfolgeelement von o auf nE.
     * @param nE 
     */
    public void setNextElement(Listenelement nE)
    {
        nextElem = nE;
    }
    
    /**
     * Gibt das Nachfolgeelement von o zurück.
     * @return 
     */
    public Listenelement getNextElement()
    {
        return nextElem;
    }
    
    /**
     * Gibt den Inhalt des Listenelements o zurück.
     * @return 
     */
    public Object getObject()
    {
        return obj;
    }
}
