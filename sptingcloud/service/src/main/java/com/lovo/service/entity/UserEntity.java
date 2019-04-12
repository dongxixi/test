package com.lovo.service.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data@Accessors
@Entity
@Table(name = "t_user")
public class UserEntity{

	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;

	@Column(name = "name", length = 48)
	private String name;

	@Column(name = "password", length = 48)
	private String password;

}