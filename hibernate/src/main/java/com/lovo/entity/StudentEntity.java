package com.lovo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Table(name = "tt_student") // 映射表
@Entity // 被hibernate管理的实体
public class StudentEntity {
	@Id // 必须
	@Column(name = "s_id", length = 32)
	@GenericGenerator(name = "stuUUID", strategy = "uuid")
	@GeneratedValue(generator = "stuUUID") // ID生成策略
	private String id;
	@Column(name = "s_name", length = 48)
	private String name;
	@OneToMany(mappedBy = "s")
	private Set<ClassStudentEntity> css;

	public Set<ClassStudentEntity> getCss() {
		return css;
	}

	public void setCss(Set<ClassStudentEntity> css) {
		this.css = css;
	}

	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentEntity(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
