package acceso.coleccion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collection;

import acceso.IRecuperadorUnitario;

public class RecuperadorCollection<T extends Collection> implements IRecuperadorUnitario<T> {
	private String path;
	private File file;
	private FileInputStream flujoR;
	private ObjectInputStream adaptadorR;
	private boolean estado = false;

	@Override
	public T recupera() throws IOException, ClassNotFoundException {
		T obj=null;
		try {
			obj=(T) adaptadorR.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean iniciaOperacion(String path) {
		this.path = path;
		file = new File(path);		
		if (file.exists()) {
			try {
				flujoR = new FileInputStream(file);
				adaptadorR = new ObjectInputStream(flujoR);
				estado=true;
			} catch (Exception e) {
				estado = false;
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean cierraElemento() throws IOException {
		try {
			adaptadorR.close();
			flujoR.close();
		} catch (IOException e) {
			estado=false;
			e.printStackTrace();
		}
		return estado;
	}

}
