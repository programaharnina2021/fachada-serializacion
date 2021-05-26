package acceso.multiobjetos;

import java.io.IOException;

import acceso.DAOGrabador;
import acceso.IRecuperador;
import acceso.IRecuperadorIndexado;
import acceso.Indicable;

public class DAOMultiObjetos<T extends Indicable, K> extends DAOGrabador<T> {
	protected IRecuperador recuperador;

	public DAOMultiObjetos(GrabadorMulti<T> grabador, String path, IRecuperadorIndexado<T, K> recuperador) {
		super(grabador, path);
		this.recuperador = recuperador;
	}

	public boolean graba(T DTO) {
		try {
			grabador.iniciarOperacion(path);
			((GrabadorMulti<T>) grabador).inserta(DTO);
			grabador.cierraElemento();
			return true;
		} catch (IOException e) {
			return false;
		}
	};

	public T recupera(K k) {
		T recupera;
		try {
			recuperador.iniciaOperacion(path);
			recupera = ((IRecuperadorIndexado<T, K>) recuperador).recupera(k);
			recuperador.cierraElemento();
		} catch (Exception e) {
			return null;
		}
		return recupera;
	}

}
