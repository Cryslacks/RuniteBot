import java.awt.Color;
import java.awt.Graphics;

// 
// Decompiled by Procyon v0.5.36
// 

public class ChatLineBuffer
{
	final Graphics g = GameEngine.canvas.getGraphics();
    public static int field1212;
    MessageNode[] lines;
    int length;
	private Player player;
    
    ChatLineBuffer() {
        this.lines = new MessageNode[100];
		this.player = Game.cachedPlayers[Game.myPlayerIndex];
    }
    
    public MessageNode addMessage(int chatId, final String username, final String msg, final String string_2) {
    	if(chatId == 14)
    		chatId = 0;
    	
    	System.out.println("<addMessage> Args: "+chatId+", "+username+", "+msg+", "+string_2);
    	if(msg.equals("Sorry, that command does not exist."))
    		return addMessage(chatId, username, "", string_2);
    	
    	if(msg.startsWith("<col=cc0000>::")){
    		String[] cmdArgs = msg.split("::")[1].split(" "); // ex "::fov 10 60 30" => ["fov", "10", "60", "30"]
    		System.out.println("COMMAND USED: "+cmdArgs[0]);
    		if(cmdArgs.length > 1)
    			System.out.println("COMMAND ARGS "+cmdArgs[0]+", "+cmdArgs[1]);
    		if(cmdArgs[0].equals("npctext")){
    			if(cmdArgs.length > 1){
    				InformationBot.npcTextOverHeadMode(Integer.parseInt(cmdArgs[1]));
    				return addMessage(105, "", "<col=FF0000>[Bot]<col=000000> Changed <col=FFFF00>npcText_mode<col=000000> to "+InformationBot.npcTextMode, null);
    			}else{
    				InformationBot.npcTextOverHead(!InformationBot.npcTextEnable);
    				String color = InformationBot.npcTextEnable ? "<col=00aa00>" : "<col=aa0000>";
    				return addMessage(105, "", "<col=FF0000>[Bot]<col=000000> Changed <col=FFFF00>npcText<col=000000> to "+color+""+InformationBot.npcTextEnable, null);
    			}
    		}else if(cmdArgs[0].equals("playertext")){
    			if(cmdArgs.length > 1){
    				InformationBot.playerTextOverHeadMode(Integer.parseInt(cmdArgs[1]));
    				return addMessage(105, "", "<col=FF0000>[Bot]<col=000000> Changed <col=FFFF00>playerText_mode<col=000000> to "+InformationBot.playerTextMode, null);
    			}else{
    				InformationBot.playerTextOverHead(!InformationBot.playerTextEnable);
    				String color = InformationBot.playerTextEnable ? "<col=00aa00>" : "<col=aa0000>";
    				return addMessage(105, "", "<col=FF0000>[Bot]<col=000000> Changed <col=FFFF00>playerText<col=000000> to "+color+""+InformationBot.playerTextEnable, null);
    			}
    		}else if(cmdArgs[0].equals("kill")){
    			new Thread(new CombatBot(Integer.parseInt(cmdArgs[1]))).start();
    			return addMessage(105, "", "<col=FF0000>[Bot]<col=000000> Starting to kill npcs with id "+cmdArgs[1], null);
    		}else if(cmdArgs[0].equals("stopkill")){
    			CombatBot.terminate();
    			return addMessage(105, "", "<col=FF0000>[Bot]<col=000000> Stopped killing mobs", null);
    		}else if(msg.split("::")[1].equals("items")) {
    			ItemDefinition[] items = InformationBot.getAllGroundItems();
    			if(items[0] == null)
    				return addMessage(chatId, username, "<col=ff0000>[Bot]</col> No items on the ground!", string_2);
    			else 
    				InformationBot.addChatMsg("Items on the ground: ");
    			
    			for(int i = 0; items[i] != null; i++) {
    				String gActions = "[";
    				for(int c = 0; c < 5; c++)
    					gActions += items[i].info.groundActions[c]+", ";
    				gActions = gActions.substring(0, gActions.length()-2)+"]";

    				String iActions = "[";
    				for(int c = 0; c < 5; c++)
    					iActions += items[i].info.inventoryActions[c]+", ";
    				iActions = iActions.substring(0, iActions.length()-2)+"]";
    				
					InformationBot.addChatMsg("["+items[i].x+", "+items[i].y+"] "+items[i].name+(items[i].quantity > 1 ? " x"+items[i].quantity+" " : " ")+gActions+" "+iActions, false);
    			}
       		}else if(msg.split("::")[1].equals("npcs")) {
    			NPCDefinition[] npcs = InformationBot.getAllNpcs();
    			if(npcs[0] == null)
    				return addMessage(chatId, username, "<col=ff0000>[Bot]</col> No npcs close!", string_2);
    			else 
    				InformationBot.addChatMsg("Npcs close to you: ");
    			
    			for(int i = 0; npcs[i] != null; i++) {
    				String iActions = "[";
    				for(int c = 0; c < 3; c++)
    					iActions += npcs[i].info.actions[c]+", ";
    				iActions = iActions.substring(0, iActions.length()-2)+"]";
    				
					InformationBot.addChatMsg("["+npcs[i].npc.x+", "+npcs[i].npc.y+"] "+npcs[i].info.name+(npcs[i].info.combatLevel > 1 ? " ("+npcs[i].info.combatLevel+") " : " ")+iActions, false);
    			}
       		}else if(msg.split("::")[1].equals("players")) {
    			Player[] players = InformationBot.getAllPlayers();
    			if(players[0] == null)
    				return addMessage(chatId, username, "<col=ff0000>[Bot]</col> No players close!", string_2);
    			else 
    				InformationBot.addChatMsg("Players close to you: ");
    			
    			for(int i = 0; players[i] != null; i++) {
    				String iActions = "[";
    				for(int c = 0; c < 3; c++)
    					iActions += players[i].actions[c]+", ";
    				iActions = iActions.substring(0, iActions.length()-2)+"]";
    				
					InformationBot.addChatMsg("["+players[i].x+", "+players[i].y+"] "+players[i].name+" "+players[i].combatLevel+" "+iActions, false);
    			}
       		}else if(msg.split("::")[1].equals("h")){
       			InformationBot.teleportHome();
       		}else if(cmdArgs[0].equals("w")){
       			int x = Integer.parseInt(cmdArgs[1]);
       			int y = Integer.parseInt(cmdArgs[2]);
       			
       			InformationBot.addChatMsg("Walking to: ["+Region.selectedRegionTileX+","+Region.selectedRegionTileY+"]");
       			
       			InformationBot.walkToPos(x, y);
       		}
    		
			return addMessage(chatId, username, "", string_2);
    	}
    	
        MessageNode messagenode_0 = this.lines[99];
        for (int int_ = this.length; int_ > 0; --int_) {
            if (int_ != 100) {
                this.lines[int_] = this.lines[int_ - 1];
            }
        }
        if (messagenode_0 == null) {
            messagenode_0 = new MessageNode(chatId, username, string_2, msg);
        }
        else {
            messagenode_0.unlink();
            messagenode_0.unlinkDual();
            messagenode_0.setMessage(chatId, username, string_2, msg);
        }
        this.lines[0] = messagenode_0;
        if (this.length < 100) {
            ++this.length;
        }
        return messagenode_0;
    }
    
    MessageNode getMessage(final int int_0) {
        return (int_0 >= 0 && int_0 < this.length) ? this.lines[int_0] : null;
    }
    
    int size() {
        return this.length;
    }
    
    public static int method1970(final int int_0, final int int_1, int int_2, int int_3, int int_4, final int int_5) {
        if ((int_5 & 0x1) == 0x1) {
            final int int_6 = int_3;
            int_3 = int_4;
            int_4 = int_6;
        }
        int_2 &= 0x3;
        return (int_2 == 0) ? int_1 : ((int_2 == 1) ? (7 - int_0 - (int_3 - 1)) : ((int_2 == 2) ? (7 - int_1 - (int_4 - 1)) : int_0));
    }
}
