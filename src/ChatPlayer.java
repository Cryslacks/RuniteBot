// 
// Decompiled by Procyon v0.5.36
// 

public class ChatPlayer extends Nameable
{
    public int world;
    public int field3627;
    public int rank;
    
    ChatPlayer() {
        this.world = -1;
    }
    
    void method5412(final int int_0, final int int_1) {
        this.world = int_0;
        this.field3627 = int_1;
    }
    
    public int method5414() {
        return this.world;
    }
    
    public boolean method5415() {
        return this.world > 0;
    }
}
