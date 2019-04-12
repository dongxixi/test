package com.lovo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Table(name = "tt_class") // 映射表
@Entity // 被hibernate管理的实体
public class ClassEntity {
	@Id // 必须
	@Column(name = "c_id", length = 32)
	@GenericGenerator(name = "cUUID", strategy = "uuid")
	@GeneratedValue(generator = "cUUID") // ID生成策略
	private String id;
	@Column(name = "c_name", length = 48)
	private String name;
	@OneToMany(mappedBy = "c")
	private Set<ClassStudentEntity> css;
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "ttr_class_teacher",
		joinColumns = { @JoinColumn(name = "c_id") },
		inverseJoinColumns = { @JoinColumn(name = "t_id") })
	private Set<TeacherEntity> t;

	public Set<TeacherEntity> getT() {
		return t;
	}

	public void setT(Set<TeacherEntity> t) {
		this.t = t;
	}

	public Set<ClassStudentEntity> getCss() {
		return css;
	}

	public void setCss(Set<ClassStudentEntity> css) {
		this.css = css;
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
