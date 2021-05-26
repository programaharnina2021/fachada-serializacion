package acceso;

import java.io.IOException;
import java.util.ArrayList;

public interface IRecuperadorIndexado<T,K> extends IRecuperador {
	public T recupera(K k) throws Exception;
}
