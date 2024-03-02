package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n03.S05T01N03RieraLizcanoOriol.Model.domain;

public class FlorEntity {

    private Integer pk_FlorID;
    private String nomFlor;
    private String paisFlor;

    public FlorEntity(){}
    public FlorEntity(String nomFlor, String paisFlor){
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
    }

    public Integer getPk_FlorID() {
        return pk_FlorID;
    }
    public void setPk_FlorID(Integer pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }
    public String getNomFlor() {
        return nomFlor;
    }
    public void setNomFlor(String nomFlor) {
        this.nomFlor = nomFlor;
    }
    public String getPaisFlor() {
        return paisFlor;
    }
    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }

    @Override
    public String toString() {
        return "FlorEntity{" + "pk_FlorID=" + pk_FlorID + ", nomFlor='" + nomFlor + '\'' + ", paisFlor='" + paisFlor + '\'' + '}';
    }
}
