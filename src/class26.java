// 
// Decompiled by Procyon v0.5.36
// 

public class class26
{
    static String field219;
    static MouseRecorder mouseRecorder;
    static int port1;
    
    public static PacketNode method433(final ClientPacket clientpacket_0, final ISAACCipher isaaccipher_0) {
        PacketNode packetnode_0;
        if (PacketNode.field2258 == 0) {
            packetnode_0 = new PacketNode();
        }
        else {
            packetnode_0 = PacketNode.packetBufferNodes[--PacketNode.field2258];
        }
        packetnode_0.clientPacket = clientpacket_0;
        packetnode_0.field2253 = clientpacket_0.packetLength;
        if (packetnode_0.field2253 == -1) {
            packetnode_0.packetBuffer = new PacketBuffer(260);
        }
        else if (packetnode_0.field2253 == -2) {
            packetnode_0.packetBuffer = new PacketBuffer(10000);
        }
        else if (packetnode_0.field2253 <= 18) {
            packetnode_0.packetBuffer = new PacketBuffer(20);
        }
        else if (packetnode_0.field2253 <= 98) {
            packetnode_0.packetBuffer = new PacketBuffer(100);
        }
        else {
            packetnode_0.packetBuffer = new PacketBuffer(260);
        }
        packetnode_0.packetBuffer.setIsaacCipher(isaaccipher_0);
        packetnode_0.packetBuffer.putOpcode(packetnode_0.clientPacket.packetId);
        packetnode_0.field2255 = 0;
        return packetnode_0;
    }
    
    public static void method427(final int int_0) {
        class217.field2460 = 1;
        class138.field1871 = null;
        class217.field2461 = -1;
        class217.field2462 = -1;
        class309.field3740 = 0;
        class217.field2463 = false;
        class6.field37 = int_0;
    }
    
    static int method428(final World world_0, final World world_1, final int int_0, final boolean bool_0) {
        if (int_0 == 1) {
            int int_ = world_0.playerCount;
            int int_2 = world_1.playerCount;
            if (!bool_0) {
                if (int_ == -1) {
                    int_ = 2001;
                }
                if (int_2 == -1) {
                    int_2 = 2001;
                }
            }
            return int_ - int_2;
        }
        return (int_0 == 2) ? (world_0.location - world_1.location) : ((int_0 == 3) ? (world_0.activity.equals("-") ? (world_1.activity.equals("-") ? 0 : (bool_0 ? -1 : 1)) : (world_1.activity.equals("-") ? (bool_0 ? 1 : -1) : world_0.activity.compareTo(world_1.activity))) : ((int_0 == 4) ? (world_0.method1569() ? (world_1.method1569() ? 0 : 1) : (world_1.method1569() ? -1 : 0)) : ((int_0 == 5) ? (world_0.method1567() ? (world_1.method1567() ? 0 : 1) : (world_1.method1567() ? -1 : 0)) : ((int_0 == 6) ? (world_0.method1568() ? (world_1.method1568() ? 0 : 1) : (world_1.method1568() ? -1 : 0)) : ((int_0 == 7) ? (world_0.method1589() ? (world_1.method1589() ? 0 : 1) : (world_1.method1589() ? -1 : 0)) : (world_0.id - world_1.id))))));
    }
}
