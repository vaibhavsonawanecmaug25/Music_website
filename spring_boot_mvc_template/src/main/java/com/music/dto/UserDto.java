
	package com.music.dto;

	import com.fasterxml.jackson.annotation.JsonProperty;
import com.music.model.User_role;

	import jakarta.validation.constraints.Email;
	import jakarta.validation.constraints.NotBlank;
	import jakarta.validation.constraints.Size;
     import lombok.*;

     @Getter
     @Setter
     @AllArgsConstructor
     @NoArgsConstructor
       public class UserDto {


    	   @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    	    private Long id;

	    @NotBlank(message = "Name is required")
	    private String name;

	    @Email(message = "Invalid email")
	    @NotBlank(message = "Email is required")
	    private String email;

	    @NotBlank(message = "Password required")
	    @Size(min = 4, message = "Password must be at least 4 characters")
	    private String password;

	    @NotBlank(message = "Role required")
	    private String role;

		
	    
	}


