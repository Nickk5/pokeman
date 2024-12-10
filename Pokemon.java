public class Pokemon
{
  private int atk;
  private int def;
  private int spatk;
  private int spdef;
  private int hp;
  private int spd;

  public Pokemon(int atk, int def, int spatk, int spdef, int hp, int spd) {
    this.atk = atk;
    this.def = def;
    this.spatk = spatk;
    this.spdef = spdef;
    this.hp = hp;
    this.spd = spd;
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
}
