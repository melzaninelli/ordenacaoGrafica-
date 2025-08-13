package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.core.utils.CoreUtils;
import br.com.davidbuzatto.jsge.core.utils.DrawingUtils;
import br.com.davidbuzatto.jsge.geom.Rectangle;
import br.com.davidbuzatto.jsge.image.Image;
import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de projeto básico da JSGE.
 * 
 * JSGE basic project template.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Main extends EngineFrame {
    
    private int[] array;
    private List<int[]> arrays;
    private int copiaAtual;
    
    private double tempoParaMudar;
    private double contadorTempo;
    
    public Main() {
        
        super(
            800,                 // largura                      / width
            450,                 // algura                       / height
            "Project Ordenações",      // título                       / title
            60,                  // quadros por segundo desejado / target FPS
            true,                // suavização                   / antialiasing
            false,               // redimensionável              / resizable
            false,               // tela cheia                   / full screen
            false,               // sem decoração                / undecorated
            false,               // sempre no topo               / always on top
            false                // fundo invisível              / invisible background
        );
        
    }
    
    /**
     * Cria o mundo do jogo.
     * Esse método executa apenas uma vez durante a inicialização da engine.
     * 
     * Creates the game world.
     * This method runs just one time during engine initialization.
     */
    @Override
    public void create() {
        
        array = new int[]{7,3,1,2,9,4,6,8,5,10};
        arrays = new ArrayList<>();
        selectionSort( array );
        tempoParaMudar = 0.5;
    }
    
    private  void selectionSort( int[] array){
        
        for( int i = 0; i < array.length; i++){
            
            int min = i;
            for (int j=i+1; j < array.length; j++){
                if( array[j] < array[min]){
                    min = j;
                }

}
            copiar(array);
            
            //troca
            int t = array[i];
            array[i] = array[min];
            array[min] = t;
        }
        
        copiar(array);
    }

    private void copiar(int[] array1) {
        int[] copia = new int[array1.length];
        System.arraycopy(array1, 0, copia, 0, array1.length);
        arrays.add( copia );
    }
    /**
     * Lê a entrada do usuário e atualiza o mundo do jogo.
     * Os métodos de entrada devem ser usados aqui.
     * Atenção: Você NÃO DEVE usar nenhum dos métodos de desenho da engine aqui.
     * 
     * 
     * Reads user input and update game world.
     * Input methods should be used here.
     * Warning: You MUST NOT use any of the engine drawing methods here.
     * 
     * @param delta O tempo passado, em segundos, de um quadro para o outro.
     * Time passed, in seconds, between frames.
     */
    @Override
    public void update( double delta ) {
        
        contadorTempo += delta;
        if(contadorTempo >= tempoParaMudar){
            contadorTempo = 0;
            copiaAtual++;
            if(copiaAtual < arrays.size() -1){
                copiaAtual++;
            }
        }
        
    }
    
    /**
     * Desenha o mundo do jogo.
     * Todas as operações de desenho DEVEM ser feitas aqui.
     * 
     * Draws the game world.
     * All drawing related operations MUST be performed here.
     */
    @Override
    public void draw() {
        
        clearBackground( PINK );

        
        int tamanho = 20;
        int espaco = 5;
        int xIni = 10;
        int yIni = getScreenHeight () / 2;
        
       
        int[] a = arrays.get(copiaAtual);   
        
           for( int i = 0; i < a.length; i++ ){
            
            int altura = tamanho * a[i];
        
            fillRectangle (xIni + (tamanho + espaco )* i, yIni - altura, tamanho, altura, PURPLE);
        }
           
    }
    
    /**
     * Instancia a engine e a inicia.
     * 
     * Instantiates the engine and starts it.
     */
    public static void main( String[] args ) {
        new Main();
    }
    
}
