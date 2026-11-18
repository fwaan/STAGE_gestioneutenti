package it.trefin.gestioneutenti.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.trefin.gestioneutenti.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {

	List<Utente> findByEmail(String email);
	List<Utente> findByNome(String nome);
	List<Utente> findByCognome(String cognome);
	List<Utente> findByNomeAndCognome(String nome, String cognome);
	List<Utente> findByEmailEndingWith(String dominio);
	List<Utente> findAllByOrderByCognomeAscNomeAsc();
	List<Utente> findByCognomeStartingWithIgnoreCase(String lettera);
}
