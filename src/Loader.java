import java.applet.AppletContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Image;
import java.util.List;
import java.util.Arrays;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Component;
import javax.swing.JFrame;
import java.util.HashMap;
import java.util.Map;
import java.applet.AppletStub;

// 
// Decompiled by Procyon v0.5.36
// 

public class Loader implements AppletStub
{
    static final boolean CONNECT_TO_OSRS = false;
    static final int BUILD = 171;
    static final int UPDATE_SERVER_SUB_BUILD = 1;
    static final int WORLD_SERVER_SUB_BUILD;
    static SpritePixels bmIcon;
    static SpritePixels bankIcon;
    static SpritePixels bloodMoneySurvivalIcon;
    static SpritePixels dicingIcon;
    static SpritePixels donatorIcon;
    static SpritePixels eventIcon;
    static SpritePixels heartIcon;
    static SpritePixels helpIcon;
    static SpritePixels petIcon;
    static SpritePixels transportationIcon;
    static SpritePixels prayerIcon;
    static SpritePixels ironmanIcon;
    static SpritePixels bountyHunterIcon;
    static SpritePixels minigameIcon;
    static SpritePixels pollBoothIcon;
    static SpritePixels slayerIcon;
    static SpritePixels coinIcon;
    static SpritePixels poolIcon;
    static SpritePixels portalcon;
    static SpritePixels thievingIcon;
    static final boolean CHRISTMAS = true;
    static final boolean HALLOWEEN = false;
    private static boolean LOCAL_HOST;
    public static boolean RUNITE;
    public static String SERVER_NAME;
    public static String WEBSITE_URL;
    static final String FS_HOST;
    static final String GS_HOST;
    public static final int FS_PORT = 7304;
    public static final int GAME_PORT = 7306;
    private final Map<String, String> map;
    public static JFrame frame;
    
    public Loader() {
        this.map = new HashMap<String, String>();
    }
    
    public static void updateWorld() {
        WorldType.active = WorldType.ECO;
    }
    
    public static void main(final String[] args) throws Exception {
        final Loader loader = new Loader();
        loader.initialize();
        final Game game = new Game();
        frame = new JFrame("Runite - There is still hope!");
        frame.add(game);
        frame.setSize(781, 541);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
        try {
            frame.setIconImages(Arrays.asList(ImageIO.read(Loader.class.getResource("/img/icon-48.png")), ImageIO.read(Loader.class.getResource("/img/icon-16.png"))));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        game.setStub(loader);
        game.init();
        class54.host = Loader.GS_HOST;
        Game.world = ((!Loader.LOCAL_HOST || true) ? 1 : 0);
        Game.flags = 33;
        WorldType.active = WorldType.ECO;
        try {
            Game.DISCORD_PRESENCE.initiate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        catch (Error e2) {
            e2.printStackTrace();
        }
        new Thread(new InformationBot(game)).start();
        game.start();
    }
    
    private void initialize() {
        this.map.put("10", "ElZAIrq5NpKN6D3mDdihco3oPeYN2KFy2DCquj7JMmECPmLrDP3Bnw");
        this.map.put("9", "false");
        this.map.put("16", "0");
        this.map.put("7", "true");
        this.map.put("8", "0");
        this.map.put("1", ".runescape.com");
        this.map.put("13", "377");
        this.map.put("14", "true");
        this.map.put("4", "1");
        this.map.put("2", "34189");
        this.map.put("6", "1");
        this.map.put("3", "0");
        this.map.put("5", "https://runite.io/extra/data/worlds.ws?order=LPWM");
        this.map.put("15", "5");
        this.map.put("12", "");
        this.map.put("11", "0");
    }
    
    @Override
    public String getParameter(final String paramName) {
        return this.map.get(paramName);
    }
    
    @Override
    public URL getDocumentBase() {
        return this.getCodeBase();
    }
    
    @Override
    public URL getCodeBase() {
        try {
            return new URL("http://" + Loader.FS_HOST);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public boolean isActive() {
        return true;
    }
    
    @Override
    public AppletContext getAppletContext() {
        return null;
    }
    
    @Override
    public void appletResize(final int width, final int height) {
    }
    
    static {
        WORLD_SERVER_SUB_BUILD = (WorldType.isPVP() ? 17 : 24);
        Loader.LOCAL_HOST = false;
        Loader.RUNITE = false;
        Loader.SERVER_NAME = (Loader.RUNITE ? "Runite" : "EndlessPK");
        Loader.WEBSITE_URL = (Loader.LOCAL_HOST ? "localhost" : "runite.io");
        FS_HOST = (Loader.LOCAL_HOST ? "127.0.0.1" : "54.39.29.104");
        GS_HOST = (Loader.LOCAL_HOST ? "127.0.0.1" : "54.39.29.104");
    }
}
