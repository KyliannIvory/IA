public class Seau {

    private final int contenance;
    private int quantiteActuelle ;

    public Seau (int contenance, int quantiteActuelle){
        this.contenance = contenance;
        this.quantiteActuelle = quantiteActuelle;
    }

    public boolean estPlein(){
        return quantiteActuelle == contenance;
    }

    public boolean estVide(){
        return quantiteActuelle == 0;
    }

    public void remplir(){
        if(!estPlein())
            setQuantiteActuelle(contenance);
    }

    public void vider(){
        if(!estVide())
            setQuantiteActuelle(0);
    }

    public void transvaserVers(Seau destination){
        if ((!this.estVide()) && (!destination.estPlein())){
           // while()
            // TODO: 29/01/2024 à terminer

        }
    }

    public int getContenance() {
        return contenance;
    }


    public int getQuantiteActuelle() {
        return quantiteActuelle;
    }

    public void setQuantiteActuelle(int quantiteActuelle) {
        this.quantiteActuelle = quantiteActuelle;
    }
}
