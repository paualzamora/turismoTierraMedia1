package turismo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TierraMediaTest {

	@Test
	public void usuarioTest() {
		Usuario eowyn = new Usuario(TipoDeAtraccion.AVENTURA, "Eowyn", 10, 8);
		Usuario gandalf = new Usuario(TipoDeAtraccion.PAISAJE, "Gandalf", 100, 5);
		Usuario sam = new Usuario(TipoDeAtraccion.DEGUSTACION, "Sam", 36, 8);
		Usuario galadriel = new Usuario(TipoDeAtraccion.PAISAJE, "Galadriel", 120, 8);

		assertEquals("Eowyn", eowyn.getNombre());
		assertEquals(TipoDeAtraccion.PAISAJE, gandalf.getTipoDeAtraccionPreferido());
		assertEquals(36, sam.getPresupuesto(), 0);
		assertEquals(8, galadriel.getTiempoDisponible(), 0);
	}

	@Test
	public void atraccionTest() {
		Atraccion moria = new Atraccion("Moria", TipoDeAtraccion.AVENTURA, 10, 2, 6);
		Atraccion minasTirith = new Atraccion("Minas Tirith", TipoDeAtraccion.PAISAJE, 5, 2.5, 25);
		Atraccion laComarca = new Atraccion("La Comarca", TipoDeAtraccion.DEGUSTACION, 3, 6.5, 150);
		Atraccion mordor = new Atraccion("Mordor", TipoDeAtraccion.AVENTURA, 25, 3, 4);

		assertEquals("Moria", moria.getNombre());
		assertEquals(TipoDeAtraccion.PAISAJE, minasTirith.getTipo());
		assertEquals(3, laComarca.getCosto(), 0);
		assertEquals(3, mordor.getTiempo(), 0);

	}

	@Test
	public void PromocionesTest() {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(new Atraccion("Moria", TipoDeAtraccion.AVENTURA, 10, 2, 6));
		atracciones.add(new Atraccion("Mordor", TipoDeAtraccion.AVENTURA, 24, 3, 4));
		atracciones.add(new Atraccion("Bosque Negro", TipoDeAtraccion.AVENTURA, 3, 4, 12));

		PromocionAxB axb = new PromocionAxB(TipoDePromocion.AXB, TipoDeAtraccion.AVENTURA, atracciones);
		PromocionAbsoluta abs = new PromocionAbsoluta(TipoDePromocion.ABSOLUTA, TipoDeAtraccion.AVENTURA,25, atracciones);
		PromocionPorcentual por = new PromocionPorcentual(TipoDePromocion.ABSOLUTA, TipoDeAtraccion.AVENTURA,50, atracciones);
		assertEquals(34, axb.getCosto(), 0);// costo correcto de promo
		assertEquals(25, abs.getCosto(), 0);// costo correcto de promo
		assertEquals(18.5, por.getCosto(), 0);// costo correcto de promo

		assertEquals(9,axb.getTiempo(),0);//suma de horas de cada atraccion en la promo
		assertEquals(9,abs.getTiempo(),0);
		assertEquals(9,por.getTiempo(),0);
		

		assertEquals("Moria/ Mordor/ Bosque Negro/ ",axb.getNombre());
		}
	
	@Test
	public void itinerariosTest() {
		Atraccion moria = new Atraccion("Moria", TipoDeAtraccion.AVENTURA, 10, 2, 6);
		Atraccion minasTirith = new Atraccion("Minas Tirith", TipoDeAtraccion.PAISAJE, 5, 2.5, 25);
		Usuario eowyn = new Usuario(TipoDeAtraccion.AVENTURA, "Eowyn", 10, 8);
		Usuario gandalf = new Usuario(TipoDeAtraccion.PAISAJE, "Gandalf", 100, 5);
		
		eowyn.agregarAItinerario(moria);
		gandalf.agregarAItinerario(minasTirith);
		
		assertEquals("Costo total = 10.0, Tiempo total = 2.0, Atracciones = Moria/ ", eowyn.getItinerario());
		assertEquals("Costo total = 5.0, Tiempo total = 2.5, Atracciones = Minas Tirith/ ", gandalf.getItinerario());
		
	}
	
}
