package br.com.facerecognition.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

 

@Entity
@Table(schema = "UNMVMCARD")
public class Log {
	 
	@Id
	@SequenceGenerator(name = "SQ_LOGID", sequenceName = "SQ_LOGID", allocationSize = 1, schema = "UNMVMCARD")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_LOGID")
	private int id;

	@Column(name = "type")
	private String type;

	@Column(name = "message") 
	private String message;
 
	@Column(name = "datahora")
	private Date datahora;

	 
	public Log() {
		// TODO Auto-generated constructor stub
	}
	
	public Log(String mess, String ty) {
		this.message = mess;
		this.type = ty;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}

	public Date getDatahora() {
		return datahora;
	}

	public void setDatahora(Date datahora) {
		this.datahora = datahora;
	}

}
