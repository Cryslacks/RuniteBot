
public class ItemBot implements Runnable{

	@Override
	public void run() {
		while(true){
			for(int x = 0; x < 104; x++){
				for(int y = 0; y < 104; y++){
					try{
						Deque node = Game.groundItemDeque[class13.plane][x][y];
						if(node != null){
							for(Item item = (Item)node.getFront(); item != null; item = (Item)node.getNext()){
								if(TextureProvider.getItemDefinition(item.id).name.equals("Bones")){
									System.out.println(TextureProvider.getItemDefinition(item.id).name+"("+item.quantity+") <"+x+", "+y+">");
									Actor.font_p12full.method5524("BONES SPOTTED!!!", 5, 5, 5, 5);
									//InvType.groundItemSpawned(x, y);
								}
								//if(item.id != 1973)
								//	System.out.println(TextureProvider.getItemDefinition(item.id).name+"("+item.quantity+") <"+x+", "+y+">");
							}
						}
					}catch(NullPointerException e){
						System.out.println("NullPtr: "+class13.plane+", "+x+", "+y);
					}

				}
			}
			//System.out.println("sleeping");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
