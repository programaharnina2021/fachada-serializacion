package acceso.multiobjetos;

import java.io.IOException;

import acceso.IRecuperadorIndexado;
import acceso.Indicable;

public class RecuperadorMultiObjetos<T extends Indicable<Comparable>,K> implements IRecuperadorIndexado<T, K> {

	@Override
	public boolean iniciaOperacion(String path) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cierraElemento() throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T recupera(K k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
