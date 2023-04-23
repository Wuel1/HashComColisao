package hashColisao;

public class EstruturaHashTable implements EstruturaDeDados {
    private Integer tabela[];
    private Integer porao[];

    public EstruturaHashTable() {
        tabela = new Integer[1000];
        porao = new Integer[100];
    }

    @Override
    public boolean insert(int chave) {
        int indice = Hash(chave);
        if (tabela[indice] == null) {
            tabela[indice] = chave;
            return true;
        } else {            
            while(indice <= porao.length){
                if(porao[indice] == null){
                   porao[indice] = chave;
                   return true;
                }
                indice++;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int chave) {
        int indice = Hash(chave);
        if (tabela[indice] != null && tabela[indice] == chave) {
            tabela[indice] = null;
            return true;
        } else{
            if(tabela[indice] != null && tabela[indice] != chave){
                while(indice <= porao.length){
                    if(porao[indice] != null && porao[indice] == chave){
                       porao[indice] = null;
                       return true;
                    }
                    indice++;
                }
            }
        }
        return false;
    }

    @Override
    public int search(int chave) {
        int indice = Hash(chave);
        if (tabela[indice] != null && tabela[indice] == chave) {
            return indice;
        }        
        return -1;
    }

    private int Hash(int chave) {
        int retornoHash = chave % tabela.length;
        return retornoHash;
    }
}
