package com.epicode.modello;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "user_name"),
           @UniqueConstraint(columnNames = "user_email")
       })

public class Utente {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;

	  @NotBlank
	  @Size(max = 10)
	  private String username;

	  @NotBlank
	  @Size(max = 50)
	  @Email
	  private String email;

	  @NotBlank
	  @Size(min = 10)
	  private String password;

      public Utente() {
			
		}


      public Utente(String username, String email, String password) {
      this.username = username;
      this.email = email;
      this.password = password;
        }

      public long getId() {
      return id;
      }

      public void setId(long id) {
      this.id = id;
      }

      public String getUsername() {
      return username;
      }

      public void setUsername(String username) {
      this.username = username;
      }

      public String getEmail() {
      return email;
      }

      public void setEmail(String email) {
      this.email = email;
      }

      public String getPassword() {
      return password;
      }

      public void setPassword(String password) {
      this.password = password;
 }
}
