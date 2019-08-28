import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;

// 
// Decompiled by Procyon v0.5.36
// 

public final class KeyFocusListener implements KeyListener, FocusListener
{
    public static KeyFocusListener keyboard;
    public static boolean[] keyPressed;
    public static char currentTypedKey;
    public static int[] field343;
    public static int field344;
    public static int field329;
    static char[] field346;
    static int[] field348;
    public static int[] field338;
    public static int field349;
    public static int field350;
    public static int field351;
    public static int field352;
    public static int keyboardIdleTicks;
    static int[] KeyHandler_keyCodes;
    
    @Override
    public synchronized void keyPressed(final KeyEvent keyevent_0) {
        if (KeyFocusListener.keyboard != null) {
        	/*if(keyevent_0.getKeyCode() == 10)
        		System.out.println("<keyPressed> Args: [ENTER], "+keyevent_0.getKeyCode());
        	else if(keyevent_0.getKeyCode() == 8)
        		System.out.println("<keyPressed> Args: [BACKSPACE], "+keyevent_0.getKeyCode());
        	else
        		System.out.println("<keyPressed> Args: "+keyevent_0.getKeyChar()+", "+keyevent_0.getKeyCode());
        		*/
            int keyCode = keyevent_0.getKeyCode();
            if (keyCode >= 0 && keyCode < KeyFocusListener.KeyHandler_keyCodes.length) {
                keyCode = KeyFocusListener.KeyHandler_keyCodes[keyCode];
                if ((keyCode & 0x80) != 0x0) {
                    keyCode = -1;
                }
            }
            else {
                keyCode = -1;
            }
            if (KeyFocusListener.field329 >= 0 && keyCode >= 0) {
                KeyFocusListener.field343[KeyFocusListener.field329] = keyCode;
                KeyFocusListener.field329 = (KeyFocusListener.field329 + 1 & 0x7F);
                if (KeyFocusListener.field344 == KeyFocusListener.field329) {
                    KeyFocusListener.field329 = -1;
                }
            }
            if (keyCode >= 0) {
                final int int_2 = KeyFocusListener.field351 + 1 & 0x7F;
                if (int_2 != KeyFocusListener.field350) {
                    KeyFocusListener.field348[KeyFocusListener.field351] = keyCode;
                    KeyFocusListener.field346[KeyFocusListener.field351] = '\0';
                    KeyFocusListener.field351 = int_2;
                }
            }
            final int int_2 = keyevent_0.getModifiers();
            if ((int_2 & 0xA) != 0x0 || keyCode == 85 || keyCode == 10) {
                keyevent_0.consume();
            }
        }
    }
    
    @Override
    public synchronized void keyReleased(final KeyEvent keyevent_0) {
        if (KeyFocusListener.keyboard != null) {
            int int_0 = keyevent_0.getKeyCode();
            if (int_0 >= 0 && int_0 < KeyFocusListener.KeyHandler_keyCodes.length) {
                int_0 = (KeyFocusListener.KeyHandler_keyCodes[int_0] & 0xFFFFFF7F);
            }
            else {
                int_0 = -1;
            }
            if (KeyFocusListener.field329 >= 0 && int_0 >= 0) {
                KeyFocusListener.field343[KeyFocusListener.field329] = ~int_0;
                KeyFocusListener.field329 = (KeyFocusListener.field329 + 1 & 0x7F);
                if (KeyFocusListener.field329 == KeyFocusListener.field344) {
                    KeyFocusListener.field329 = -1;
                }
            }
        }
        keyevent_0.consume();
    }
    
    @Override
    public synchronized void focusLost(final FocusEvent focusevent_0) {
        if (KeyFocusListener.keyboard != null) {
            KeyFocusListener.field329 = -1;
        }
    }
    
    @Override
    public void focusGained(final FocusEvent focusevent_0) {
    }
    
    @Override
    public void keyTyped(final KeyEvent keyevent_0) {
        if (KeyFocusListener.keyboard != null) {
            final char keyChar = keyevent_0.getKeyChar();
            if (keyChar != '\0' && keyChar != '\uffff' && ClanMemberManager.method5496(keyChar)) {
                final int int_0 = KeyFocusListener.field351 + 1 & 0x7F;
                if (int_0 != KeyFocusListener.field350) {
                    KeyFocusListener.field348[KeyFocusListener.field351] = -1;
                    KeyFocusListener.field346[KeyFocusListener.field351] = keyChar;
                    KeyFocusListener.field351 = int_0;
                }
            }
        }
        keyevent_0.consume();
    }
    
    static IterableHashTable readStringIntParameters(final Buffer buffer_0, IterableHashTable iterablehashtable_0) {
        final int int_0 = buffer_0.readUnsignedByte();
        if (iterablehashtable_0 == null) {
            final int int_2 = class146.nextPowerOfTwo(int_0);
            iterablehashtable_0 = new IterableHashTable(int_2);
        }
        for (int int_2 = 0; int_2 < int_0; ++int_2) {
            final boolean bool_0 = buffer_0.readUnsignedByte() == 1;
            final int int_3 = buffer_0.read24BitInt();
            Object object_0;
            if (bool_0) {
                object_0 = new ObjectNode(buffer_0.readString());
            }
            else {
                object_0 = new IntegerNode(buffer_0.readInt());
            }
            iterablehashtable_0.put((Node)object_0, int_3);
        }
        return iterablehashtable_0;
    }
    
    public static int method673(final long long_0) {
        return (int)(long_0 >>> 17 & 0xFFFFFFFFL);
    }
    
