package org.unitec.elementos1801;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Elementos1801Application implements CommandLineRunner{
    @Autowired RepositorioMensajito repoMensa;
    @Autowired RepositorioUsuario repoUsu; 
    @Autowired RepositorioDireccion repoDir; 

	public static void main(String[] args) {
		SpringApplication.run(Elementos1801Application.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        
        Usuario u=new Usuario(33868L, "Alejandra Barojas", "alehbarojas1496@hotmail.com"); 
        //repoUsu.save(u); 
        
       Direccion d=new Direccion(new Usuario(33868L),"Las americas",55070,"Ecatepec"); 
       // repoDir.save(d);
       
       //Aqui haremos el join 
       Direccion d2=repoDir.findOne(2L);
        System.out.println("Correo:"+d2.getU().getEmail()+"Municipio:"+d2.getMunicipio());
        
        //repoMensa.save(new Mensajito(1,"Segundo","Mi primera vez")); 
       // Mensajito m= repoMensa.findOne(1);
       //repoMensa.save(new Mensajito("17 de octubre", "no temblo"));  
       
       System.out.println("Vamos a buscar todos");
       for(Mensajito mensa:repoMensa.findAll()){
           
           System.out.println(mensa.getTitulo());
           
       }
       
        System.out.println("Vamos a buscar por ID");
        System.out.println(repoMensa.findOne(1));
        
        //ACTUALIZAR
        repoMensa.save(new Mensajito(1, "nuevo titulo", "nuevo cuerpo")); 
        System.out.println(repoMensa.findOne(1));
        
        
        //busqueda personalizada 
        for(Mensajito mensa:repoMensa.findByTitulo("Nuevo titulo")){
            System.out.println(mensa);
            
        }
        
    }
}
