package acceso;

import java.io.IOException;

public interface IGrabador<T>{
	public void iniciarOperacion(String path) throws IOException;
	public void inserta(T dTO) throws IOException;
	public void cierraElemento() throws IOException;
}
