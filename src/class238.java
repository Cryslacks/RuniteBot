// 
// Decompiled by Procyon v0.5.36
// 

public class class238
{
    static void worldToScreen(int x, int y, final int z) {
        if (x >= 128 && y >= 128 && x <= 13056 && y <= 13056) {
            int sumZ = WorldMapType2.getTileHeight(x, y, class13.plane) - z;
            x -= CacheFile.cameraX;
            sumZ -= SceneTilePaint.cameraZ;
            y -= Coordinates.cameraY;
            final int int_4 = Graphics3D.SINE[class7.cameraPitch];
            final int int_5 = Graphics3D.COSINE[class7.cameraPitch];
            final int int_6 = Graphics3D.SINE[DynamicObject.cameraYaw];
            final int int_7 = Graphics3D.COSINE[DynamicObject.cameraYaw];
            int int_8 = int_6 * y + x * int_7 >> 16;
            y = int_7 * y - x * int_6 >> 16;
            x = int_8;
            int_8 = int_5 * sumZ - int_4 * y >> 16;
            y = sumZ * int_4 + int_5 * y >> 16;
            if (y >= 50) {
                Game.screenX = x * Game.scale / y + Game.viewportWidth / 2;
                Game.screenY = int_8 * Game.scale / y + Game.viewportHeight / 2;
            }
            else {
                Game.screenX = -1;
                Game.screenY = -1;
            }
        }
        else {
            Game.screenX = -1;
            Game.screenY = -1;
        }
    }
}
