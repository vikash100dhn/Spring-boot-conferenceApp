package com.javatechstack.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class is main owner for many to many relationship with the speaker class
 * 
 * 
 * @author vikash kumar singh
 *
 */
@Entity(name="sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Session {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//the variable names are not in proper java convention 
	//but it is matching with the column names in order to reduce the effort for adding @column :)
	private Long session_id;
	private String session_name;
	private String session_description;
	private Integer session_length;
	
	@ManyToMany
	@JsonIgnore
	@JoinTable(name ="session_speakers",
				joinColumns=@JoinColumn(name="session_id"),
				inverseJoinColumns=@JoinColumn(name="speaker_id"))
	List<Speaker> speakers;
	
	public Session() {}

	public Long getSession_id() {
		return session_id;
	}

	public void setSession_id(Long session_id) {
		this.session_id = session_id;
	}

	public String getSession_name() {
		return session_name;
	}

	public void setSession_name(String session_name) {
		this.session_name = session_name;
	}

	public String getSession_description() {
		return session_description;
	}

	public void setSession_description(String session_description) {
		this.session_description = session_description;
	}

	public Integer getSession_length() {
		return session_length;
	}

	public void setSession_length(Integer session_length) {
		this.session_length = session_length;
	}

	public List<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
	}
}
