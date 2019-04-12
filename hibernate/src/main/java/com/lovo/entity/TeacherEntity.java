package com.lovo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Table(name = "tt_teacher") // 映射表
@Entity // 被hibernate管理的实体
public class TeacherEntity {
	@Id // 必须
	@Column(name = "t_id", length = 32)
	@GenericGenerator(name = "tUUID", strategy = "uuid")
	@GeneratedValue(generator = "tUUID") // ID生成策略
	private String id;
	@Column(name = "t_name", length = 48)
	private String name;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "ttr_class_teacher",
		joinColumns = { @JoinColumn(name = "t_id") },
		inverseJoinColumns = {@JoinColumn(name = "c_id") })
	private Set<ClassEntity> c;

	public Set<ClassEntity> getC() {
		return c;
	}

	public void setC(Set<ClassEntity> c) {
		this.c = c;
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
