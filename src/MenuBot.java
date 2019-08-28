
public class MenuBot implements Runnable{

	private int scene_draw_x, scene_draw_y;
	
	@Override
	public void run() {
		int lastbtn = 0;
		while(true){
			if(Game.gameState < 30){
				System.out.println("Sleeping");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				/*FontTypeFace fonttypeface_0 = (FontTypeFace)Game.fontsMap.get(FontName.FontName_bold12);
				fonttypeface_0.drawTextCentered("Röv", 10+50, 20+10, 0xFF0000, 0);
				*/
				
				if(System.currentTimeMillis()-MouseInput.mouseLastPressedTimeMillis < 400){
					if(MouseInput.mouseLastButton != 0)
						lastbtn = MouseInput.mouseLastButton;
					int color = 0xCAA600;
					if(lastbtn == 1){
						color = 0xFF0000;
					}else if(lastbtn == 2){
						color = 0x00FF00;
					}

					Rasterizer2D.drawLine(MouseInput.mouseX-5, MouseInput.mouseY-5, MouseInput.mouseX+5, MouseInput.mouseY+5, color);
					Rasterizer2D.drawLine(MouseInput.mouseX+5, MouseInput.mouseY-5, MouseInput.mouseX-5, MouseInput.mouseY+5, color);
				}else{
					int color = 0xCAA600;
					Rasterizer2D.drawLine(MouseInput.mouseX-5, MouseInput.mouseY-5, MouseInput.mouseX+5, MouseInput.mouseY+5, color);
					Rasterizer2D.drawLine(MouseInput.mouseX+5, MouseInput.mouseY-5, MouseInput.mouseX-5, MouseInput.mouseY+5, color);
					lastbtn = 0;
				}
				
				//Rasterizer2D.drawRect(10, 20, 100, 200, 0xcaa600);
				//Rasterizer2D.draw(10, 20, 100, 200, 0xcaa600);
				//Rasterizer2D.drawLine(MouseInput.mouseX, MouseInput.mouseY, 10, 10, 0xff0000);
			}
		}
	}
}
