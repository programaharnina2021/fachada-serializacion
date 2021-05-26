package prueba;

import acceso.multiobjetos.DAOMultiObjetos;
import acceso.multiobjetos.GrabadorMulti;
import acceso.multiobjetos.RecuperadorMultiObjetos;
import dto.ArticuloSimpleDTO;

public class EnsayoMultiObjetos {
public static void main(String[] args) {
	ArticuloSimpleDTO art=new ArticuloSimpleDTO(2, "tornillo");
	String string = "articulos.ppf";
	DAOMultiObjetos<ArticuloSimpleDTO, Integer> daoMulti=
			new DAOMultiObjetos<>(
					new GrabadorMulti<>(), string, 
					new RecuperadorMultiObjetos<>());
	daoMulti.graba(art);
}
}
