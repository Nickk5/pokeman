/**
 * pokemon class to represent a pokemon
 * @author Nicholas Kicinski
*/
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

  public Pokemon() {
  }

  /**
   *
   * @param name the name of the pokemon
   * @param type the typing of the pokemon
   * @param atk the attack of the pokemon
   * @param def the defense of the pokemon
   * @param spatk the special attack of the pokemon
   * @param spdef the special defense of the pokemon
   * @param hp the health points of the pokemon
   * @param spd the speed of the pokemon
   * @param move the moves that the pokemon knows
   */

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

  /**
   *
   * @return the pokemon's typing
   */
  public String[] getType() {
    return type;
  }

  /**
   * sets the pokemon's type
   * @param type becomes the new typing of the pokemon
   */
  public void setType(String[] type) {
    this.type = type;
  }

  /**
   *
   * @return the pokemon's name
   */
  public String getName() {
    return name;
  }

  /**
   *
   * sets the pokemon's name
   * @param name becomes the name of th pokemon
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   *
   * @return the attack of the pokemon
   */
  public int getAtk() {
    return atk;
  }

  /**
   * sets the pokemon's attack
   * @param atk becomes the pokemon's atk
   */
  public void setAtk(int atk) {
    this.atk = atk;
  }

  /**
   *
   * @return the pokemon's defense
   */
  public int getDef() {
    return def;
  }

  /**
   * sets the pokemon's defense
   * @param def becomes the pokemon's defense
   */
  public void setDef(int def) {
    this.def = def;
  }

  /**
   *
   * @return special attack of the pokemon
   */
  public int getSpatk() {
    return spatk;
  }

  /**
   * sets the pokemon's special attack
   * @param spatk becomes the pokemon's special attack
   */
  public void setSpatk(int spatk) {
    this.spatk = spatk;
  }

  /**
   *
   * @return special defense of the pokemon
   */
  public int getSpdef() {
    return spdef;
  }

  /**
   * sets the pokemon's special defense
   * @param spdef becomes the special defense of the pokemon
   */
  public void setSpdef(int spdef) {
    this.spdef = spdef;
  }

  /**
   *
   * @return hit points of the pokeomn
   */
  public int getHp() {
    return hp;
  }

  /**
   * sets pokemon's hp
   * @param hp becomes the pokemon's hp
   */
  public void setHp(int hp) {
    this.hp = hp;
  }

  /**
   *
   * @return speed of the pokemon
   */
  public int getSpd() {
    return spd;
  }

  /**
   * sets the speed of the pokemon
   * @param spd becomes the speed of the pokemon
   */
  public void setSpd(int spd) {
    this.spd = spd;
  }

  /**
   *
   * @return pokemon's special attack change
   */
  public double getSpatkchange() {
    return spatkchange;
  }

  /**
   * changes the special attack change of the pokemon
   * @param spatkchange becomes the special attack change of the pokemon
   */
  public void setSpatkchange(double spatkchange) {
    this.spatkchange = spatkchange;
  }

  /**
   *
   * @return defense change of the pokemon
   */
  public double getDefchange() {
    return defchange;
  }

  /**
   * sets the defense change of the pokemon
   * @param defchange
   */
  public void setDefchange(double defchange) {
    this.defchange = defchange;
  }

  /**
   *
   * @return the defense change of the pokemon
   */
  public double getAtkchange() {
    return atkchange;
  }

  /**
   * sets the attack change of the pokemon
   * @param atkchange becomes the attack change in the pokeon
   */
  public void setAtkchange(double atkchange) {
    this.atkchange = atkchange;
  }

  /**
   * inflicts damage onto the pokemon
   * @param damage the amount of damage inflicted
   */
  public void inflictDamage(double damage)
  {
    hp -= (int) damage;
  }

  /**
   *
   * @return the moves the pokemon has
   */
  public Moves[] getMoves() {
    return moves;
  }

  /**
   * sets the moves that the pokemon knows
   * @param moves becomes the moves that pokemon knows
   */
  public void setMoves(Moves[] moves) {
    this.moves = moves;
  }
}

