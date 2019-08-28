
public class ItemDefinition {
	public Item item;
	public String name;
	public int quantity;
	public int id;
	public ItemComposition info;
	public int x, y, plane;
	public int listLength;
	
	public ItemDefinition(Item item, int plane, int x, int y) {
		this.item = item;
		this.plane = plane;
		this.x = x;
		this.y = y;
		this.info = TextureProvider.getItemDefinition(item.id);
		this.name = this.info.name;
		this.quantity = this.item.quantity;
		this.id = this.item.id;
		if(!this.info.name.endsWith("(id="+this.id+")"))
			this.info.name += " (id="+this.id+")";
	}
}
