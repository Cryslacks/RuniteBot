import java.util.ArrayList;
import java.util.Objects;

public class InformationBot implements Runnable{
	public static boolean playerTextEnable = false;
	private static boolean playerTextReset = false;
	public static int playerTextMode = 0;
	public static boolean npcTextEnable = false;
	private static boolean npcTextReset = false;
	public static int npcTextMode = 0;
	public int x = 0,y = 0;
	public static NPCComposition[] npcs;
	public static boolean active = true;
	public static int current_x = 0, current_y = 0;
	public static Game game;
	public static int myPlayerId = 0;
	public static boolean itemStatus = true;
	private ItemDefinition[] lastItems = null;
	private int printStatus = 0;
	private PendingSpawn[] alreadyPosted;
	int g = 0;
	
	public InformationBot(Game game) {
		this.game = game;
		alreadyPosted = new PendingSpawn[10000];
		//new Thread(new MenuBot()).start();
	}

	public void run() {
		while(this.active){
			if(this.myPlayerId == 0){
				for(int i = 0; i < this.game.cachedPlayers.length; i++){
					try{
						Player player = this.game.cachedPlayers[i];
						if(player.getName(false).equals("Cryslacks") || player.getName(false).equals("Thiever")){
							System.out.println("PlayerId = "+i);
							this.myPlayerId = i;
							break;
						}
					}catch(NullPointerException e){}
				}
			}
			/*
			Deque pendingSpawns = Game.pendingSpawns;
			boolean found = false;
			for (PendingSpawn spawn = (PendingSpawn)pendingSpawns.getFront(); spawn != null; spawn = (PendingSpawn)pendingSpawns.getNext()) {
				found = false;
				for(int i = 0; this.alreadyPosted[i] != null; i++){
					if(comparePendingSpawn(this.alreadyPosted[i], spawn)){
						found = true;
						break;
					}
				}
				
				if(!found){
					InformationBot.addChatMsg("Pending spawn: "+spawn.type+","+FileOnDisk.getObjectDefinition(spawn.id).name+" ["+spawn.x+","+spawn.y+"]");
					this.alreadyPosted[g] = spawn;
					g++;
	                if(pendingSpawns == null || pendingSpawns.getNext() == null)
	                	break;
				}
            }
			
			if(pendingSpawns.getFront() == null){
				this.alreadyPosted = new PendingSpawn[10000];
				g = 0;
			}
			
			*/
			if(this.npcTextEnable){
				NPCDefinition[] npcs = getAllNpcs();
				if(npcs[0] != null){
					for(int i = 0; i < npcs[0].listLength; i++){
						NPC npc = npcs[i].npc;
						NPCComposition npc_comp = npc.composition;
						try{
							switch(this.npcTextMode){
								case 0:
									if(npc_comp.combatLevel == 0)
										npc.overhead = "["+npc_comp.id+","+npcs[i].listPos+"] "+npc_comp.name;
									else
										npc.overhead = "<col=ff0000>["+npc_comp.id+","+npcs[i].listPos+"] "+npc_comp.name+" ("+npc_comp.combatLevel+")";
									break;
								case 1:
									npc.overhead = "("+npc_comp.actions[0]+", "+npc_comp.actions[1]+", "+npc_comp.actions[2]+", "+npc_comp.actions[3]+")";
									break;
								case 2:
									npc.overhead = "<col=CA6600>["+npc.x+", "+npc.y+"]";
									break;
								case 3:
									npc.overhead = "Distance: "+getDistance(Game.cachedPlayers[this.myPlayerId], npc);
									break;
								case 4:
									npc.overhead = "<col=FF00FF>Jag älskar dig Natha <3";
									break;
							}
						}catch(NullPointerException e){
							System.out.println("error "+i);
						}
					}
				}
			}
			
			/*
			for(int i = 0; i < this.game.cachedNPCs.length; i++){
				try{ // 380 Pillory guard https://i.imgur.com/CjDsaAf.png https://i.imgur.com/kGoPCU4.png
					NPC npc = this.game.cachedNPCs[i];
					NPCComposition npc_comp = npc.composition;
					if(this.npcTextEnable){
						switch(this.npcTextMode){
							case 0:
								if(npc_comp.combatLevel == 0)
									npc.overhead = "["+npc_comp.id+"] "+npc_comp.name;
								else
									npc.overhead = "<col=ff0000>["+npc_comp.id+"] "+npc_comp.name+" ("+npc_comp.combatLevel+")";
								break;
							case 1:
								npc.overhead = "("+npc_comp.actions[0]+", "+npc_comp.actions[1]+", "+npc_comp.actions[2]+", "+npc_comp.actions[3]+")";
								break;
							case 2:
								npc.overhead = "<col=CA6600>["+npc.x+", "+npc.y+"]";
								break;
							case 3:
								npc.overhead = "<col=FF00FF>Jag älskar dig Natha <3";
								break;
						}
					}
				}catch(NullPointerException e){}
			}
			
			if(!this.npcTextEnable && this.npcTextReset){
				for(int i = 0; i < this.game.cachedNPCs.length; i++){
					try{
						NPC npc = this.game.cachedNPCs[i];
						npc.overhead = "";
					}catch(NullPointerException e){}
				}
				this.npcTextReset = false;
			}

			if(this.myPlayerId == 0){
				for(int i = 0; i < this.game.cachedPlayers.length; i++){
					try{
						Player player = this.game.cachedPlayers[i];
						if(player.getName(false).equals("Cryslacks")){
							System.out.println("PlayerId = "+i);
							this.myPlayerId = i;
							break;
						}
					}catch(NullPointerException e){}
				}
			}
			
			try{
				if(this.playerTextEnable){
					Player player = this.game.cachedPlayers[this.myPlayerId];
					switch(this.playerTextMode){
						case 0:
							player.overhead = "["+this.myPlayerId+"] "+player.name+" ("+player.combatLevel+")";
							break;
						case 1:
							player.overhead = "<col=CA6600>["+player.x+", "+player.y+", "+player.logicalHeight+"]";
							break;
						case 2:
							player.overhead = player.angle+", "+player.orientation+", "+player.field556+", "+player.field557+", "+player.field558+", "+player.field559+", "+player.field562+", "+player.field565+", "+player.field567+", "+player.field572+", "+player.field573+", "+player.field2428;
							//player.orientation = 1536;
							/*
							 * Orientation:
							 * SOUTH: 	0
							 * WEST:	512
							 * NORTH:	1024
							 * EAST:	1536
							 * 
							 * Interacting: npc_id
							 *//*
							break;
						case 3:
							if(player.interacting != -1){
								NPC npc = this.game.cachedNPCs[player.interacting];
								player.overhead = "Killing "+npc.composition.name+" ("+npc.composition.combatLevel+")";
								npc.overhead 	= "<col=ff0000>Target";
							}else
								player.overhead = "Idle";
							break;
						case 4:
							player.overhead = "<col=FF00FF>Jag älskar dig Natha <3";
							break;
						}
				}
			}catch(NullPointerException e){}*/
			/*
			if(!this.playerTextEnable && this.playerTextReset){
				try{
					Player player = this.game.cachedPlayers[this.myPlayerId];
					player.overhead = "";
				}catch(NullPointerException e){}
				
				this.playerTextReset = false;
			}*/
			if(itemStatus) {
				ItemDefinition[] items = InformationBot.getAllGroundItems();
				if(items[0] != null) {
					if(this.lastItems[0] != null) {
						if(this.lastItems[0].listLength > items[0].listLength)
							this.lastItems = items;
						else if(this.lastItems[0].listLength == items[0].listLength){
						}else {
							InformationBot.addChatMsg("Items dropped: ");
							boolean oldItem = false;
							for(int i = 0; items[i] != null; i++) {
								oldItem = false;
								for(int c = 0; lastItems[c] != null; c++) {
									if(compareItems(items[i], lastItems[c])) {
										System.out.println("Item is equal, wont print this one ("+items[i].name+")");
										lastItems[c] = new ItemDefinition(new Item(), 0, 0, 0);
										oldItem = true;
										break;
									}
								}
								
								if(!oldItem)
									InformationBot.addChatMsg("["+items[i].x+", "+items[i].y+"] "+items[i].name+(items[i].quantity > 1 ? " x"+items[i].quantity+" " : " ")+items[i].info.team, false);
							}
							this.lastItems = items;
						}
					}else {
						this.lastItems = items;
						InformationBot.addChatMsg("Items dropped: ");
						for(int i = 0; items[i] != null; i++) {
							InformationBot.addChatMsg("["+items[i].x+", "+items[i].y+"] "+items[i].name+(items[i].quantity > 1 ? " x"+items[i].quantity : ""), false);
						}
					}
				}else {
					this.lastItems = items;
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean compareItems(ItemDefinition a, ItemDefinition b){
		// Id checking
		if(a.id != b.id)
			return false;

		// Position checking
		if(a.x != b.x)
			return false;
		if(a.y != b.y)
			return false;
		if(a.plane != b.plane)
			return false;
		
		// Quantity checking
		if(a.quantity != b.quantity)
			return false;
		
		return true;
	}
	
	public static boolean comparePendingSpawn(PendingSpawn a, PendingSpawn b){
		// Id checking
		if(a.id != b.id)
			return false;
		// Position checking
		if(a.x != b.x || a.y != b.y)
			return false;
		if(a.hash != b.hash){
			return false;
		}
		
		return true;
	}
	
	public static void turnOff(){
		active = false;
	}
	
	public static void npcTextOverHead(boolean status){
		npcTextReset = !status;
		npcTextEnable = status;
	}
	
	public static void npcTextOverHeadMode(int mode) {
		npcTextMode = mode;
	}
	
	public static void playerTextOverHead(boolean status){
		playerTextReset = !status;
		playerTextEnable = status;
	}
	
	public static void playerTextOverHeadMode(int mode) {
		playerTextMode = mode;
	}
	
	public static String getCoords(){
		return current_x+", "+current_y;
	}
	
	public static int getDistance(Player p, NPC n){
		int d = 0;
		
		if(p.x > n.x && p.y > n.y){
			d = (int)Math.sqrt(Math.pow(p.x-n.x, 2)+Math.pow(p.y-n.y, 2));
		}else if(p.x > n.x && p.y < n.y){
			d = (int)Math.sqrt(Math.pow(p.x-n.x, 2)+Math.pow(n.y-p.y, 2));
		}else if(p.x < n.x && p.y > n.y){
			d = (int)Math.sqrt(Math.pow(n.x-p.x, 2)+Math.pow(p.y-n.y, 2));
		}else if(p.x < n.x && p.y < n.y){
			d = (int)Math.sqrt(Math.pow(n.x-p.x, 2)+Math.pow(n.y-p.y, 2));
		}else if(p.x == n.x){
			d = (p.y > n.y ? Math.abs(p.y-n.y) : Math.abs(n.y-p.y));
		}else if(p.y == n.y){
			d = (p.x > n.x ? Math.abs(p.x-n.x) : Math.abs(n.x-p.x));
		}
		
		return d;
	}
	
	public static void addChatMsg(String msg) {
		addChatMsg(msg, true);
	}
	
	public static void addChatMsg(String msg, boolean botmsg) {
		if(botmsg)
			class173.addChatMessage(0, "", "<col=ff0000>[Bot]</col> "+msg, "");
		else
			class173.addChatMessage(0, "", msg, "");
	}
	
	public static NPCDefinition[] getAllNpcs() {
		NPCDefinition[] npcs = new NPCDefinition[10000];
		NPC[] npcList = Game.cachedNPCs.clone();
		int c = 0;
		
		for(int i = 0; i < npcList.length; i++) {
			try {
				if(npcList[i] != null) {
					npcs[c] = new NPCDefinition(npcList[i], i);
					c++;
					//npcs[c].composition.actions[2] = "Start killing bot";
					if(!npcList[c].composition.name.endsWith(")"))
						npcList[c].composition.name += " (id="+i+")";
				}
			}catch(NullPointerException e) {}
		}

		if(npcs[0] != null)
			npcs[0].listLength = c;
		
		return npcs;
	}
	
	public static Player[] getAllPlayers() {
		Player[] players = new Player[100];
		Player[] playerList = Game.cachedPlayers.clone();
		int c = 0;
		for(int i = 0; i < playerList.length; i++) {
			try {
				if(playerList[i] != null) {
					players[c] = playerList[i];
					c++;
				}
			}catch(NullPointerException e) {}
		}
		
		return players;
	}
	
	public static ItemDefinition[] getAllGroundItems() {
		ItemDefinition[] items = new ItemDefinition[100];
		Deque[][][] groundItems = Game.groundItemDeque.clone();
		int i = 0;
		for(int x = 0; x < 104; x++) {
			for(int y = 0; y < 104; y++) {
				Deque deq = groundItems[class13.plane][x][y];
				
				if(deq != null && deq.getFront() != null) {
					for(Item item = (Item)deq.getFront(); item != null; item = (Item)deq.getNext()) {
						items[i] = new ItemDefinition(item, class13.plane, x, y);
						i++;
					}
				}
			}
		}
		if(items[0] != null)
			items[0].listLength = i;
		return items;
	}
	
	
	public static void objectSecondUse(int objectId){
		//<MenuAction> Args: 56, 50, 4, 6164, 417, Steal-from, <col=ffff>Silver stall, 417, 275
		KeyFocusListener.menuAction(56, 50, 4, 6164, "Steal-from", "<col=ffff>Silver stall", 417, 275);
	}
	
	public static void teleportHome(){
		KeyFocusListener.menuAction(-1, 14286852, 57, 1, "", "", 0, 0);
	}
	
	public static void textBoxContinue(){
		//-1, 12648451, 30, 0, 329, Continue, , 329, 443
		KeyFocusListener.menuAction(-1, 12648451, 30, 0, "", "", 0, 0);
	}
	
	public static void walkToPos(int x, int y){
        Game.destinationX = x;
        Game.destinationY = y;
	}
	
	public static Player getLocal(){
		return Game.cachedPlayers[myPlayerId];
	}
}
