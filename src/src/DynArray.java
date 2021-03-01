

/**
 * @author Alex
 */
public class DynArray {
    
    Listenelement startElement;
    int ListenLaenge;
   
    /**
     * Eine leere Liste enthält zunächst einen Start_Marker und ein END.
     * Spätere Einträge verdrängen den Start_Marker, das Ende bleibt als
     * in der Länge nicht gezählte Markierung bestehen.
     */
    public DynArray()
    {
        startElement = new Listenelement("Start_Marker");
        startElement.setNextElement(new Listenelement("END"));
        ListenLaenge = 0;
    }
    
    /**
     * Überprüft, ob es sich um eine leere Liste handelt
     * @return 
     */
    public boolean isEmpty()
    {
        if (ListenLaenge == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Hängt den Inhalt an das letzte Element an
     * @param elem 
     */
    public void append(Object elem)
    {
        if(startElement.getObject().equals("Start_Marker")){
            startElement = new Listenelement(elem);
            startElement.setNextElement(new Listenelement("END"));
            //System.out.println(startElement.getNextElement().getObject());
        }
        else{
            Listenelement neuEl = new Listenelement(elem);
            //System.out.println("Setze Nachfolger " + elem);
            getLastElement().setNextElement(neuEl);
            //System.out.println("Setze Ende um");
            neuEl.setNextElement(new Listenelement("END"));
        }
        ListenLaenge++;
    }    
    
    /**
     * Fügt ein Element inmitten der Lsite an Position index ein - alle Elemente
     * ab dort rücken einen weiter
     * @param index
     * @param newEl 
     */
    public void insertAt(int index, Object newEl)
    {
        Listenelement item = startElement;
        Listenelement neu = new Listenelement(newEl);
        Listenelement nachfolger;

        if (index >= ListenLaenge){
            append(newEl);
            ListenLaenge--; //weil sie unten erhöht und auch bei append erhöht würde
        }
        else if (index == 0){
            nachfolger = item;
            startElement = neu;
            neu.setNextElement(nachfolger);
        }
        else if (index == 1){
            nachfolger = item.getNextElement();
            item.setNextElement(neu);
            neu.setNextElement(nachfolger);
        }
        else{        
            for(int i = 0; i < index-1; i++)
            {
                item = item.getNextElement();
            }
            nachfolger = item.getNextElement();
            item.setNextElement(neu);
            neu.setNextElement(nachfolger);
        }  
        ListenLaenge++;
    }
    
    /**
     * Sucht und gibt das letzte Element der Liste zurück
     * @return 
     */
    public Listenelement getLastElement()
    {
        Listenelement lastOne = startElement;
        while(!lastOne.getNextElement().getObject().equals("END")){
            lastOne = lastOne.getNextElement();
        }
        return lastOne;
    }
    
    /**
     * Liefert das Object an der Position index der Liste zurück
     * @param index
     * @return 
     */
    public Object getItem(int index)
    {
        Listenelement item = startElement;
        for(int i = 0; i < index; i++){
            item = item.getNextElement();
        }
        return item.getObject();
    }
    
    /**
     * ERsetzt den Inhalt an Position index durch den Inhalt von newEl
     * @param index
     * @param newEl 
     */
    public void setItem(int index, Object newEl)
    {
        Listenelement item = startElement;
        Listenelement neu = new Listenelement(newEl);
        Listenelement nachfolger;
        
        if(index > 0){
            for(int i = 0; i < index-1; i++)
            {
                item = item.getNextElement();
            }
            nachfolger = item.getNextElement().getNextElement();
            item.setNextElement(neu);
            neu.setNextElement(nachfolger);
        }
        else
        {
            nachfolger = startElement.getNextElement();
            startElement = neu;
            neu.setNextElement(nachfolger);
        }
        
    }
    
    /**
     * Löscht Element an Position index, indem es vom Vorgänger den Nachfolger 
     * auf den Nachfolger vom zu löschenden Element zeigen lässt
     * @param index 
     */
    public void delete(int index)
    {
        
        if(index == 0)
        {
            startElement = startElement.getNextElement();
            ListenLaenge--;
            
            /*
                Jetzt lassen sich zwar alle prima l�schen.
                Jedoch g�be es beim Einf�gen neuer Elemente nun Probleme, 
                da Start und Ende nicht sauber markiert sind.
                Alternativ k�nnte man die auch durchg�ngig als dummy-Elemente
                mitnehmen.
            */
            
            if(ListenLaenge == 0){
                startElement = new Listenelement("Start_Marker");
                startElement.setNextElement(new Listenelement("END"));
                //System.out.println("Quasi-Neustart der Liste");
            }
        }
        else
        {
            Listenelement item = startElement;
            for(int i = 0; i < index-1; i++)
            {
                item = item.getNextElement();
            }
            item.setNextElement(item.getNextElement().getNextElement());
            ListenLaenge--;
        }
        
    }
        
    /**
     * Gibt die Länge der dyn.  Reihung zurück
     * @return 
     */
    public int getLength()
    {
        return ListenLaenge;
    }
    
}
