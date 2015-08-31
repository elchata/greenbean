package beans;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banda")
public class BandaHoraria implements Serializable { /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idBanda;
	private Time horaInicio;
	private Time horaFin;
	private boolean activo;
	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idBanda", unique = true, nullable = false)
	public Long getIdBanda() {
		return idBanda;
	}
	public void setIdBanda(Long idBanda) {
		this.idBanda = idBanda;
	}
	public Time getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Time getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	


}
