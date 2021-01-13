package com.example.demo;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;
@Entity
@Table
public class ChatData {
@Id @GeneratedValue(strategy = GenerationType.AUTO) 
@Column private long id;

@Column(name = "time")
@Temporal(TemporalType.TIMESTAMP)
private Date time = new Date();

@Column(length = 20, nullable = false)
private String name;

@Column(length = 100, nullable = false)
private String comment;

public long getId() {return id;}
public void setId(long id) {this.id = id;}

public Date getTime() {return time;}
public void setTime(Date time) {this.time = time;}

public String getName() {return name;}
public void setName(String name) {this.name = name;}

public String getComment() {return comment;}
public void setComment(String comment) {this.comment = comment;}
	
}
