package beans;

public class Adminsitrador extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int itemPorPagina;
	public int getItemPorPagina() {
		return itemPorPagina;
	}
	public void setItemPorPagina(int itemPorPagina) {
		this.itemPorPagina = itemPorPagina;
	}
	
	public Adminsitrador() {
		super();
		this.itemPorPagina = 50;
	}
	
	

}