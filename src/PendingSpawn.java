// 
// Decompiled by Procyon v0.5.36
// 

public final class PendingSpawn extends Node
{
    static class157 field869;
    static int baseX;
    int field859;
    int level;
    int type;
    int x;
    int y;
    int field865;
    int field866;
    int id;
    int orientation;
    int field864;
    int delay;
    int hitpoints;
    
    PendingSpawn() {
    	System.out.println("<Construct Pendingspawn>");
        this.delay = 0;
        this.hitpoints = -1;
    }
    
    public static PacketNode method1536() {
        PacketNode packetnode_0;
        if (PacketNode.field2258 == 0) {
            packetnode_0 = new PacketNode();
        }
        else {
            packetnode_0 = PacketNode.packetBufferNodes[--PacketNode.field2258];
        }
        packetnode_0.clientPacket = null;
        packetnode_0.field2253 = 0;
        packetnode_0.packetBuffer = new PacketBuffer(5000);
        return packetnode_0;
    }
    
    static void method1537(final int int_0, final int int_1, final boolean bool_0) {
    	System.out.println("method1537: "+int_0+","+int_1+","+bool_0);
        if (!bool_0 || int_0 != WorldMapType2.field224 || class34.field301 != int_1) {
            WorldMapType2.field224 = int_0;
            class34.field301 = int_1;
            MouseInput.setGameState(25);
            class83.method1933("Loading - please wait.", true);
            int int_2 = PendingSpawn.baseX;
            int int_3 = Game.baseY;
            PendingSpawn.baseX = (int_0 - 6) * 8;
            Game.baseY = (int_1 - 6) * 8;
            final int int_4 = PendingSpawn.baseX - int_2;
            final int int_5 = Game.baseY - int_3;
            int_2 = PendingSpawn.baseX;
            int_3 = Game.baseY;
            System.out.println("Checking npcs");
            for (int int_6 = 0; int_6 < 32768; ++int_6) {
                final NPC npc_0 = Game.cachedNPCs[int_6];
                if (npc_0 != null) {
                    for (int int_7 = 0; int_7 < 10; ++int_7) {
                        final int[] pathX = npc_0.pathX;
                        final int n = int_7;
                        pathX[n] -= int_4;
                        final int[] pathY = npc_0.pathY;
                        final int n2 = int_7;
                        pathY[n2] -= int_5;
                    }
                    final NPC npc = npc_0;
                    npc.x -= int_4 * 128;
                    final NPC npc2 = npc_0;
                    npc2.y -= int_5 * 128;
                }
            }
            System.out.println("Checking players");
            for (int int_6 = 0; int_6 < 2048; ++int_6) {
                final Player player_0 = Game.cachedPlayers[int_6];
                if (player_0 != null) {
                    for (int int_7 = 0; int_7 < 10; ++int_7) {
                        final int[] pathX2 = player_0.pathX;
                        final int n3 = int_7;
                        pathX2[n3] -= int_4;
                        final int[] pathY2 = player_0.pathY;
                        final int n4 = int_7;
                        pathY2[n4] -= int_5;
                    }
                    final Player player = player_0;
                    player.x -= int_4 * 128;
                    final Player player2 = player_0;
                    player2.y -= int_5 * 128;
                }
            }
            byte byte_4 = 0;
            byte byte_5 = 104;
            byte byte_6 = 1;
            if (int_4 < 0) {
                byte_4 = 103;
                byte_5 = -1;
                byte_6 = -1;
            }
            byte byte_7 = 0;
            byte byte_8 = 104;
            byte byte_9 = 1;
            if (int_5 < 0) {
                byte_7 = 103;
                byte_8 = -1;
                byte_9 = -1;
            }
            System.out.println("Checking items");
            for (int int_8 = byte_4; byte_5 != int_8; int_8 += byte_6) {
                for (int int_9 = byte_7; int_9 != byte_8; int_9 += byte_9) {
                    final int int_10 = int_4 + int_8;
                    final int int_11 = int_9 + int_5;
                    for (int int_12 = 0; int_12 < 4; ++int_12) {
                        if (int_10 >= 0 && int_11 >= 0 && int_10 < 104 && int_11 < 104) {
                            Game.groundItemDeque[int_12][int_8][int_9] = Game.groundItemDeque[int_12][int_10][int_11];
                        }
                        else {
                            Game.groundItemDeque[int_12][int_8][int_9] = null;
                        }
                    }
                }
            }
            System.out.println("Checking pendingspawns");
            for (PendingSpawn pendingspawn_0 = (PendingSpawn)Game.pendingSpawns.getFront(); pendingspawn_0 != null; pendingspawn_0 = (PendingSpawn)Game.pendingSpawns.getNext()) {
                final PendingSpawn pendingSpawn = pendingspawn_0;
                pendingSpawn.x -= int_4;
                final PendingSpawn pendingSpawn2 = pendingspawn_0;
                pendingSpawn2.y -= int_5;
                if (pendingspawn_0.x < 0 || pendingspawn_0.y < 0 || pendingspawn_0.x >= 104 || pendingspawn_0.y >= 104) {
                    pendingspawn_0.unlink();
                }
            }
            if (Game.destinationX != 0) {
                Game.destinationX -= int_4;
                Game.destinationY -= int_5;
            }
            Game.queuedSoundEffectCount = 0;
            Game.field822 = false;
            CacheFile.cameraX -= int_4 << 7;
            Coordinates.cameraY -= int_5 << 7;
            CacheFile.field1428 -= int_4 << 7;
            GrandExchangeEvent.field23 -= int_5 << 7;
            Game.field651 = -1;
            Game.graphicsObjectDeque.clear();
            Game.projectiles.clear();
            for (int int_9 = 0; int_9 < 4; ++int_9) {
                Game.collisionMaps[int_9].reset();
            }
        }
    }
    
    static void method1538(final Player player_0, final int int_0, final int int_1, final byte byte_0) {
        final int int_2 = player_0.pathX[0];
        final int int_3 = player_0.pathY[0];
        final int int_4 = player_0.getSize();
        if (int_2 >= int_4 && int_2 < 104 - int_4 && int_3 >= int_4 && int_3 < 104 - int_4 && int_0 >= int_4 && int_0 < 104 - int_4 && int_1 >= int_4 && int_1 < 104 - int_4) {
            final int int_5 = player_0.getSize();
            Game.field849.field2043 = int_0;
            Game.field849.field2048 = int_1;
            Game.field849.field2042 = 1;
            Game.field849.field2045 = 1;
            final class59 class59_0 = Game.field849;
            final int int_6 = ItemLayer.method2566(int_2, int_3, int_5, class59_0, Game.collisionMaps[player_0.field567], true, Game.field850, Game.field596);
            if (int_6 >= 1) {
                for (int int_7 = 0; int_7 < int_6 - 1; ++int_7) {
                    player_0.method1105(Game.field850[int_7], Game.field596[int_7], byte_0);
                }
            }
        }
    }
}
