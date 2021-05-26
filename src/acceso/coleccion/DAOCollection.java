package acceso.coleccion;

import java.io.IOException;
import java.util.Collection;

import acceso.DAOGrabador;
import acceso.IRecuperadorUnitario;

public class DAOCollection<T extends Collection> extends DAOGrabador<T> {
	private IRecuperadorUnitario<T> recuperador;

	public DAOCollection(IRecuperadorUnitario<T> recuperador, GrabadorCollection grabador, String path) {
		super(grabador, path);
		this.recuperador = recuperador;
	}

	@Override
	public boolean graba(T DTO) {
		try {
			grabador.iniciarOperacion(path);
			((GrabadorCollection) grabador).inserta(DTO);
			grabador.cierraElemento();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public T recupera() throws IOException, ClassNotFoundException {
		try {
			recuperador.iniciaOperacion(path);
			T recupera = ((IRecuperadorUnitario<T>) recuperador).recupera();
			recuperador.cierraElemento();
			return recupera;
		} catch (Exception e) {
			return null;
		}
	};

}
