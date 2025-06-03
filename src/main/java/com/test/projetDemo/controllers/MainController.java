package com.test.projetDemo.controllers;
import com.test.projetDemo.beans.Animal;
import com.test.projetDemo.beans.Territoire;
import com.test.projetDemo.repositories.AnimalRepositories;
import com.test.projetDemo.repositories.TerritoireRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/API")
public class MainController {

    private final AnimalRepositories animalRepositories;
    private final TerritoireRepositories territoireRepositories;

    public MainController(AnimalRepositories animalRepositories, TerritoireRepositories territoireRepositories) {
        this.animalRepositories = animalRepositories;
        this.territoireRepositories = territoireRepositories;
    }

    @GetMapping("/ajouterTerritoireAnimal")
    public Integer ajouterTerritoireAnimal(){
        List<Animal> listeAnimal = animalRepositories.findByAgeGreaterThan(-1);
        for (Animal a : listeAnimal){
            Territoire territoire = new Territoire("Test",25);
            a.setTerritoire(territoire);
            animalRepositories.save(a);
        }
        return 1;
    }

    @GetMapping("/listAnimalNom/{nom}")
    public List<Animal> getListAnimalNom(@PathVariable("nom") String nom){
        List<Animal> listeAnimal = animalRepositories.findByNomLike("%"+nom+"%");
        return listeAnimal;
    }

    @GetMapping("/animalYoungEspece/{espece}")
    public Animal getAnimalYoungEspece(@PathVariable("espece") String espece){
        Animal animal = animalRepositories.findFirstByEspeceOrderByAge(espece);
        return animal;
    }

    @GetMapping("/listAnimalYoung")
    public List<Animal> getListAnimalYoung(){
        return animalRepositories.findTop2ByOrderByAge();
    }

    @GetMapping("/listAnimalAgeSup/{age}")
    public List<Animal> getListAnimalAgeSup(@PathVariable("age") int age){
        return animalRepositories.findByAgeGreaterThan(age);
    }

    @GetMapping("/listAnimalOrderAge")
    public List<Animal> getlistAnimalOrderAge(){
        return animalRepositories.findByOrderByAge();
    }

    @GetMapping("/animal/{id}")
    public Optional<Animal> getAnimalWithID(@PathVariable("id") int id){
        return animalRepositories.findById(id);
    }

    @GetMapping("/listAnimal/{espece}")
    public List<Animal> getListAnimalWithEspece(@PathVariable("espece") String espece){
        List<Animal> listeAnimal = animalRepositories.findByEspece(espece);
        return listeAnimal;
    }

    @GetMapping("/recupTerritoireBDD")
    public List<Territoire> recupTerritoireBDD(){
        return territoireRepositories.findAll();
    }
    @GetMapping("/recupAnimalBDD")
    public List<Animal> recupAnimalBDD(){
        return animalRepositories.findAll();
    }
    @GetMapping("/recupAnimalByID")
    public Optional<Animal> recupAnimalByID(){
        Optional<Animal> animal = animalRepositories.findById(2);
        return (animal);
    }

    @GetMapping("/remplirAnimalBDD")
    public ResponseEntity<String> remplirAnimalBDD(){
        Animal animal3 = new Animal("Chouchou","Chat",6);
        Animal animal4 = new Animal("Poppy","Chat",6);
        animalRepositories.save(animal3);
        animalRepositories.save(animal4);
        return new ResponseEntity<>("Base remplie !", HttpStatus.OK);
    }

    @PostMapping("/recuperationAnimal")
    public ResponseEntity<String> recuperationAnimal(@RequestBody Animal animal){
        System.out.println(animal);
        animalRepositories.save(animal);
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }

    @PostMapping("/recuperationTerritoire")
    public ResponseEntity<String> recuperationTerritoire(@RequestBody Territoire territoire){
        territoireRepositories.save(territoire);
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }

    @GetMapping("/testPostAnimal")
    public Animal exempleAnimal(){
        return (new Animal(0,"Bac","Chat",25));
    }
    @GetMapping("/mesTestsHTTP")
    public String testGET(){
        return ("J'ai été invoqué en GET");
    }
    @PostMapping("/mesTestsHTTP")
    public String testPOST(){
        return ("J'ai été invoqué en POST");
    }

    @DeleteMapping ("/mesTestsHTTP")
    public String testDELETE(){
        return ("J'ai été invoqué en DELETE");
    }
    @PatchMapping ("/mesTestsHTTP")
    public String testPATCH(){
        return ("J'ai été invoqué en PATCH");
    }

    @GetMapping("/addition/{nombre1}/{nombre2}")
    public int additioner(@PathVariable("nombre1") int nb1,
                          @PathVariable("nombre2") int nb2){
        return (nb1 + nb2);
    }

    @GetMapping("/recupAnimal/{nom}/{espece}/{age}")
    public String recupererAnimal(@PathVariable("nom") String nom,
                                  @PathVariable("espece") String espece,
                                  @PathVariable("age") int age){
        return ("Mon animal s’appelle " + nom +" c’est un.e " + espece +
                " de  " + age +" ans");
    }

    @GetMapping("/pairImpair/{nombre}")
    public String afficherPair(@PathVariable("nombre") int nb){
        if (nb % 2 ==0){
            return (nb + " est pair");
        }
        else {
            return (nb + " est impair");
        }
    }

    @GetMapping("/Transmission/{donnees}")
    public String recupererDonnees(@PathVariable("donnees") String st){
        return ("Le test a bien été reçu : " + st);
    }

    @GetMapping("/bonjour")
    public String bonjour(){
        return ("Bonjour !");
    }

    @GetMapping("/coucou")
    public String coucou(){
        return ("Coucou");
    }
}
