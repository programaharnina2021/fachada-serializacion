package acceso;

import java.io.IOException;
import java.util.ArrayList;

public interface IRecuperadorUnitario<T> extends IRecuperador{
	public T recupera() throws IOException, ClassNotFoundException;
}
