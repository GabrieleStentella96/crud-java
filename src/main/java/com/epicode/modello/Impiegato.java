package com.epicode.modello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Impiegato")

public class Impiegato {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(name = "department_Id")
		private int departmentId;
		
		@Column(name = "first_name")
		private String firstName;

		@Column(name = "last_name")
		private String lastName;
		
		@Column(name = "city")
		private String city;
		
		@Column(name = "region")
		private String region;
		
		@Column(name = "hiring_year")
		private int hiringYear;
		
		public Impiegato() {
			
		}
		
		public Impiegato(int departmentId, String firstName, String lastName, String city, String region, int hiringYear) {
			super();
			this.departmentId = departmentId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.city = city;
			this.region = region;
			this.hiringYear = hiringYear;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public int getdepartmentId() {
			return departmentId;
		}
		public void setdepartmentid(int departmentId) {
			this.departmentId = departmentId;
		}
		public int gethireYear() {
			return hiringYear;
		}
		public void sethireYear(int hireYear) {
			this.hiringYear = hireYear;
		}
		public String getcity() {
			return city;
		}
		public void setcity(String city) {
			this.city = city;
		}
		public String getregion() {
			return region;
		}
		public void setregion(String region) {
			this.region = region;
		}
	}


