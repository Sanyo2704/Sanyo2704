package tema1.ejercicio05.modelo;

import java.time.LocalDate;

import lombok.Data;


@Data
public class User {
	private Long id;
	private String username;
	private String pswd;
	private String email;
	private LocalDate dischargeDate;
	private LocalDate lastLoginDate;
	
}
