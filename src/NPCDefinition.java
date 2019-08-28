
public class NPCDefinition {
	public NPC npc;
	public String name;
	public int id;
	public NPCComposition info;
	public int listPos;
	public int listLength;
	
	public NPCDefinition(NPC npc, int pos) {
		this.npc = npc;
		this.listPos = pos;
		this.info = npc.composition;
		this.name = this.info.name;
		this.id = this.info.id;
		if(!this.info.name.endsWith("(id="+this.id+")"))
			this.info.name += " (id="+this.id+")";
	}
}
