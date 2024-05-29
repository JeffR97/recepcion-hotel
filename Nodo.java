
package ProyectoFinal;

public class Nodo {
  // Atributo info--
  int infoEd, infonHab, infoPrecServ, infoCantPrenda, infoCaPerSpa, infoDiasVehic, infoValH,info;
  String infoNom, infoGen, infotHab, infoEst, infoCodServ, infonomServ, infoCC, infoCajaF,infoMetPago;

  Nodo sig;// Para enlazar el Nodo siguiente de la lista
  Nodo cima;

  // Constructor
  // public Nodo(String codServ, String nomServ) {
  //   this.infoCodServ = codServ;
  //   this.infoNom = codServ;
  //   this.sig = null;
  // }
  public Nodo(){
    this.sig = null;
  }
}
