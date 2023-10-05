package Tema2;


import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import static org.openide.util.WeakListeners.document;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class GeneradorDOM {
     Document document; 
    public static void main(String[] args) {
        try {
            GeneradorDOM ficheroXML = new GeneradorDOM();
            ficheroXML.GeneradorDoc(); // Inicializa el documento

            // Llena el documento con información
            ficheroXML.documentoXML();

            // Genera el archivo XML
            ficheroXML.generarXml();

            System.out.println("Documento XML creado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     

    public void GeneradorDoc() { 
        try {
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            DocumentBuilder b =f.newDocumentBuilder();
            document = b.newDocument();
        } catch (Exception e) {
        }

    }
public void documentoXML(){
        Element persona = document.createElement("persona");
        document.appendChild(persona);
        persona.setAttribute("Profesion","Cantante");
        Element nombre = document.createElement("nombre");
        nombre.appendChild(document.createTextNode("Elsa"));
        Element genero = document.createElement("mujer");
        Element nacimiento = document.createElement("fecha_de_nacimiento");
        Element dia = document.createElement("dia");
        Element mes = document.createElement("mes");
        Element ano = document.createElement("año");
        Element ciudad = document.createElement("ciudad");

        dia.appendChild(document.createTextNode("18"));
        mes.appendChild(document.createTextNode("6"));
        ano.appendChild(document.createTextNode("1996"));
        ciudad.appendChild(document.createTextNode("Pamplona"));
        persona.appendChild(nombre);
        persona.appendChild(genero); 
        persona.appendChild(nacimiento);
        nacimiento.appendChild(dia);
        nacimiento.appendChild(mes);
        nacimiento.appendChild(ano);
        persona.appendChild(ciudad);


    }
public void generarXml() {
        try {

             TransformerFactory factoria = TransformerFactory.newInstance();
        Transformer transformer = factoria.newTransformer();

        Source source = new DOMSource(document);
       File file = new File("C:\\Users\\Hp\\Desktop\\prueba.xml.txt");
        FileWriter fw = new FileWriter (file);
        PrintWriter pw = new PrintWriter (fw);
        Result r = new StreamResult (pw);

        transformer.transform(source, r);
 

        } catch (IOException | TransformerException e) {
        }
          }
}
}