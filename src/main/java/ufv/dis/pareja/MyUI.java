package ufv.dis.pareja;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;

import com.google.zxing.WriterException;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ufv.dis.pareja.GeneradorEAN13;
import ufv.dis.pareja.Inventario;
import ufv.dis.pareja.Producto;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

            final VerticalLayout layout = new VerticalLayout();
            
            Inventario inventario = new Inventario();
            
            final TextField nombre = new TextField();
            nombre.setCaption("Nombre:");
            final TextField cat = new TextField();
            cat.setCaption("Categoria:");
            final TextField precio = new TextField();
            precio.setCaption("Precio:");
            final TextField EAN = new TextField();
            EAN.setCaption("EAN13: ");
          

            Button button = new Button("GUARDAR");
            button.addClickListener(e -> {
                layout.addComponent(new Label("Producto " + nombre.getValue() 
                        + " guardado"));
                
              	//paso string a num entero
            	Producto p = new Producto(nombre.getValue(), cat.getValue(), Integer.parseInt(precio.getValue()), EAN.getValue());
            	inventario.addProducto(p);
            	
            	
         
            	try {
					GeneradorEAN13.generarEan(p);
				} catch (WriterException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	Notification.show("EAN13 generado con exito!");
            	
            });
        
        layout.addComponents(nombre, cat, precio, EAN, button);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
