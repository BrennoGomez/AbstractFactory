
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

/**
 * Good example of the abstract factory.
 * see: https://brizeno.wordpress.com/category/padroes-de-projeto/abstract-factory/
 */
class Good {
  interface FabricaDeCarro {
    CarroSedan criarCarroSedan();
    CarroPopular criarCarroPopular();
  }
  class FabricaFiat implements FabricaDeCarro {
 
    @Override
    public CarroSedan criarCarroSedan() {
        return new Siena();
    }
 
    @Override
    public CarroPopular criarCarroPopular() {
        return new Palio();
    }
  }
  
  class FabricaFord implements FabricaDeCarro {
	  
	    @Override
	    public CarroSedan criarCarroSedan() {
	        return new Fusion();
	    }
	 
	    @Override
	    public CarroPopular criarCarroPopular() {
	        return new Ka();
	    }
	  }
  
  interface CarroPopular {
    void exibirInfoPopular();
  }
  interface CarroSedan {
    void exibirInfoSedan();
  }
  
  class Palio implements CarroPopular {
 
    @Override
    public void exibirInfoPopular() {
        System.out.println("Modelo: Palio\nFábrica: Fiat\nCategoria:Popular");
    }
  }
  class Siena implements CarroSedan {
 
    @Override
    public void exibirInfoSedan() {
        System.out.println("Modelo: Siena\nFábrica: Fiat\nCategoria:Sedan");
    }
  }
  
  class Ka implements CarroPopular {
	  
	    @Override
	    public void exibirInfoPopular() {
	        System.out.println("Modelo: Ka\nFábrica: Ford\nCategoria:Popular");
	    }
	  }
	  class Fusion implements CarroSedan {
	 
	    @Override
	    public void exibirInfoSedan() {
	        System.out.println("Modelo: Fusion\nFábrica: Ford\nCategoria:Sedan");
	    }
	  }
  public static void main(String[] args) {
	Good good = new Good();
    FabricaDeCarro fabrica = good.new FabricaFiat();
    CarroSedan sedan = fabrica.criarCarroSedan();
    CarroPopular popular = fabrica.criarCarroPopular();
    sedan.exibirInfoSedan();
    System.out.println();
    popular.exibirInfoPopular();
    System.out.println();
 
    FabricaDeCarro fabrica2 = good.new FabricaFord();
    CarroSedan sedan2 = fabrica.criarCarroSedan();
    CarroPopular popular2 = fabrica.criarCarroPopular();
    sedan.exibirInfoSedan();
    System.out.println();
    popular.exibirInfoPopular();
    System.out.println();
  }
}