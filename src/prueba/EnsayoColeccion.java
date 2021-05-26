package prueba;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import acceso.coleccion.DAOCollection;
import acceso.coleccion.GrabadorCollection;
import acceso.coleccion.RecuperadorCollection;
import dto.ArticuloSimpleDTO;

public class EnsayoColeccion {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		ArrayList<ArticuloSimpleDTO> lista=new ArrayList<>();
		lista.add(new ArticuloSimpleDTO(1, "luis"));
		String path = "articulos.data";
		DAOCollection<ArrayList<ArticuloSimpleDTO>> daoLista
		=new DAOCollection<ArrayList<ArticuloSimpleDTO>>
		(new RecuperadorCollection<>(), new GrabadorCollection<>(), path);
		daoLista.graba(lista);
		ArrayList<ArticuloSimpleDTO> listaDos=daoLista.recupera();
	}
}
