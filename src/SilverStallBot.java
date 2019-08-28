import java.sql.Date;
import java.text.SimpleDateFormat;

public class SilverStallBot implements Runnable{
	private boolean safeToSteal = true, talkingToGuard = false;
	private int guardId = 0;
	public static boolean active = false;
	private static RendererBot rb;
	private long time;
	
	public SilverStallBot(){
		active = true;
		this.time = System.currentTimeMillis();
		this.rb = new RendererBot("Starting up SilverStallBot!");
		new Thread(this.rb).start();
	}
	
	@Override
	public void run() {
		while(active){
			this.checkGuard();
			if(this.safeToSteal){
				steal();
				if(Game.field744 == null)
					this.dropAllSilverOres();
			}else{
				this.interactGuard();
			}
			try { Thread.sleep((int)(Math.random()*(200-100+1))+100); } catch (InterruptedException e) {}
		}
	}
	
	private void steal(){
		InformationBot.getLocal().overhead = "Looking for stall";
		Deque pendingSpawns = Game.pendingSpawns;
		boolean found = false;
		for (PendingSpawn spawn = (PendingSpawn)pendingSpawns.getFront(); spawn != null; spawn = (PendingSpawn)pendingSpawns.getNext()) {
			if(spawn.x == 56 && spawn.y == 50){
				found = true;
			}
		}
		
		if(!found){
			InformationBot.getLocal().overhead = "Stealing from stall";
			int sleep = (int)(Math.random()*(200-10+1))+10;
			try { Thread.sleep(sleep); } catch (InterruptedException e) {}
			KeyFocusListener.menuAction(56, 50, 4, 6164, "Steal-from", "<col=ffff>Silver stall", 417, 275);
			try { Thread.sleep(500); } catch (InterruptedException e) {}
		}
	}
	
	private void dropAllSilverOres(){
		InformationBot.getLocal().overhead = "Inventory full, dropping ores";
		KeyFocusListener.menuAction(-1, 15007746, 30, 0, "Continue", "", 313, 256);
		try { Thread.sleep(300); } catch (InterruptedException e) {}
		for(int i = 0; i < 28; i++)
			KeyFocusListener.menuAction(i, 9764864, 37, 442, "Drop", "Drop", 417, 275);
	}
	
	private void checkGuard(){
		this.safeToSteal = true;
		NPCDefinition[] npcs = InformationBot.getAllNpcs();
		
		if(npcs[0] == null)
			return;
		
		for(int i = 0; i < npcs[0].listLength; i++){
			try{
				if(npcs[i].info.id == 380){
					InformationBot.getLocal().overhead = "<col=ff0000>Found guard!";
					InformationBot.addChatMsg(""+npcs[i].npc.interacting);
					this.guardId = npcs[i].listPos;
					this.safeToSteal = false;
				}
			}catch(NullPointerException e){}
		}
	}

	private void interactGuard(){

/*<MenuAction> Args: 0, 0, 9, 8376, Talk-to, <col=ffff00>Pillory Guard (id=380), 345, 267
<MenuAction> Args: -1, 15138819, 30, 0, Continue, , 270, 448
<MenuAction> Args: -1, 14221315, 30, 0, Continue, , 270, 448
<MenuAction> Args: -1, 15138819, 30, 0, Continue, , 270, 448
<addMessage> Args: 0, , <col=0040ff>The guard hands you 15,066 gold coins for the trouble.</col>, null*/
		
		if(Game.field744 != null && !talkingToGuard){
			InformationBot.getLocal().overhead = "Talking to guard";
			KeyFocusListener.menuAction(0, 0, 9, this.guardId, "Talk-to", "<col=ffff00>Pillory Guard (id=380)", 345, 267);
			talkingToGuard = true;
		}else{
			InformationBot.getLocal().overhead = "Getting rid of guard";
			try { Thread.sleep(2000); } catch (InterruptedException e) {}
			KeyFocusListener.menuAction(-1, 15138819, 30, 0, "Continue", "", 313, 256);
			try { Thread.sleep(2000); } catch (InterruptedException e) {}
			KeyFocusListener.menuAction(-1, 14221315, 30, 0, "Continue", "", 313, 256);
			try { Thread.sleep(2000); } catch (InterruptedException e) {}
			KeyFocusListener.menuAction(-1, 15138819, 30, 0, "Continue", "", 313, 256);

			talkingToGuard = false;
			//Args: -1, 15138819, 30, 0, Continue, , 346, 963
			//Args: -1, 14221315, 30, 0, Continue, , 312, 964
			//Args: -1, 15138819, 30, 0, Continue, , 279, 966
		}
	}
	
	public static void terminate(){
		active = false;
		rb.terminate();
	}
}
