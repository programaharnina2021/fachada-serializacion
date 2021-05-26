package acceso.coleccion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;
import acceso.IGrabador;

public class GrabadorCollection<T extends Collection> implements IGrabador<T> {
	private File file;
	private FileOutputStream flujoW;
	private ObjectOutputStream adaptadorW;
	private boolean estado=false;
	private String path;
	
	@Override
	public void iniciarOperacion(String path) throws IOException {
		this.path = path;
		file=new File(path);
		if(!file.exists()){
			try {
				estado=file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(estado){
			flujoW=new FileOutputStream(file);
			adaptadorW=new ObjectOutputStream(flujoW);
		}
		
	}

	@Override
	public void inserta(T dTO) throws IOException {
		try{
			adaptadorW.writeObject(dTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cierraElemento() throws IOException {
		try {
			adaptadorW.close();
			flujoW.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
