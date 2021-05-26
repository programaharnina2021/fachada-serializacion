package acceso;

import java.io.IOException;

public interface IRecuperador {

	public boolean iniciaOperacion(String path);

	public boolean cierraElemento() throws IOException;
}
