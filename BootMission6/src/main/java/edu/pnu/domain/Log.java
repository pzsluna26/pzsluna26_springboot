package edu.pnu.domain;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Log {
	@Id
	private int id;
	private String method;
	private String sqlstring;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date regidate;
	private boolean success;
	
}
