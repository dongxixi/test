package com.lovo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ttr_class_student")
public class ClassStudentEntity {

	@Id
	@GenericGenerator(name = "classStuUUID", strategy = "uuid")
	@GeneratedValue(generator = "classStuUUID")
	@Column(name = "cs_id", length = 32)
	private String id;
	@Column(name = "cs_type")
	private int type;
	@ManyToOne
	@JoinColumn(name = "c_id")
	private ClassEntity c;
	@ManyToOne
	@JoinColumn(name = "s_id")
	private StudentEntity s;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public ClassEntity getC() {
		return c;
	}

	public void setC(ClassEntity c) {
		this.c = c;
	}

	public StudentEntity getS() {
		return s;
	}

	public void setS(StudentEntity s) {
		this.s = s;
	}

}