    static void menuAction(final int int_0, final int int_1, int int_2, final int int_3, final String string_0, final String string_1, final int int_4, final int int_5) {
    	System.out.println("<MenuAction> Args: "+int_0+", "+int_1+", "+int_2+", "+int_3+", "+string_0+", "+string_1+", "+int_4+", "+int_5);
    	
    	if(string_0.equals("Bot") && string_1.equals("<col=ffff>Silver stall")){
    		if(SilverStallBot.active)
   				SilverStallBot.terminate();
   			else
   				new Thread(new SilverStallBot()).start();
   			
   			InformationBot.addChatMsg("SilverStallbot status is now "+(SilverStallBot.active ? "<col=00aa00>TRUE" : "<col=aa0000>FALSE"));
   		
    	}
    	
    	if (int_2 >= 2000) {
            int_2 -= 2000;
        }
        Label_5682: {
            if (int_2 == 1) {
                Game.lastLeftClickX = int_4;
                Game.lastLeftClickY = int_5;
                Game.cursorState = 2;
                Game.field803 = 0;
                Game.destinationX = int_0;
                Game.destinationY = int_1;
                final PacketNode packetnode_0 = class26.method433(ClientPacket.ITEM_ON_OBJECT, Game.field626.field1218);
                packetnode_0.packetBuffer.addLEShortA(class297.field3683);
                packetnode_0.packetBuffer.putByte(KeyFocusListener.keyPressed[82] ? 1 : 0);
                packetnode_0.packetBuffer.addInt1(class187.field2372);
                packetnode_0.packetBuffer.addLEShort(int_0 + PendingSpawn.baseX);
                packetnode_0.packetBuffer.putShort(Game.baseY + int_1);
                packetnode_0.packetBuffer.addShortA(int_3);
                packetnode_0.packetBuffer.putShort(class13.selectedItemIndex);
                Game.field626.method1980(packetnode_0);
            }
            else if (int_2 == 2) {
                Game.lastLeftClickX = int_4;
                Game.lastLeftClickY = int_5;
                Game.cursorState = 2;
                Game.field803 = 0;
                Game.destinationX = int_0;
                Game.destinationY = int_1;
                final PacketNode packetnode_0 = class26.method433(ClientPacket.ITEM_ON_INTERFACE, Game.field626.field1218);
                packetnode_0.packetBuffer.putByte(KeyFocusListener.keyPressed[82] ? 1 : 0);
                packetnode_0.packetBuffer.addInt2(SoundTaskDataProvider.field361);
                packetnode_0.packetBuffer.addLEShortA(Game.baseY + int_1);
                packetnode_0.packetBuffer.addLEShortA(Game.field736);
                packetnode_0.packetBuffer.addShortA(int_0 + PendingSpawn.baseX);
                packetnode_0.packetBuffer.addLEShortA(int_3);
                Game.field626.method1980(packetnode_0);
            }
            else if (int_2 == 3) {
                Game.lastLeftClickX = int_4;
                Game.lastLeftClickY = int_5;
                Game.cursorState = 2;
                Game.field803 = 0;
                
                Game.destinationX = int_0;
                Game.destinationY = int_1;

                final PacketNode packetnode_0 = class26.method433(ClientPacket.OBJECT_FIRST_ACTION, Game.field626.field1218);
                packetnode_0.packetBuffer.putShort(Game.baseY + int_1);
                packetnode_0.packetBuffer.addShortA(int_0 + PendingSpawn.baseX);
                packetnode_0.packetBuffer.putShort(int_3);
                packetnode_0.packetBuffer.putByte(KeyFocusListener.keyPressed[82] ? 1 : 0);
                Game.field626.method1980(packetnode_0);
            }
            else if (int_2 == 4) {
                Game.lastLeftClickX = int_4;
                Game.lastLeftClickY = int_5;
                Game.cursorState = 2;
                Game.field803 = 0;
                Game.destinationX = int_0;
                Game.destinationY = int_1;
                final PacketNode packetnode_0 = class26.method433(ClientPacket.OBJECT_SECOND_ACTION, Game.field626.field1218);
                packetnode_0.packetBuffer.addLEShort(int_0 + PendingSpawn.baseX);
                packetnode_0.packetBuffer.putShort(Game.baseY + int_1);
                packetnode_0.packetBuffer.addByteA(KeyFocusListener.keyPressed[82] ? 1 : 0);
                packetnode_0.packetBuffer.addLEShortA(int_3);
                Game.field626.method1980(packetnode_0);
            }
            else if (int_2 == 5) {
                Game.lastLeftClickX = int_4;
                Game.lastLeftClickY = int_5;
                Game.cursorState = 2;
                Game.field803 = 0;
                Game.destinationX = int_0;
                Game.destinationY = int_1;
                final PacketNode packetnode_0 = class26.method433(ClientPacket.OBJECT_THIRD_ACTION, Game.field626.field1218);
                packetnode_0.packetBuffer.addLEShortA(Game.baseY + int_1);
                packetnode_0.packetBuffer.addLEShortA(int_0 + PendingSpawn.baseX);
                packetnode_0.packetBuffer.addLEShortA(int_3);
                packetnode_0.packetBuffer.addByteC(KeyFocusListener.keyPressed[82] ? 1 : 0);
                Game.field626.method1980(packetnode_0);
            }
            else if (int_2 == 6) {
                Game.lastLeftClickX = int_4;
                Game.lastLeftClickY = int_5;
                Game.cursorState = 2;
                Game.field803 = 0;
                Game.destinationX = int_0;
                Game.destinationY = int_1;
                final PacketNode packetnode_0 = class26.method433(ClientPacket.OBJECT_FOURTH_ACTION, Game.field626.field1218);
                packetnode_0.packetBuffer.addShortA(int_3);
                packetnode_0.packetBuffer.addByteC(KeyFocusListener.keyPressed[82] ? 1 : 0);
                packetnode_0.packetBuffer.addLEShortA(int_0 + PendingSpawn.baseX);
                packetnode_0.packetBuffer.addLEShort(Game.baseY + int_1);
                Game.field626.method1980(packetnode_0);
            }
            else if (int_2 == 7) {
                final NPC npc_0 = Game.cachedNPCs[int_3];
                if (npc_0 != null) {
                    Game.lastLeftClickX = int_4;
                    Game.lastLeftClickY = int_5;
                    Game.cursorState = 2;
                    Game.field803 = 0;
                    Game.destinationX = int_0;
                    Game.destinationY = int_1;
                    final PacketNode packetnode_2 = class26.method433(ClientPacket.ITEM_ON_NPC, Game.field626.field1218);
                    packetnode_2.packetBuffer.putShort(class13.selectedItemIndex);
                    packetnode_2.packetBuffer.addByteS(KeyFocusListener.keyPressed[82] ? 1 : 0);
                    packetnode_2.packetBuffer.addLEShort(int_3);
                    packetnode_2.packetBuffer.addShortA(class297.field3683);
                    packetnode_2.packetBuffer.addInt2(class187.field2372);
                    Game.field626.method1980(packetnode_2);
                }
            }
            else if (int_2 == 8) {
                final NPC npc_0 = Game.cachedNPCs[int_3];
                if (npc_0 != null) {
                    Game.lastLeftClickX = int_4;
                    Game.lastLeftClickY = int_5;
                    Game.cursorState = 2;
                    Game.field803 = 0;
                    Game.destinationX = int_0;
                    Game.destinationY = int_1;
                    final PacketNode packetnode_2 = class26.method433(ClientPacket.SPELL_ON_NPC, Game.field626.field1218);
                    packetnode_2.packetBuffer.putInt(SoundTaskDataProvider.field361);
                    packetnode_2.packetBuffer.addShortA(Game.field736);
                    packetnode_2.packetBuffer.addLEShort(int_3);
                    packetnode_2.packetBuffer.putByte(KeyFocusListener.keyPressed[82] ? 1 : 0);
                    Game.field626.method1980(packetnode_2);
                }
            }
            else if (int_2 == 9) {
                final NPC npc_0 = Game.cachedNPCs[int_3];
                if (npc_0 != null) {
                    Game.lastLeftClickX = int_4;
                    Game.lastLeftClickY = int_5;
                    Game.cursorState = 2;
                    Game.field803 = 0;
                    Game.destinationX = int_0;
                    Game.destinationY = int_1;
                    final PacketNode packetnode_2 = class26.method433(ClientPacket.FIRST_NPC_ACTION, Game.field626.field1218);
                    packetnode_2.packetBuffer.addShortA(int_3);
                    packetnode_2.packetBuffer.addByteC(KeyFocusListener.keyPressed[82] ? 1 : 0);
                    Game.field626.method1980(packetnode_2);
                }
            }
            else if (int_2 == 10) {
                final NPC npc_0 = Game.cachedNPCs[int_3];
                if (npc_0 != null) {
                    Game.lastLeftClickX = int_4;
                    Game.lastLeftClickY = int_5;
                    Game.cursorState = 2;
                    Game.field803 = 0;
                    Game.destinationX = int_0;
                    Game.destinationY = int_1;
                    final PacketNode packetnode_2 = class26.method433(ClientPacket.SECOND_NPC_ACTION, Game.field626.field1218);
                    packetnode_2.packetBuffer.addLEShortA(int_3);
                    packetnode_2.packetBuffer.addByteS(KeyFocusListener.keyPressed[82] ? 1 : 0);
                    Game.field626.method1980(packetnode_2);
                }
            }
            else if (int_2 == 11) {
                final NPC npc_0 = Game.cachedNPCs[int_3];
                if (npc_0 != null) {
                    Game.lastLeftClickX = int_4;
                    Game.lastLeftClickY = int_5;
                    Game.cursorState = 2;
                    Game.field803 = 0;
                    Game.destinationX = int_0;
                    Game.destinationY = int_1;
                    final PacketNode packetnode_2 = class26.method433(ClientPacket.THIRD_NPC_ACTION, Game.field626.field1218);
                    packetnode_2.packetBuffer.addByteA(KeyFocusListener.keyPressed[82] ? 1 : 0);
                    packetnode_2.packetBuffer.addLEShortA(int_3);
                    Game.field626.method1980(packetnode_2);
                }
            }
            else if (int_2 == 12) {
                final NPC npc_0 = Game.cachedNPCs[int_3];
                if (npc_0 != null) {
                    Game.lastLeftClickX = int_4;
                    Game.lastLeftClickY = int_5;
                    Game.cursorState = 2;
                    Game.field803 = 0;
                    Game.destinationX = int_0;
                    Game.destinationY = int_1;
                    final PacketNode packetnode_2 = class26.method433(ClientPacket.FOURTH_NPC_ACTION, Game.field626.field1218);
                    packetnode_2.packetBuffer.addByteA(KeyFocusListener.keyPressed[82] ? 1 : 0);
                    packetnode_2.packetBuffer.addLEShort(int_3);
                    Game.field626.method1980(packetnode_2);
                }
            }
            else if (int_2 == 13) {
                final NPC npc_0 = Game.cachedNPCs[int_3];
                if (npc_0 != null) {
                    Game.lastLeftClickX = int_4;
                    Game.lastLeftClickY = int_5;
                    Game.cursorState = 2;
                    Game.field803 = 0;
                    Game.destinationX = int_0;
                    Game.destinationY = int_1;
                    final PacketNode packetnode_2 = class26.method433(ClientPacket.FIFTH_NPC_ACTION, Game.field626.field1218);
                    packetnode_2.packetBuffer.addShortA(int_3);
                    packetnode_2.packetBuffer.addByteC(KeyFocusListener.keyPressed[82] ? 1 : 0);
                    Game.field626.method1980(packetnode_2);
                }
            }
            else if (int_2 == 14) {
                final Player player_0 = Game.cachedPlayers[int_3];
                if (player_0 != null) {
                    Game.lastLeftClickX = int_4;
                    Game.lastLeftClickY = int_5;
                    Game.cursorState = 2;
                    Game.field803 = 0;
                    Game.destinationX = int_0;
                    Game.destinationY = int_1;
                    final PacketNode packetnode_2 = class26.method433(ClientPacket.ITEM_ON_PLAYER, Game.field626.field1218);
                    packetnode_2.packetBuffer.addLEShortA(class13.selectedItemIndex);
                    packetnode_2.packetBuffer.addLEShort(class297.field3683);
                    packetnode_2.packetBuffer.addInt1(class187.field2372);
                    packetnode_2.packetBuffer.addByteS(KeyFocusListener.keyPressed[82] ? 1 : 0);
                    packetnode_2.packetBuffer.putShort(int_3);
                    Game.field626.method1980(packetnode_2);
                }
            }
            else if (int_2 == 15) {
                final Player player_0 = Game.cachedPlayers[int_3];
                if (player_0 != null) {
                    Game.lastLeftClickX = int_4;
                    Game.lastLeftClickY = int_5;
                    Game.cursorState = 2;
                    Game.field803 = 0;
                    Game.destinationX = int_0;
                    Game.destinationY = int_1;
                    final PacketNode packetnode_2 = class26.method433(ClientPacket.SPELL_ON_PLAYER, Game.field626.field1218);
                    packetnode_2.packetBuffer.addLEInt(SoundTaskDataProvider.field361);
                    packetnode_2.packetBuffer.addLEShort(int_3);
                    packetnode_2.packetBuffer.addShortA(Game.field736);
                    packetnode_2.packetBuffer.addByteA(KeyFocusListener.keyPressed[82] ? 1 : 0);
                    Game.field626.method1980(packetnode_2);
                }
            }
            else if (int_2 == 16) {
                Game.lastLeftClickX = int_4;
                Game.lastLeftClickY = int_5;
                Game.cursorState = 2;
                Game.field803 = 0;
                Game.destinationX = int_0;
                Game.destinationY = int_1;
                final PacketNode packetnode_0 = class26.method433(ClientPacket.field2234, Game.field626.field1218);
                packetnode_0.packetBuffer.addLEShortA(int_3);
                packetnode_0.packetBuffer.putByte(KeyFocusListener.keyPressed[82] ? 1 : 0);
                packetnode_0.packetBuffer.addShortA(class297.field3683);
                packetnode_0.packetBuffer.addShortA(int_0 + PendingSpawn.baseX);
                packetnode_0.packetBuffer.putShort(Game.baseY + int_1);
                packetnode_0.packetBuffer.putInt(class187.field2372);
                packetnode_0.packetBuffer.putShort(class13.selectedItemIndex);
                Game.field626.method1980(packetnode_0);
            }
            else if (int_2 == 17) {
                Game.lastLeftClickX = int_4;
                Game.lastLeftClickY = int_5;
                Game.cursorState = 2;
                Game.field803 = 0;
                Game.destinationX = int_0;
                Game.destinationY = int_1;
                final PacketNode packetnode_0 = class26.method433(ClientPacket.SPELL_ON_GROUND_ITEM, Game.field626.field1218);
                packetnode_0.packetBuffer.addShortA(int_3);
                packetnode_0.packetBuffer.addLEShort(int_0 + PendingSpawn.baseX);
                packetnode_0.packetBuffer.addShortA(Game.field736);
                packetnode_0.packetBuffer.addLEShortA(Game.baseY + int_1);
                packetnode_0.packetBuffer.addInt1(SoundTaskDataProvider.field361);
                packetnode_0.packetBuffer.putByte(KeyFocusListener.keyPressed[82] ? 1 : 0);
                Game.field626.method1980(packetnode_0);
            }
            else if (int_2 == 18) {
                Game.lastLeftClickX = int_4;
                Game.lastLeftClickY = int_5;
                Game.cursorState = 2;
                Game.field803 = 0;
                Game.destinationX = int_0;
                Game.destinationY = int_1;
                final PacketNode packetnode_0 = class26.method433(ClientPacket.field2210, Game.field626.field1218);
                packetnode_0.packetBuffer.addLEShortA(Game.baseY + int_1);
                packetnode_0.packetBuffer.addByteC(KeyFocusListener.keyPressed[82] ? 1 : 0);
                packetnode_0.packetBuffer.addShortA(int_0 + PendingSpawn.baseX);
                packetnode_0.packetBuffer.putShort(int_3);
                Game.field626.method1980(packetnode_0);
            }
            else if (int_2 == 19) {
                Game.lastLeftClickX = int_4;
                Game.lastLeftClickY = int_5;
                Game.cursorState = 2;
                Game.field803 = 0;
                Game.destinationX = int_0;
                Game.destinationY = int_1;
                final PacketNode packetnode_0 = class26.method433(ClientPacket.field2214, Game.field626.field1218);
                packetnode_0.packetBuffer.addLEShort(int_3);
                packetnode_0.packetBuffer.addShortA(int_0 + PendingSpawn.baseX);
                packetnode_0.packetBuffer.addLEShort(Game.baseY + int_1);
                packetnode_0.packetBuffer.addByteS(KeyFocusListener.keyPressed[82] ? 1 : 0);
                Game.field626.method1980(packetnode_0);
            }
            else if (int_2 == 20) {
                Game.lastLeftClickX = int_4;
                Game.lastLeftClickY = int_5;
                Game.cursorState = 2;
                Game.field803 = 0;
                Game.destinationX = int_0;
                Game.destinationY = int_1;
                final PacketNode packetnode_0 = class26.method433(ClientPacket.TAKE_ITEM, Game.field626.field1218);
                packetnode_0.packetBuffer.putShort(int_0 + PendingSpawn.baseX);
                packetnode_0.packetBuffer.addShortA(int_3);
                packetnode_0.packetBuffer.addLEShort(Game.baseY + int_1);
                packetnode_0.packetBuffer.addByteC(KeyFocusListener.keyPressed[82] ? 1 : 0);
                Game.field626.method1980(packetnode_0);
            }
            else if (int_2 == 21) {
                Game.lastLeftClickX = int_4;
                Game.lastLeftClickY = int_5;
                Game.cursorState = 2;
                Game.field803 = 0;
                Game.destinationX = int_0;
                Game.destinationY = int_1;
                final PacketNode packetnode_0 = class26.method433(ClientPacket.field2205, Game.field626.field1218);
                packetnode_0.packetBuffer.addShortA(Game.baseY + int_1);
                packetnode_0.packetBuffer.addShortA(int_3);
                packetnode_0.packetBuffer.addLEShort(int_0 + PendingSpawn.baseX);
                packetnode_0.packetBuffer.addByteA(KeyFocusListener.keyPressed[82] ? 1 : 0);
                Game.field626.method1980(packetnode_0);
            }
            else if (int_2 == 22) {
                Game.lastLeftClickX = int_4;
                Game.lastLeftClickY = int_5;
                Game.cursorState = 2;
                Game.field803 = 0;
                Game.destinationX = int_0;
                Game.destinationY = int_1;
                final PacketNode packetnode_0 = class26.method433(ClientPacket.field2147, Game.field626.field1218);
                packetnode_0.packetBuffer.addLEShort(int_3);
                packetnode_0.packetBuffer.addLEShort(int_0 + PendingSpawn.baseX);
                packetnode_0.packetBuffer.putShort(Game.baseY + int_1);
                packetnode_0.packetBuffer.addByteS(KeyFocusListener.keyPressed[82] ? 1 : 0);
                Game.field626.method1980(packetnode_0);
            }
            else if (int_2 == 23) {
                if (Game.isMenuOpen) {
                    MapIcon.region.method2974();
                }
                else {
                    MapIcon.region.method2909(class13.plane, int_0, int_1, true);
                }
            }
            else if (int_2 == 24) {
                final Widget widget_1 = Widget.getWidget(int_1);
                boolean bool_0 = true;
                if (widget_1.contentType > 0) {
                    bool_0 = class25.method426(widget_1);
                }
                if (bool_0) {
                    final PacketNode packetnode_3 = class26.method433(ClientPacket.SMALL_BUTTON_PRESS, Game.field626.field1218);
                    packetnode_3.packetBuffer.putInt(int_1);
                    Game.field626.method1980(packetnode_3);
                }
            }
            else {
                if (int_2 == 25) {
                    final Widget widget_1 = class146.getWidgetChild(int_1, int_0);
                    if (widget_1 != null) {
                        class34.method585();
                        class155.method3275(int_1, int_0, Signlink.method3252(class24.getWidgetClickMask(widget_1)), widget_1.itemId);
                        Game.itemSelectionState = 0;
                        Game.field612 = class151.method3239(widget_1);
                        if (Game.field612 == null) {
                            Game.field612 = "Null";
                        }
                        if (widget_1.hasScript) {
                            Game.field739 = widget_1.opBase + class6.getColTags(16777215);
                        }
                        else {
                            Game.field739 = class6.getColTags(65280) + widget_1.spellName + class6.getColTags(16777215);
                        }
                    }
                    return;
                }
                if (int_2 == 26) {
                    final PacketNode packetnode_0 = class26.method433(ClientPacket.CLOSED_WINDOW, Game.field626.field1218);
                    Game.field626.method1980(packetnode_0);
                    for (WidgetNode widgetnode_0 = (WidgetNode)Game.componentTable.first(); widgetnode_0 != null; widgetnode_0 = (WidgetNode)Game.componentTable.next()) {
                        if (widgetnode_0.owner == 0 || widgetnode_0.owner == 3) {
                            WorldMapData.closeWidget(widgetnode_0, true);
                        }
                    }
                    if (Game.field744 != null) {
                        Player.method1114(Game.field744);
                        Game.field744 = null;
                    }
                }
                else if (int_2 == 28) {
                    final PacketNode packetnode_0 = class26.method433(ClientPacket.SMALL_BUTTON_PRESS, Game.field626.field1218);
                    packetnode_0.packetBuffer.putInt(int_1);
                    Game.field626.method1980(packetnode_0);
                    final Widget widget_2 = Widget.getWidget(int_1);
                    if (widget_2.dynamicValues != null && widget_2.dynamicValues[0][0] == 5) {
                        final int int_6 = widget_2.dynamicValues[0][1];
                        class225.clientVarps[int_6] = 1 - class225.clientVarps[int_6];
                        class45.method749(int_6);
                    }
                }
                else if (int_2 == 29) {
                    final PacketNode packetnode_0 = class26.method433(ClientPacket.SMALL_BUTTON_PRESS, Game.field626.field1218);
                    packetnode_0.packetBuffer.putInt(int_1);
                    Game.field626.method1980(packetnode_0);
                    final Widget widget_2 = Widget.getWidget(int_1);
                    if (widget_2.dynamicValues != null && widget_2.dynamicValues[0][0] == 5) {
                        final int int_6 = widget_2.dynamicValues[0][1];
                        if (class225.clientVarps[int_6] != widget_2.field2720[0]) {
                            class225.clientVarps[int_6] = widget_2.field2720[0];
                            class45.method749(int_6);
                        }
                    }
                }
                else if (int_2 == 30) {
                    if (Game.field744 == null) {
                        Varcs.method1921(int_1, int_0);
                        Player.method1114(Game.field744 = class146.getWidgetChild(int_1, int_0));
                    }
                }
                else if (int_2 == 31) {
                    final PacketNode packetnode_0 = class26.method433(ClientPacket.ITEM_ON_ITEM, Game.field626.field1218);
                    packetnode_0.packetBuffer.addLEInt(class187.field2372);
                    packetnode_0.packetBuffer.addLEShort(int_0);
                    packetnode_0.packetBuffer.addLEShort(class297.field3683);
                    packetnode_0.packetBuffer.addInt2(int_1);
                    packetnode_0.packetBuffer.putShort(class13.selectedItemIndex);
                    packetnode_0.packetBuffer.addLEShort(int_3);
                    Game.field626.method1980(packetnode_0);
                    Game.mouseCrosshair = 0;
                    class240.field3096 = Widget.getWidget(int_1);
                    Game.pressedItemIndex = int_0;
                }
                else if (int_2 == 32) {
                    final PacketNode packetnode_0 = class26.method433(ClientPacket.SPELL_ON_ITEM, Game.field626.field1218);
                    packetnode_0.packetBuffer.addInt1(SoundTaskDataProvider.field361);
                    packetnode_0.packetBuffer.putShort(Game.field736);
                    packetnode_0.packetBuffer.addInt2(int_1);
                    packetnode_0.packetBuffer.addLEShortA(int_0);
                    packetnode_0.packetBuffer.addShortA(int_3);
                    Game.field626.method1980(packetnode_0);
                    Game.mouseCrosshair = 0;
                    class240.field3096 = Widget.getWidget(int_1);
                    Game.pressedItemIndex = int_0;
                }
                else if (int_2 == 33) {
                    final PacketNode packetnode_0 = class26.method433(ClientPacket.FIRST_ITEM_ACTION, Game.field626.field1218);
                    packetnode_0.packetBuffer.addLEShortA(int_0);
                    packetnode_0.packetBuffer.addShortA(int_3);
                    packetnode_0.packetBuffer.putInt(int_1);
                    Game.field626.method1980(packetnode_0);
                    Game.mouseCrosshair = 0;
                    class240.field3096 = Widget.getWidget(int_1);
                    Game.pressedItemIndex = int_0;
                }
                else if (int_2 == 34) {
                    final PacketNode packetnode_0 = class26.method433(ClientPacket.SECOND_ITEM_ACTION, Game.field626.field1218);
                    packetnode_0.packetBuffer.putShort(int_0);
                    packetnode_0.packetBuffer.addLEShort(int_3);
                    packetnode_0.packetBuffer.addLEInt(int_1);
                    Game.field626.method1980(packetnode_0);
                    Game.mouseCrosshair = 0;
                    class240.field3096 = Widget.getWidget(int_1);
                    Game.pressedItemIndex = int_0;
                }
                else if (int_2 == 35) {
                    final PacketNode packetnode_0 = class26.method433(ClientPacket.THIRD_ITEM_ACTION, Game.field626.field1218);
                    packetnode_0.packetBuffer.addLEShort(int_0);
                    packetnode_0.packetBuffer.addInt1(int_1);
                    packetnode_0.packetBuffer.addLEShort(int_3);
                    Game.field626.method1980(packetnode_0);
                    Game.mouseCrosshair = 0;
                    class240.field3096 = Widget.getWidget(int_1);
                    Game.pressedItemIndex = int_0;
                }
                else if (int_2 == 36) {
                    final PacketNode packetnode_0 = class26.method433(ClientPacket.FOURTH_ITEM_ACTION, Game.field626.field1218);
                    packetnode_0.packetBuffer.addLEShortA(int_3);
                    packetnode_0.packetBuffer.addShortA(int_0);
                    packetnode_0.packetBuffer.addInt1(int_1);
                    Game.field626.method1980(packetnode_0);
                    Game.mouseCrosshair = 0;
                    class240.field3096 = Widget.getWidget(int_1);
                    Game.pressedItemIndex = int_0;
                }
                else if (int_2 == 37) {
                    final PacketNode packetnode_0 = class26.method433(ClientPacket.DROP_ITEM, Game.field626.field1218);
                    packetnode_0.packetBuffer.addInt1(int_1);
                    packetnode_0.packetBuffer.addLEShort(int_0);
                    packetnode_0.packetBuffer.addShortA(int_3);
                    Game.field626.method1980(packetnode_0);
                    Game.mouseCrosshair = 0;
                    class240.field3096 = Widget.getWidget(int_1);
                    Game.pressedItemIndex = int_0;
                }
                else {
                    if (int_2 == 38) {
                        class34.method585();
                        final Widget widget_1 = Widget.getWidget(int_1);
                        Game.itemSelectionState = 1;
                        class13.selectedItemIndex = int_0;
                        class187.field2372 = int_1;
                        class297.field3683 = int_3;
                        Player.method1114(widget_1);
                        Game.lastSelectedItemName = class6.getColTags(16748608) + TextureProvider.getItemDefinition(int_3).name + class6.getColTags(16777215);
                        if (Game.lastSelectedItemName == null) {
                            Game.lastSelectedItemName = "null";
                        }
                        return;
                    }
                    if (int_2 == 39) {
                        final PacketNode packetnode_0 = class26.method433(ClientPacket.field2171, Game.field626.field1218);
                        packetnode_0.packetBuffer.addInt2(int_1);
                        packetnode_0.packetBuffer.addShortA(int_3);
                        packetnode_0.packetBuffer.addLEShortA(int_0);
                        Game.field626.method1980(packetnode_0);
                        Game.mouseCrosshair = 0;
                        class240.field3096 = Widget.getWidget(int_1);
                        Game.pressedItemIndex = int_0;
                    }
                    else if (int_2 == 40) {
                        final PacketNode packetnode_0 = class26.method433(ClientPacket.field2151, Game.field626.field1218);
                        packetnode_0.packetBuffer.putInt(int_1);
                        packetnode_0.packetBuffer.addLEShort(int_3);
                        packetnode_0.packetBuffer.addLEShort(int_0);
                        Game.field626.method1980(packetnode_0);
                        Game.mouseCrosshair = 0;
                        class240.field3096 = Widget.getWidget(int_1);
                        Game.pressedItemIndex = int_0;
                    }
                    else if (int_2 == 41) {
                        final PacketNode packetnode_0 = class26.method433(ClientPacket.field2202, Game.field626.field1218);
                        packetnode_0.packetBuffer.addLEShort(int_3);
                        packetnode_0.packetBuffer.addLEShort(int_0);
                        packetnode_0.packetBuffer.addLEInt(int_1);
                        Game.field626.method1980(packetnode_0);
                        Game.mouseCrosshair = 0;
                        class240.field3096 = Widget.getWidget(int_1);
                        Game.pressedItemIndex = int_0;
                    }
                    else if (int_2 == 42) {
                        final PacketNode packetnode_0 = class26.method433(ClientPacket.field2200, Game.field626.field1218);
                        packetnode_0.packetBuffer.addLEShortA(int_3);
                        packetnode_0.packetBuffer.addInt2(int_1);
                        packetnode_0.packetBuffer.putShort(int_0);
                        Game.field626.method1980(packetnode_0);
                        Game.mouseCrosshair = 0;
                        class240.field3096 = Widget.getWidget(int_1);
                        Game.pressedItemIndex = int_0;
                    }
                    else if (int_2 == 43) {
                        final PacketNode packetnode_0 = class26.method433(ClientPacket.field2140, Game.field626.field1218);
                        packetnode_0.packetBuffer.addShortA(int_3);
                        packetnode_0.packetBuffer.putInt(int_1);
                        packetnode_0.packetBuffer.addLEShort(int_0);
                        Game.field626.method1980(packetnode_0);
                        Game.mouseCrosshair = 0;
                        class240.field3096 = Widget.getWidget(int_1);
                        Game.pressedItemIndex = int_0;
                    }
                    else if (int_2 == 44) {
                        final Player player_0 = Game.cachedPlayers[int_3];
                        if (player_0 != null) {
                            Game.lastLeftClickX = int_4;
                            Game.lastLeftClickY = int_5;
                            Game.cursorState = 2;
                            Game.field803 = 0;
                            Game.destinationX = int_0;
                            Game.destinationY = int_1;
                            final PacketNode packetnode_2 = class26.method433(ClientPacket.PLAYER_INTERACT_ONE, Game.field626.field1218);
                            packetnode_2.packetBuffer.putByte(KeyFocusListener.keyPressed[82] ? 1 : 0);
                            packetnode_2.packetBuffer.putShort(int_3);
                            Game.field626.method1980(packetnode_2);
                        }
                    }
                    else if (int_2 == 45) {
                        final Player player_0 = Game.cachedPlayers[int_3];
                        if (player_0 != null) {
                            Game.lastLeftClickX = int_4;
                            Game.lastLeftClickY = int_5;
                            Game.cursorState = 2;
                            Game.field803 = 0;
                            Game.destinationX = int_0;
                            Game.destinationY = int_1;
                            final PacketNode packetnode_2 = class26.method433(ClientPacket.PLAYER_INTERACT_TWO, Game.field626.field1218);
                            packetnode_2.packetBuffer.addByteS(KeyFocusListener.keyPressed[82] ? 1 : 0);
                            packetnode_2.packetBuffer.putShort(int_3);
                            Game.field626.method1980(packetnode_2);
                        }
                    }
                    else if (int_2 == 46) {
                        final Player player_0 = Game.cachedPlayers[int_3];
                        if (player_0 != null) {
                            Game.lastLeftClickX = int_4;
                            Game.lastLeftClickY = int_5;
                            Game.cursorState = 2;
                            Game.field803 = 0;
                            Game.destinationX = int_0;
                            Game.destinationY = int_1;
                            final PacketNode packetnode_2 = class26.method433(ClientPacket.PLAYER_INTERACT_THREE, Game.field626.field1218);
                            packetnode_2.packetBuffer.addByteA(KeyFocusListener.keyPressed[82] ? 1 : 0);
                            packetnode_2.packetBuffer.addShortA(int_3);
                            Game.field626.method1980(packetnode_2);
                        }
                    }
                    else if (int_2 == 47) {
                        final Player player_0 = Game.cachedPlayers[int_3];
                        if (player_0 != null) {
                            Game.lastLeftClickX = int_4;
                            Game.lastLeftClickY = int_5;
                            Game.cursorState = 2;
                            Game.field803 = 0;
                            Game.destinationX = int_0;
                            Game.destinationY = int_1;
                            final PacketNode packetnode_2 = class26.method433(ClientPacket.PLAYER_INTERACT_FOUR, Game.field626.field1218);
                            packetnode_2.packetBuffer.addLEShortA(int_3);
                            packetnode_2.packetBuffer.putByte(KeyFocusListener.keyPressed[82] ? 1 : 0);
                            Game.field626.method1980(packetnode_2);
                        }
                    }
                    else if (int_2 == 48) {
                        final Player player_0 = Game.cachedPlayers[int_3];
                        if (player_0 != null) {
                            Game.lastLeftClickX = int_4;
                            Game.lastLeftClickY = int_5;
                            Game.cursorState = 2;
                            Game.field803 = 0;
                            Game.destinationX = int_0;
                            Game.destinationY = int_1;
                            final PacketNode packetnode_2 = class26.method433(ClientPacket.PLAYER_INTERACT_FIVE, Game.field626.field1218);
                            packetnode_2.packetBuffer.addByteS(KeyFocusListener.keyPressed[82] ? 1 : 0);
                            packetnode_2.packetBuffer.addLEShortA(int_3);
                            Game.field626.method1980(packetnode_2);
                        }
                    }
                    else if (int_2 == 49) {
                        final Player player_0 = Game.cachedPlayers[int_3];
                        if (player_0 != null) {
                            Game.lastLeftClickX = int_4;
                            Game.lastLeftClickY = int_5;
                            Game.cursorState = 2;
                            Game.field803 = 0;
                            Game.destinationX = int_0;
                            Game.destinationY = int_1;
                            final PacketNode packetnode_2 = class26.method433(ClientPacket.PLAYER_INTERACT_SIX, Game.field626.field1218);
                            packetnode_2.packetBuffer.addByteC(KeyFocusListener.keyPressed[82] ? 1 : 0);
                            packetnode_2.packetBuffer.addLEShortA(int_3);
                            Game.field626.method1980(packetnode_2);
                        }
                    }
                    else if (int_2 == 50) {
                        final Player player_0 = Game.cachedPlayers[int_3];
                        if (player_0 != null) {
                            Game.lastLeftClickX = int_4;
                            Game.lastLeftClickY = int_5;
                            Game.cursorState = 2;
                            Game.field803 = 0;
                            Game.destinationX = int_0;
                            Game.destinationY = int_1;
                            final PacketNode packetnode_2 = class26.method433(ClientPacket.PLAYER_INTERACT_SEVEN, Game.field626.field1218);
                            packetnode_2.packetBuffer.addLEShort(int_3);
                            packetnode_2.packetBuffer.addByteA(KeyFocusListener.keyPressed[82] ? 1 : 0);
                            Game.field626.method1980(packetnode_2);
                        }
                    }
                    else if (int_2 == 51) {
                        final Player player_0 = Game.cachedPlayers[int_3];
                        if (player_0 != null) {
                            Game.lastLeftClickX = int_4;
                            Game.lastLeftClickY = int_5;
                            Game.cursorState = 2;
                            Game.field803 = 0;
                            Game.destinationX = int_0;
                            Game.destinationY = int_1;
                            final PacketNode packetnode_2 = class26.method433(ClientPacket.PLAYER_INTERACT_EIGHT, Game.field626.field1218);
                            packetnode_2.packetBuffer.addLEShortA(int_3);
                            packetnode_2.packetBuffer.addByteC(KeyFocusListener.keyPressed[82] ? 1 : 0);
                            Game.field626.method1980(packetnode_2);
                        }
                    }
                    else {
                        if (int_2 != 57) {
                            if (int_2 == 58) {
                                final Widget widget_1 = class146.getWidgetChild(int_1, int_0);
                                if (widget_1 != null) {
                                    final PacketNode packetnode_2 = class26.method433(ClientPacket.field2159, Game.field626.field1218);
                                    packetnode_2.packetBuffer.addInt1(SoundTaskDataProvider.field361);
                                    packetnode_2.packetBuffer.addLEShortA(Game.field737);
                                    packetnode_2.packetBuffer.addInt1(int_1);
                                    packetnode_2.packetBuffer.addLEShort(widget_1.itemId);
                                    packetnode_2.packetBuffer.putShort(int_0);
                                    packetnode_2.packetBuffer.putShort(Game.field736);
                                    Game.field626.method1980(packetnode_2);
                                }
                                break Label_5682;
                            }
                            else {
                                if (int_2 == 1001) {
                                    Game.lastLeftClickX = int_4;
                                    Game.lastLeftClickY = int_5;
                                    Game.cursorState = 2;
                                    Game.field803 = 0;
                                    Game.destinationX = int_0;
                                    Game.destinationY = int_1;
                                    final PacketNode packetnode_0 = class26.method433(ClientPacket.OBJECT_ACTION_FIVE, Game.field626.field1218);
                                    packetnode_0.packetBuffer.addLEShort(Game.baseY + int_1);
                                    packetnode_0.packetBuffer.addLEShortA(int_3);
                                    packetnode_0.packetBuffer.addShortA(int_0 + PendingSpawn.baseX);
                                    packetnode_0.packetBuffer.putByte(KeyFocusListener.keyPressed[82] ? 1 : 0);
                                    Game.field626.method1980(packetnode_0);
                                    break Label_5682;
                                }
                                if (int_2 == 1002) {
                                    Game.lastLeftClickX = int_4;
                                    Game.lastLeftClickY = int_5;
                                    Game.cursorState = 2;
                                    Game.field803 = 0;
                                    final PacketNode packetnode_0 = class26.method433(ClientPacket.EXAMINE_OBJECT, Game.field626.field1218);
                                    packetnode_0.packetBuffer.putShort(int_3);
                                    Game.field626.method1980(packetnode_0);
                                    break Label_5682;
                                }
                                if (int_2 == 1003) {
                                    Game.lastLeftClickX = int_4;
                                    Game.lastLeftClickY = int_5;
                                    Game.cursorState = 2;
                                    Game.field803 = 0;
                                    final NPC npc_0 = Game.cachedNPCs[int_3];
                                    if (npc_0 != null) {
                                        NPCComposition npccomposition_0 = npc_0.composition;
                                        if (npccomposition_0.configs != null) {
                                            npccomposition_0 = npccomposition_0.transform();
                                        }
                                        if (npccomposition_0 != null) {
                                            final PacketNode packetnode_3 = class26.method433(ClientPacket.EXAMINE_NPC, Game.field626.field1218);
                                            packetnode_3.packetBuffer.addLEShort(npccomposition_0.id);
                                            Game.field626.method1980(packetnode_3);
                                        }
                                    }
                                    break Label_5682;
                                }
                                else {
                                    if (int_2 == 1004) {
                                        Game.lastLeftClickX = int_4;
                                        Game.lastLeftClickY = int_5;
                                        Game.cursorState = 2;
                                        Game.field803 = 0;
                                        final PacketNode packetnode_0 = class26.method433(ClientPacket.EXAMINE_ITEM, Game.field626.field1218);
                                        packetnode_0.packetBuffer.addShortA(int_3);
                                        Game.field626.method1980(packetnode_0);
                                        break Label_5682;
                                    }
                                    if (int_2 == 1005) {
                                        final Widget widget_1 = Widget.getWidget(int_1);
                                        if (widget_1 != null && widget_1.itemQuantities[int_0] >= 100000) {
                                            class143.sendGameMessage(27, "", widget_1.itemQuantities[int_0] + " x " + TextureProvider.getItemDefinition(int_3).name);
                                        }
                                        else {
                                            final PacketNode packetnode_2 = class26.method433(ClientPacket.EXAMINE_ITEM, Game.field626.field1218);
                                            packetnode_2.packetBuffer.addShortA(int_3);
                                            Game.field626.method1980(packetnode_2);
                                        }
                                        Game.mouseCrosshair = 0;
                                        class240.field3096 = Widget.getWidget(int_1);
                                        Game.pressedItemIndex = int_0;
                                        break Label_5682;
                                    }
                                    if (int_2 != 1007) {
                                        if (int_2 == 1009 || int_2 == 1011 || int_2 == 1008 || int_2 == 1010 || int_2 == 1012) {
                                            ItemContainer.renderOverview.onMapClicked(int_2, int_3, new Coordinates(int_0), new Coordinates(int_1));
                                        }
                                        break Label_5682;
                                    }
                                }
                            }
                        }
                        final Widget widget_1 = class146.getWidgetChild(int_1, int_0);
                        if (widget_1 != null) {
                            class45.method747(int_3, int_1, int_0, widget_1.itemId, string_1);
                        }
                    }
                }
            }
        }
        if (Game.itemSelectionState != 0) {
            Game.itemSelectionState = 0;
            Player.method1114(Widget.getWidget(class187.field2372));
        }
        if (Game.spellSelected) {
            class34.method585();
        }
        if (class240.field3096 != null && Game.mouseCrosshair == 0) {
            Player.method1114(class240.field3096);
        }
    }
    
    static {
        KeyFocusListener.keyboard = new KeyFocusListener();
        KeyFocusListener.keyPressed = new boolean[112];
        KeyFocusListener.field343 = new int[128];
        KeyFocusListener.field344 = 0;
        KeyFocusListener.field329 = 0;
        KeyFocusListener.field346 = new char[128];
        KeyFocusListener.field348 = new int[128];
        KeyFocusListener.field338 = new int[128];
        KeyFocusListener.field349 = 0;
        KeyFocusListener.field350 = 0;
        KeyFocusListener.field351 = 0;
        KeyFocusListener.field352 = 0;
        KeyFocusListener.keyboardIdleTicks = 0;
        KeyFocusListener.KeyHandler_keyCodes = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    }
}
