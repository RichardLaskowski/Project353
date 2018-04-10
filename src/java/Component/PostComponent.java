/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Component;

import java.io.IOException;
import java.util.Date;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 *
 * @author Richa
 */
public class PostComponent extends UIComponentBase       
{
    @Override
    public void encodeBegin(FacesContext context) throws IOException
    {
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("div", this);
        writer.writeAttribute("class", "post", null);
            writer.startElement("div", this);
            writer.writeAttribute("class", "user", null);
                writer.startElement("p", this);
                    
                
                writer.endElement("p");
            writer.endElement("div");
        writer.endElement("div");   
    }
    
   
    @Override
    public String getFamily()
    {
        return "Hello Family";
    }
}
