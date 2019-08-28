
public class CombatBot implements Runnable{

	private static Player p;
	private int attackId;
	private int distance;
	private NPC closest_npc;
	private int closest_npc_id;
	public static boolean active = true;
	
	public CombatBot(int attackId){
		this.attackId = attackId;
		this.distance = 1000000000;
		this.p = Game.cachedPlayers[InformationBot.myPlayerId];
	}
	
	public void run() {
		while(active){
			if(this.p.interacting == -1){
				this.p.overhead = "Searching for mob";
				
				for(int i = 0; i < Game.cachedNPCs.length; i++){
					try{
						NPC npc = Game.cachedNPCs[i];
						NPCComposition npc_comp = npc.composition;
						
						int npc_dist = InformationBot.getDistance(p, npc);
						
						if(this.distance > npc_dist){
							this.distance = npc_dist;
							this.closest_npc = npc;
							this.closest_npc_id = i;
						}
						
					}catch(NullPointerException e){}
				}
				
				this.p.overhead = "Attacking mob";
				this.p.interacting = this.closest_npc_id;
				this.closest_npc.overhead = "<col=ff0000>Target";
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		
		this.p.interacting = -1;
		active = true;
	}
	
	public static void terminate(){
		active = false;
		p.overhead = "";
	}

}
