public class Pokemon {
  private String name;
  private String[] type;
  private Moves[] moves;
  private int atk;
  private int def;
  private int spatk;
  private int spdef;
  private int hp;
  private int spd;
  private double atkchange;
  private double defchange;
  private double spdchange;
  private double spdefchange;
  private double spatkchange;

  public Pokemon(String name, String[] type, int atk, int def, int spatk, int spdef, int hp, int spd, Moves[] move) {
    this.name = name;
    this.type = type;
    this.atk = atk;
    this.def = def;
    this.spatk = spatk;
    this.spdef = spdef;
    this.hp = hp;
    this.spd = spd;
    atkchange = 1;
    defchange = 1;
    spdchange = 1;
    spdefchange = 1;
    spatkchange = 1;
    this.moves = move;
  }

  public String[] getType() {
    return type;
  }

  public void setType(String[] type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAtk() {
    return atk;
  }

  public void setAtk(int atk) {
    this.atk = atk;
  }

  public int getDef() {
    return def;
  }

  public void setDef(int def) {
    this.def = def;
  }

  public int getSpatk() {
    return spatk;
  }

  public void setSpatk(int spatk) {
    this.spatk = spatk;
  }

  public int getSpdef() {
    return spdef;
  }

  public void setSpdef(int spdef) {
    this.spdef = spdef;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public int getSpd() {
    return spd;
  }

  public void setSpd(int spd) {
    this.spd = spd;
  }

  public double getSpatkchange() {
    return spatkchange;
  }

  public void setSpatkchange(double spatkchange) {
    this.spatkchange = spatkchange;
  }

  public double getSpdefchange() {
    return spdefchange;
  }

  public void setSpdefchange(double spdefchange) {
    this.spdefchange = spdefchange;
  }

  public double getSpdchange() {
    return spdchange;
  }

  public void setSpdchange(double spdchange) {
    this.spdchange = spdchange;
  }

  public double getDefchange() {
    return defchange;
  }

  public void setDefchange(double defchange) {
    this.defchange = defchange;
  }

  public double getAtkchange() {
    return atkchange;
  }

  public void setAtkchange(double atkchange) {
    this.atkchange = atkchange;
  }

  public void inflictDamage(double damage)
  {
    hp -= (int) damage;
  }

  public Moves[] getMoves() {
    return moves;
  }

  public void setMoves(Moves[] moves) {
    this.moves = moves;
  }
}

