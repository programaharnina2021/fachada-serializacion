package acceso;

public abstract class DAOGrabador<T> {
	
	protected IGrabador grabador;
	protected String path;
	
	public DAOGrabador(IGrabador grabador, String path) {
		super();
		this.grabador = grabador;
		this.path = path;
	}

	public abstract boolean graba(T DTO);
	
}
