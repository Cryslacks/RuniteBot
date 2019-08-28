// 
// Decompiled by Procyon v0.5.36
// 

public class InvType extends CacheableNode
{
    static IndexDataBase field3226;
    static NodeCache inventoryCache;
    static boolean middleMouseMovesCamera;
    public int size;
    
    InvType() {
        this.size = 0;
    }
    
    void decode(final Buffer buffer_0) {
        while (true) {
            final int int_0 = buffer_0.readUnsignedByte();
            if (int_0 == 0) {
                break;
            }
            this.method4805(buffer_0, int_0);
        }
    }
    
    void method4805(final Buffer buffer_0, final int int_0) {
        if (int_0 == 2) {
            this.size = buffer_0.readUnsignedShort();
        }
    }
    
    static void groundItemSpawned(final int int_0, final int int_1) {
    	//System.out.println("<groundItemSpawned> Args: "+int_0+", "+int_1);
        final Deque deque_0 = Game.groundItemDeque[class13.plane][int_0][int_1];
        if (deque_0 == null) {
            MapIcon.region.removeGroundItemPile(class13.plane, int_0, int_1);
        }
        else {
            long long_0 = -99999999L;
            Item item_0 = null;
            for (Item item_2 = (Item)deque_0.getFront(); item_2 != null; item_2 = (Item)deque_0.getNext()) {
                final ItemComposition itemcomposition_0 = TextureProvider.getItemDefinition(item_2.id);
                //System.out.println("Item dropped: "+itemcomposition_0.name);
                long long_2 = itemcomposition_0.price;
                if (itemcomposition_0.isStackable == 1) {
                    long_2 *= item_2.quantity + 1;
                }
                if (long_2 > long_0) {
                    long_0 = long_2;
                    item_0 = item_2;
                }
            }
            if (item_0 == null) {
                MapIcon.region.removeGroundItemPile(class13.plane, int_0, int_1);
            }
            else {
                deque_0.addTail(item_0);
                Item item_3 = null;
                Item item_4 = null;
                for (Item item_2 = (Item)deque_0.getFront(); item_2 != null; item_2 = (Item)deque_0.getNext()) {
                    if (item_2.id != item_0.id) {
                        if (item_3 == null) {
                            item_3 = item_2;
                        }
                        if (item_3.id != item_2.id && item_4 == null) {
                            item_4 = item_2;
                        }
                    }
                }
                final long long_3 = class76.method1804(int_0, int_1, 3, false, 0);
                MapIcon.region.method2879(class13.plane, int_0, int_1, WorldMapType2.getTileHeight(int_0 * 128 + 64, int_1 * 128 + 64, class13.plane), item_0, long_3, item_3, item_4);
            }
        }
    }
    
    static {
        InvType.inventoryCache = new NodeCache(64);
    }
}
