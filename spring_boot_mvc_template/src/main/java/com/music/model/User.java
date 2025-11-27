package com.music.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude= {"password"})


public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(length = 50,nullable=false)
	private String name;
	@Column(length = 50,nullable=false,unique=true)
	private String email;
	@Column(nullable=false)
	private String password;
	@Enumerated(EnumType.STRING)
	private User_role role;
	
	public User(String name, String email, String password, User_role role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	

	
	
	

}
