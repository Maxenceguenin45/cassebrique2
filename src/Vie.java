public class Vie extends Rond {
    private boolean flag =true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Vie(int positionX, int positionY, int diametre) {
        super(positionX, positionY, diametre);
    }
}
