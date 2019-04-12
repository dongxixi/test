package com.lovo.client.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data@Accessors@ToString
public class UserEntity {

	private String id;

	private String name;

	private String password;

}