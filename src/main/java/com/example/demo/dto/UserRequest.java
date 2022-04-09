package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

	private int userId;
	
	@NotNull(message = "username should not be null")
	private String name;
	
	@Email
	private String email;
	
	@NotNull
	@Pattern(regexp = "&\\d{10}$", message = "mobile format invalid")
	private String mobile;
	
	private String gender;
	
	@Min(18)
	@Max(60)
	private int age;
	
	@NotBlank
	private String nationality;

}
