package it.trefin.gestioneutenti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.trefin.gestioneutenti.model.Utente;
import it.trefin.gestioneutenti.repository.UtenteRepository;

@Service
public class UtenteService {
	
	private final UtenteRepository utenteRepository;
	
	
	public UtenteService(UtenteRepository utenteRepository) {
		this.utenteRepository = utenteRepository;
	}

	public List<Utente> findAll() {
		return utenteRepository.findAll();
	}

	public Utente findById(int id) {
		return utenteRepository.findById(id).orElse(null);
	}

	public Utente findFirst() {
		return utenteRepository.findAll().stream().findFirst().orElse(null);
	}

	public void addUtente(Utente utente) {
		utenteRepository.save(utente);
	}

	public void modificaUtente(int id, Utente utente) {
		utente.setId(id);
		utenteRepository.save(utente);
	}

	public void deleteUtente(int id) {
		utenteRepository.deleteById(id);
	}
	
	public long count() {
		return utenteRepository.count();
	}

	public List<Utente> getEmail(String email) {
		return utenteRepository.findByEmail(email);
	}
	
	public List<Utente> getNome(String nome) {
		return utenteRepository.findByNome(nome);
	}
	
	public List<Utente> getCognome(String cognome) {
		return utenteRepository.findByCognome(cognome);
	}
	
	public List<Utente> getNomeCognome(String nome, String cognome) {
		return utenteRepository.findByNomeAndCognome(nome, cognome);
	}
	
	public List<Utente> getDominio(String dominio) {
		if(!dominio.startsWith("@")) {
			dominio = "@" + dominio;
		}
		return utenteRepository.findByEmailEndingWith(dominio);
	}
	
	public List<Utente> getOrdinati() {
		return utenteRepository.findAllByOrderByCognomeAscNomeAsc();
	}
	
	public List<Utente> getPerIniziale(String lettera) {
		lettera = lettera.trim();
		if(lettera.length() != 1) {
			lettera = lettera.substring(0, 1);
		}
		return utenteRepository.findByCognomeStartingWithIgnoreCase(lettera);
	}
	
	public void eliminaTutti() {
		utenteRepository.deleteAll();
	}
	
	public Utente modificaParziale(int id, Utente dati) {
		Utente utente = utenteRepository.findById(id).orElseThrow();
		if(dati.getNome() != null || !dati.getNome().isEmpty() || !dati.getNome().isBlank()) {
			utente.setNome(dati.getNome());
		}
		if(dati.getCognome() != null || !dati.getCognome().isEmpty() || !dati.getNome().isBlank()) {
			utente.setCognome(dati.getCognome());
		}
		if(dati.getEmail() != null || !dati.getEmail().isEmpty() || !dati.getNome().isBlank()) {
			utente.setEmail(dati.getEmail());
		}
		return utenteRepository.save(utente);
	}
}
