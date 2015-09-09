package beans;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity(name = "superadmin")
public class SuperAdmin extends Administrador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
