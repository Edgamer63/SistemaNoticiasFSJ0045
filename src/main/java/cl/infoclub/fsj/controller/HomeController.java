package cl.infoclub.fsj.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.infoclub.fsj.entity.Noticia;

@Controller
public class HomeController {
	private final static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String Main (Model modelo) {
		String nombre = "src/main/resources/static/noticias.txt";
		ArrayList<Noticia> listaNoticias = new ArrayList<Noticia>();
		
		try {
			FileReader fr = new FileReader(nombre);
			BufferedReader br = new BufferedReader(fr);
			String data = br.readLine();
			
			while (data != null) {

				String[] datos = data.split("@@");
				Noticia nt = new Noticia();
				
				nt.setTitulo(datos[0]);
				nt.setNoticia(datos[1]);
				nt.setImagen(datos[2]);
				
				logger.info("Titulo: "+nt.getTitulo());
				logger.info("Noticia: "+nt.getNoticia());
				logger.info("Imagen: "+nt.getImagen());
				
				listaNoticias.add(nt);
				data = br.readLine();
			}
			
			br.close();
			fr.close();
		}catch (Exception e) {
			logger.error("Error leyendo el fichero"+nombre+" : "+e);
		}
		
		for(int i=0; i<listaNoticias.size();i++) {
			
			
			modelo.addAttribute("noticia"+i+"_titulo",separarLinea(listaNoticias.get(i).getTitulo(),4));
			
			modelo.addAttribute("noticia"+i+"_noticia",separarLinea(listaNoticias.get(i).getNoticia(),6));
			
			modelo.addAttribute("noticia"+i+"_imagen",listaNoticias.get(i).getImagen());
		}
		
		modelo.addAttribute("max_noticias",listaNoticias.size());
		
		return "main";
	}
	
	private String separarLinea(String sl, int cnt) {
		String sl_mod=""; 
		int countWords=0;
		char currChar;
		for(int h=0; h<sl.length();h++) {
			currChar=sl.charAt(h);
			if (currChar==' ') {
				countWords++;
				
				if (countWords<cnt) {
					sl_mod=sl_mod+sl.charAt(h);
				}else {
					//sl_mod=sl_mod+"       "; //System.lineSeparator();
					sl_mod=sl_mod+System.lineSeparator();
					countWords=0;
				}
			}else {
				sl_mod=sl_mod+sl.charAt(h);
			}
		}
		
		return sl_mod;
		
	}
	
	
}
