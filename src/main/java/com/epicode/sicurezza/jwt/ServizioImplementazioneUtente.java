package com.epicode.sicurezza.jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epicode.modello.Utente;
import com.epicode.repository.UtenteRepository;

@Service
public class ServizioImplementazioneUtente implements UserDetailsService {
	
	@Autowired
	  UtenteRepository userRepository;

	  @Override
	  @Transactional
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Utente user = userRepository.findByUsername(username)
	        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

	    return ImplementazioneDettagliUtente.build(user);

	  }
	  
}
