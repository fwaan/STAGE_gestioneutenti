package it.trefin.gestioneutenti.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.trefin.gestioneutenti.model.Utente;
import it.trefin.gestioneutenti.service.UtenteService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/utenti")
public class UtenteController {
	
	private final UtenteService utenteService;
	
	public UtenteController(UtenteService utenteService) {
		this.utenteService = utenteService;
	}
	
	@GetMapping
	public Utente utente() {
		return utenteService.findFirst();
	}
	
	@GetMapping("/all")
	public List<Utente> getAll() {
		return utenteService.findAll();
	}
	
	@GetMapping("/{id}")
	public Utente findUtenteById(@PathVariable int id) {
		return utenteService.findById(id);
	}
	
	@PostMapping("/inserisci")
	@Transactional
	public void addUtente(@RequestBody Utente utente) {
		utenteService.addUtente(utente);
	}
	
	@PutMapping("/modifica")
	@Transactional
	public void updateUtente(@RequestBody int id, @RequestBody Utente utente) {
		utenteService.modificaUtente(id, utente);
	}
	
	@DeleteMapping("/elimina/{id}")
	@Transactional
	public void deleteUtente(@PathVariable int id) {
		utenteService.deleteUtente(id);
	}
	
	@GetMapping("/allcount")
	public long countUtente() {
		return utenteService.count();
	}
	
	@GetMapping("/getemail/{email}")
	public List<Utente> getEmail(@PathVariable String email) {
		return utenteService.getEmail(email);
	}
	
	@GetMapping("/getnome/{nome}")
	public List<Utente> getNome(@PathVariable String nome) {
		return utenteService.getNome(nome);
	}
	
	@GetMapping("/getcognome/{cognome}")
	public List<Utente> getCognome(@PathVariable String cognome) {
		return utenteService.getCognome(cognome);
	}
	
	@GetMapping("/getnomecognome/{nome}&{cognome}")
	public List<Utente> getNomeCognome(@PathVariable String nome, @PathVariable String cognome){
		return utenteService.getNomeCognome(nome, cognome);
	}
	
	@GetMapping("/getdominio/{dominio}")
	public List<Utente> getPerDominio(@PathVariable String dominio) {
		return utenteService.getDominio(dominio);
	}
	
	@GetMapping("/getordinati")
	public List<Utente> getOrdinati() {
		return utenteService.getOrdinati();
	}
	
	@GetMapping("/getiniziale/{lettera}")
	public List<Utente> getPerIniziale(@PathVariable String lettera) {
		return utenteService.getPerIniziale(lettera);
	}
	
	@DeleteMapping("/eliminatutti")
	@Transactional
	public void eliminaTutti() {
		utenteService.eliminaTutti();
	}
	
	@PatchMapping("/modificaparziale/{id}")
	@Transactional
	public Utente modificaParziale(@PathVariable int id, @RequestBody Utente dati) {
		return utenteService.modificaParziale(id, dati);
	}
	
}
