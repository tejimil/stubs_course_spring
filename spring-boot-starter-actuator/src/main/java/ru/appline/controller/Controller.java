package ru.appline.controller;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;

@RestController
public class Controller {
	private static final PetModel petmodel = PetModel.getInstance();
	private static final AtomicInteger newid = new AtomicInteger(1);
	
	@PostMapping(value = "/createPet", consumes = "application/json")
	public String createPet(@RequestBody Pet pet) {
		petmodel.add(pet, newid.getAndIncrement());
		if (newid.get()==2) {
			return "Your first pet created!";
		}else {
		return "New pet created!";
		}
	}
	
	@GetMapping(value = "/getAll", produces = "application/json")
	public Map<Integer, Pet> getAll(){
		return petmodel.getAll();
	}
	
	@GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
	public Pet getPet(@RequestBody Map<String,Integer> id) {
		return petmodel.getFromList(id.get("id"));
	}
	
	@DeleteMapping(value = "/delPet", consumes = "application/json")
	public void delPet(@RequestBody Map<String,Integer> id) {
		petmodel.delPet(id.get("id"));
	}
	
	@PutMapping(value = "/updatePet", consumes = "application/json")
	public void updatePet(@RequestBody Map<String,String> id) {
		Pet pet = new Pet(id.get("name"),id.get("type"),Integer.parseInt(id.get("age")));
		petmodel.add(pet,Integer.parseInt(id.get("id")));
	}

}
